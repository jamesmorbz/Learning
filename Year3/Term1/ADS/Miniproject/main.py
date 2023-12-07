class STNode:
    def __init__(self,d):
        self.data = d
        self.left = self.right = self.mid = None
        self.mult = 0
        self.dlistPtr = None
        self.parent = None

    # performs BST search for d starting from d. If d is not in the
    # tree, it returns the parent node of where it should have been
    def bin_search(self, d):
        if self.data == d: return self
        if self.data > d: 
            if self.left == None: return self
            return self.left.bin_search(d)
        if self.data < d: 
            if self.right == None: return self
            return self.right.bin_search(d)
        assert(0) # should not get here    

    # prints the node's data and multiplicity
    def __str__(self):
        return "("+str(self.data)+", "+str(self.mult)+")"   

    # returns string corresponding to node
    def strFromTop(self):
        ptr = self
        s = str(self.data)
        while ptr.parent != None and ptr.parent.mid != ptr:
            ptr = ptr.parent
        if ptr.parent == None: return s
        return ptr.parent.strFromTop()+s
   
    # prints the node and all its children in a string
    def strTree(self):  
        st = "("+str(self.data)+", "+str(self.mult)+")"
        if self.left == self.mid == self.right == None: return st
        st += " -> ["
        if self.left != None:
            st += self.left.strTree()
        else: st += "□"
        if self.mid != None:
            st += ", "+self.mid.strTree()
        else: st += ", □"
        if self.right != None:
            st += ", "+self.right.strTree()
        else: st += ", □"
        return st + "]"
    
class StringTree:
    def __init__(self):
        self.root = None
        self.size = 0
        self.dlist = DLinkedList()
        
    def __str__(self):
        if self.root == None: return "empty"
        return self.root.strTree()

    def add(self,st):
        if st == "": return
        dlistPtr = self.updateDList(st)
        if self.root == None: 
            self.root = STNode(st[0])
        ptr = self.root
        for i in range(len(st)):
            char = st[i]
            found_node = ptr.bin_search(char)
            if char < found_node.data:
                found_node.left = STNode(char)
                found_node.left.parent = found_node
                ptr = found_node.left
            elif char > found_node.data:
                found_node.right = STNode(char)
                found_node.right.parent = found_node
                ptr = found_node.right
            else:
                ptr = found_node
            # after the ith character is put into place, we move ptr
            # one level below 
            if i < len(st)-1:
                if ptr.mid == None:
                    ptr.mid = STNode(st[i+1])
                    ptr.mid.parent = ptr
                ptr = ptr.mid
        ptr.mult += 1
        if ptr.mult == 1: 
            ptr.dlistPtr = dlistPtr
        self.size += 1
    
    def addAll(self,A):
        for x in A: self.add(x)

    def printElems(self):
        ptr = self.dlist.head
        st = ""
        while ptr != None:
            st += ptr.data
            if ptr.next != None:
                st += ", "
            ptr = ptr.next
        print(st)

    # returns the smallest string in the tree (None if tree empty)
    def min(self):
        if self.root == None: return None
        return self._min(self.root).strFromTop()

    # returns the lexicographically minimal node in the tree rooted at node
    def _min(self, node):
        ptr = node
        while True: 
            while ptr.left != None: ptr = ptr.left
            if ptr.mult > 0: return ptr 
            ptr = ptr.mid
            
    # returns the largest string in the tree (None if tree empty)
    def max(self):
        if self.root == None: return None
        return self._max(self.root).strFromTop()
    
    # returns the lexicographically maximal node in the tree rooted at node
    def _max(self, node):
        ptr = node
        while True:
            while ptr.right is not None:
                ptr = ptr.right

            if ptr.mid is not None:
                ptr = ptr.mid
            else:
                return ptr

    # returns the number of times that string st is stored in the tree
    def count(self, st):
        """
        Returns the number of times that the string 'st' is stored in the tree.
        """
        return self._count(self.root, st)

    def _count(self, node, st):
        """
        Helper function to recursively count the occurrences of 'st' in the subtree rooted at 'node'.
        """
        if node is None:
            return 0
        if node.data == st[0]:
            if len(st) == 1:
                return node.mult
            return self._count(node.mid, st[1:])
        elif node.data > st[0]:
            return self._count(node.left, st)
        else:
            return self._count(node.right, st)
    
    # insert st in doubly linked list and return pointer to new list node
    # inefficient version
    def updateDList(self, st):
        if self.dlist.length == 0:
            return self.dlist.insertLeft(st,None)
        ptr = self.dlist.head
        while ptr != None and ptr.data < st:
            ptr = ptr.next
        if ptr == None:
            return self.dlist.append(st)
        if ptr.data == st: return None
        return self.dlist.insertLeft(st,ptr)
        
    # returns the smallest string in the tree
    # that is larger than st. If no such string exists, return None
    def succ(self, st): 
        # TODO
        return None
        
    # returns the largest string in the tree
    # that is smaller than st. If no such string exists, return None
    def pred(self, st): 
        # TODO
        return None
    
    # removes one occurrence of string st from the tree and returns None
    # if st does not occur in the tree then it returns without changing the tree
    # it updates the size of the tree accordingly
    def remove(self, st):
        if self.root is None:
            return None

        node_to_remove = self._remove_helper(st, self.root)

        if node_to_remove is not None:
            node_to_remove.mult -= 1
            self.size -= 1

            if node_to_remove.mult == 0 and node_to_remove.mid is None:
                self._remove_node(node_to_remove)

            # Manually update the dlistPtr if the node is still in the tree
            if node_to_remove.mult > 0 and node_to_remove.dlistPtr is not None:
                node_to_remove.dlistPtr = self.updateDList(st)




    def _remove_helper(self, st, node):
        if node is None:
            return None

        if st < node.data:
            return self._remove_helper(st, node.left)
        elif st > node.data:
            return self._remove_helper(st, node.right)
        else:  # st == node.data
            return node

    def _remove_node(self, node):
        if node is None:
            return

        if node.left is None and node.right is None:
            self._remove_leaf(node)
        elif node.left is not None and node.right is None:
            self._remove_node_with_left_child(node)
        elif node.left is None and node.right is not None:
            self._remove_node_with_right_child(node)
        else:
            # node has both left and right children
            # replace the node with its in-order successor
            successor = self._find_min(node.right)
            node.data, successor.data = successor.data, node.data
            node.dlistPtr = successor.dlistPtr  # Update the dlist pointer
            self._remove_node(successor)

    def _remove_leaf(self, node):
        if node.parent is None:
            self.root = None
        elif node.parent.left == node:
            node.parent.left = None
        elif node.parent.right == node:
            node.parent.right = None

    def _remove_node_with_left_child(self, node):
        if node.parent is None:
            self.root = node.left
            node.left.parent = None
        elif node.parent.left == node:
            node.parent.left = node.left
            node.left.parent = node.parent
        elif node.parent.right == node:
            node.parent.right = node.left
            node.left.parent = node.parent

    def _remove_node_with_right_child(self, node):
        if node.parent is None:
            self.root = node.right
            node.right.parent = None
        elif node.parent.left == node:
            node.parent.left = node.right
            node.right.parent = node.parent
        elif node.parent.right == node:
            node.parent.right = node.right
            node.right.parent = node.parent

    def _find_min(self, node):
        while node.left is not None:
            node = node.left
        return node
        
    # insert st in doubly linked list and return pointer to new list node
    # efficient version
    def updateDList2(self, st):
        # TODO
        return None

class DNode:
    def __init__(self, d, n, p):
        self.data = d
        self.next = n
        self.prev = p

    def __str__(self):
        return str(self.data)
        
class DLinkedList:
    def __init__(self):
        self.head = self.tail = None
        self.length = 0

    # inserts a node to the left of n with data d and returns it. 
    # If it is an empty list, it does not matter what n is, 
    # we create just one node.
    def insertLeft(self, d, n):
        self.length += 1
        
        if self.length == 1: 
            self.head = DNode(d, None, None)
            self.tail = self.head
            return self.head

        np = n.prev
        n.prev = DNode(d, n, np)
        if np == None:
            self.head = n.prev
        else:
            np.next = n.prev
        return n.prev

    # inserts node with d at tail of list and returns it
    def append(self, d):
        if self.length == 0:
            return self.insertLeft(d,None)
        self.length += 1
        self.tail.next = DNode(d, None, self.tail)
        self.tail = self.tail.next
        return self.tail
        
    # removes node n off the list
    def remove(self, n): 
        self.length -= 1
        if n.prev == None:
            if n.next != None: n.next.prev = None
            self.head = n.next
            return
        if n.next == None:
            n.prev.next = None
            self.tail = n.prev
            return
        n.prev.next = n.next
        n.next.prev = n.prev

    def __str__(self):
        if self.head == None: 
            return "empty"
        st = "-"
        ptr = self.head
        while ptr != None:
            st += "-> "+str(ptr)+" "
            ptr = ptr.next
        return st+"|"
    

def testprint(t,message,step):
    print("\n"+step,":",message,"tree is:\n",t)
    print("Count 'ca', 'can', 'car', 'cat', 'cats':",t.count("ca"),\
    t.count("can"),t.count("car"),t.count("cat"),t.count("cats"))
    print("Size is:",t.size,", elements: ",end="")
    t.printElems()
    print("Min and Max strings:",t.min(),t.max())
    print("Predecessors: '':",t.pred(""),", can:",t.pred("can"),",\
    car:",t.pred("car"),", cat:",t.pred("cat"),", z:",t.pred("z"))

if __name__ == "__main__":
    t = StringTree()
    t.addAll(["car","can","cat","cat","cat"])
    testprint(t,"Initially","0")
    t.add("")
    testprint(t,"After adding the empty string","1")
    t.add("ca")
    testprint(t,"After adding 'ca'","2")
    t.remove("car")
    testprint(t,"After removing 'car'","3")
    # t.remove("cat"); t.remove("cat")
    # testprint(t,"After removing 'cat' twice","4")
    # t.remove("ca"); t.add("cats")
    # testprint(t,"After removing 'ca' and adding 'cats'","5")
    # t.remove("can"); t.remove("cats"); t.remove("cat")
    # testprint(t,"After removing 'can', 'cats' and 'cat'","6")