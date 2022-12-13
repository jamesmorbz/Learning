total=int(input("How much did you spend? "))
if total > 10:
    newtotal=(total*0.8)
    print("Discount is 20%")
    print("The new total is " + str(newtotal))
else:
    newtotal_1=(total*0.9)
    print("Discount is 10%")
    print("The new total is " + str(newtotal_1))
