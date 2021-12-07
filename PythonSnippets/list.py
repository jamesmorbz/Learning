## EVERYTHING INDEXES FROM 0 IN PYTHON. THIS IS VERY IMPORTANT.
list = ["a", "b" , "c", "e"]
print(type(list))
print(list)

list.append("d") # append = add item to the end of my list
print(list)
list.remove("c") # remove specified item
print(list)
list.remove(list[2])
print(list)

for item in list: # "item" can be anything as long as it's consistant. Look below
    print(item)

for random in list: # here it is "random" instead of "item"
    if random == "b":
       print(True)
    else:
        print(False)

index = list.index("d") # gets index of value "c"
print(index)