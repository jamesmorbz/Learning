list =[]

while True:
    menu = int(input('''1) Add a name to the list
2) Change a name on the list
3) Delete a name on the list
4) View the list
5) End the program

: '''))
    if menu not in [1, 2, 3, 4, 5]:
        print('Please enter 1, 2, 3, 4 or 5 from the menu')
    elif menu == 1:
        name = input('What name would you like to add? ')
        list.append(name)
    elif menu == 2:
        while True:
            name = input('What name would you like to change? ')
            if name not in list:
                print('That name is not in the list')
            else:
                changeName = input('What would you like to change the name to? ')
                list[list.index(name)] = changeName
                break
    elif menu == 3:
        while True:
            name = input('What name would you like to delete? ')
            if name not in list:
                print('That name is not in the list')
            else:
                del list[list.index(name)]
                break
    elif menu == 4:
        for name in list:
            print(name)
    elif menu == 5:
        break
