import csv
f=open('books.csv','a')
book=input("Enter Book Title")
author=input("Enter Author")
year=int(input("Enter Year released"))
rec5=book + ','+ author + ',' + str(year)+'\n'

f.write(rec5)
f.close()
