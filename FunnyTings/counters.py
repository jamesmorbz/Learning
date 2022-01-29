list_1 = [1,2,3,4,5]
list_2 = ["a","b","c","d","e"]

i = 0

for value in list_1:
    if value == list_2[i]:
        print(True)
    i += 1

# WHAT SHE COULD HAVE DONE

for counter, value in enumerate(list_1):
    if value == list_2[counter]:
        print(True)

    # OR

    if value in list_2:
        print(True)