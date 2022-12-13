import random
dice =  random.randint(1,6)

consent = input("Would you like to roll the dice (y/n) ")
if consent == 'n':
    ()
else:
    print("Your random number is " + str(dice))
consentnum=int(input("How many more times would you like to roll the dice? "))
if consentnum == 0:
    print("Goodbye")
else:
   dice1=random.sample(range(1,6),consentnum)
print(str(dice1))

