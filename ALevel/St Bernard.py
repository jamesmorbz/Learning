size = int(input("Enter size of transfer in megabytes:  "))
distance = int(input("Enter distance to the destination in miles:  "))
time = int(input("Enter time data will be ready to send as HHMM:  "))
hours = time // 100
print(hours,"hours")
mins = time - (hours * 100)
print(mins,"mins")


#St Bernard's Time to Deliver

if distance > 3000:
    print("Too far for doggy")
    elapsedmins1 = 0
    print(elapsedmins1)
elif size > 600000:
    print("Too much to carry for doggy")
    elapsedmins1 = 0
    print(elapsedmins1)
else:
    elapsedmins1 = distance * 15
    print("It will take doggy",elapsedmins1,"mins to complete")
    
#T-3

megabytes = (45 / 8)*60
elapsedmins = size / megabytes
print(elapsedmins,"is time taken (mins) to transfer",size,"megabytes of data"

#FedEx

if time < 1800:
    today = True
    print("You can make today's delivery")
else:
    today = False
    print("You must wait for tomorrow's delivery")

def smallest(elapsedmins, elapsedmins1, elapsedmins2):
    if (elapsedmins < elapsedmins1) and (elapsedmins < elapsedmins2):
        smallest_num = elapsedmins
    elif (elapsedmins1 < elapsedmins) and (elapsedmins1 < elapsedmins2):
        smallest_num = elapsedmins1
    else:
        smallest_num = elapsedmins2
    print("The fastest time for transfer is : ", smallest_num)
