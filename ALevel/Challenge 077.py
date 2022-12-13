name1=input("Enter a name of someone you invite: ")
name2=input("Enter a name of someone you invite: ")
name3=input("Enter a name of someone you invite: ")
party=[name1,name2,name3]
anymore=input("Do you want to invite another (y/n): ")

if anymore == "y":
    newperson=input("How else wouldn you like to invite")
    newparty=[name1,name2,name3,newperson]
    print("The people that are coming to your party" + str(newparty))
    party=newparty
else:
    print("The people that are coming to your party" + str(party))
who = input("Enter one of the names: ")
print(who,"is",(party.index(who)+1),"on the list")
stillcome = input("Do you still want them to come (y/n): ")
if stillcome == "n":
    party.remove(who)
print("Your birthday invites are to",party)
