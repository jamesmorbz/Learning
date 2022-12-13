import csv

with open('books.csv', 'r') as f:
    reader = csv.reader(f, delimiter=',')
    i = 0
    for row in reader:
        print('row ' + str(i) + ': ' + str(row))
        i += 1
