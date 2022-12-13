totalbill=int(input("How much was the meal?   "))
diners=int(input("How many people are there at the table?  "))
ppp=round(totalbill/diners, 2)

if(totalbill%diners==0):
   ppp=int(ppp)

print ("Each person should pay",'£' +str(ppp))
