y = 10 
z = 100 
x = 'sam' # assignment (and declaration)

if z == 100: #comparison     
    print('hello') 
if y != 11: #not equal to     
    print('there')           
          #same level as if statement continues 
if x == 'Sam':     
    print('sup baby') 
elif x=='sam':     
    print('rah') 
else:     
    pass #do nothin (needs to be in indentation)

b = {"key":"value"} # dictionary
c = {"name" : "sam", "lastname":"whiteside", "firstname":"james"} # KEYS MUST BE UNIQUE, VALUES CAN BE THE SAME. IF you have the same key the value will be overwritten.

print(c.keys())
print(c.values())

x = 0 # reassinging x

while x <= 3: # while condition is satisfied do THING
    print("x is less than 3") # THING
    x = x + 1 # OR x += 1

a = [1,2,3,4,5] # list

index_three = a[3]
print("Element at index 3 of the list is " + str(index_three)) # LISTS INDEX FROM 0 - This gets the 4th item from the list

length_of_list = len(a) # how many items are in the list
print("length of list is " + str(length_of_list))

print("For Loop:")

for item in a: # "item" can be interchanged, it's a placeholder!
    print(item)

print("Range 1:")
for n in range(0,10): # 0-9, 10 is exclusive
    print(n)

print("Range 2:")
for n in range(0,11,2): # 0-10 in steps on 2
    print(n)

g = 10
g = g - 3 # sub
g = g + 3 # add
g = g * 3 # multiply
g = g / 3 # divide
g = g ** 2 # power
g = g ** -2
g = g % 3 # modulo 10/3 remainder = 1