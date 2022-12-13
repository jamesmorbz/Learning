import csv

with open('books.csv', 'r') as f:
    reader = csv.reader(f, delimiter=',')
    list = []
    i = 0
    for row in reader:
        list.append(row)
        print('Row ' + str(i) + ': ' + str(row))
        i += 1

    while True:
        delRow = int(input('Which row would you like to delete? '))
        if delRow > len(list) or delRow < 0:
            print('That row does not exist')
        else:
            break

    del list[delRow]

    while True:
        changeRow = int(input('Which row would you like to change? '))
        if changeRow > len(list) or changeRow < 0:
            print('That row does not exist')
        else:
            break

    print(list[changeRow])
    while True:
        editRow = input('What would you like to change? (book, author or year): ').lower()
        if editRow not in ['book', 'author', 'year']:
            print('You cannot edit that')
        else:
            break

    if editRow == 'book':
        editRow = 0
    elif editRow == 'author':
        editRow = 1
    elif editRow == 'year':
        editRow = 2
    updateRow = input('What would you like to change that too? ')
    list[changeRow][editRow] = updateRow

with open('books.csv', 'w') as f:
    for row in list:
        f.write(row[0] + ',' + row[1] + ',' + row[2] + '\n')
