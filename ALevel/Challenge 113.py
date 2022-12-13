import csv

with open('books.csv','r')as f:
       freader = csv.reader(f, delimiter=',') 
       for row in freader:
        print(', '.join(row))



#value = int(input("How many records would you like to add?"))
#book = input("Enter Book Title")
#author = input("Enter Author")
#year = int(input("Enter Year released"))
#rec5 = book + ','+ author + ',' + str(year)+'\n'


