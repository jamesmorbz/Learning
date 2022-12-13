numbers = []
count = 0
while count <3:
    inputnum = int(input("Enter a number: "))
    numbers.append(numbers)
    print(numbers)
    count = count + 1
lastnumber = input("Do you want the last number to be saved")
if lastnumber == "n":
    numbers.remove(numbers)
print(numbers)
