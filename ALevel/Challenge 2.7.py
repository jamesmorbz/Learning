number = int(input("What times table would you like?"))
print("Here is the " + str(number) + " times table")

for i in range (1,13):
    print(number,'x',i,'=',number*i)
