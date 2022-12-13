import csv

while True:
    menu = int(input('''1) Add to file
2) View all records
3) Delete a record
4) Quit the program

Enter the number of your selection: '''))
    if menu not in [1, 2, 3, 4]:
        print('Please enter 1, 2, 3 or 4')
    elif menu == 1:
        with open('salaries.csv', 'a+') as f:
            name = input('Enter the name: ')
            salary = input('Enter the salary: ')
            f.write(name + ',' + salary + '\n')
    elif menu == 2:
        with open('salaries.csv', 'r') as f:
            reader = csv.reader(f, delimiter=',')
            for row in reader:
                print(row)
    elif menu == 3:
        with open('salaries.csv', 'r') as f:
            reader = csv.reader(f, delimiter=',')
            list = []
            i = 0
            for row in reader:
                list.append(row)
                print('Row ' + str(i) + ': ' + str(row))
                i += 1
        while True:
            delRec = int(input('Enter a row number to delete: '))
            if delRec < 0 or delRec > len(list):
                print('That is not a row number')
            else:
                break
        del list[delRec]

        with open('salaries.csv', 'w') as f:
            for row in list:
                f.write(row[0] + ',' + row[1] + '\n')
    elif menu == 4:
        break
