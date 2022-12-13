pennies=(int(input("How many pennies")))
pences=(int(input("How many 2 pences")))
pences5=(int(input("How many 5 pences")))
total=(pennies)+(pences*2)+(pences5*5)

print("You have " +str(total)+" pence")

if total >= 5000:
    print("You are saving well")
else:
    print("You should save more!")
