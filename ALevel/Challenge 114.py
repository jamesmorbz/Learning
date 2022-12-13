import csv

with open('books.csv','r')as f:
       freader = csv.reader(f, delimiter=',') 
       for row in freader:
        print(', '.join(row))
start=int(input("Enter a starting year"))
end=int(input("Enter an end year"))

f= list(csv.reader("Books.csv"))
tmp=[]
for row in tmp:
    tmp.read(row)
counter=0
for row in tmp:
    if int(tmp[counter][2]) >= start and int(tmp[counter][2]) <=end:
        print(time[counter])
