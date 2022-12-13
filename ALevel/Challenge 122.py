import csv

while True:
    menu = int(input('''1) Add to file
2) View all records
3) Quit the program

Enter the number of your selection: '''))
    if menu not in [1, 2, 3]:
        print('Please enter 1, 2 or 3')
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
        break
