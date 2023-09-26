class Person():
    def __init__(self, name, age):
        self.name = name
        self.age = age
        print(f"I made a person {self.personal_name()}")
    
    def personal_name(self):
        return self.name
    
def find_index(array, element):
    index = -1
    for counter, el in enumerate(array):
        if el == element:
            index = counter
            break
    return index

def find_index2(array, element):
    if element not in array:
        return -1
    else:
        return array.index(element)

def main():
    array = [1, 2, 3, 4, 5]
    el = 3
    print(find_index(array, el))
    print(find_index2(array, el))
    
    l1 = []
    for i in range(1,10):
        num = i ** 2
        l1.append(num)
    
    l1 = [i**2 for i in range(1,10)]
    l2 = {i:i**2 for i in range(1,10)}
    print(l2)
    
    
    WILL = Person("Will", 20)
    print(WILL.age, WILL.name)    
    
    
if __name__ == "__main__":
    main()    