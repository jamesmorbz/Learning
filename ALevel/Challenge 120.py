import random

def addition():
    randNum1 = random.randint(5, 20)
    randNum2 = random.randint(5, 20)
    user = int(input('What is ' + str(randNum1) + '+' + str(randNum2) + '? '))

    return user, randNum1 + randNum2

def subtraction():
    randNum1 = random.randint(25, 50)
    randNum2 = random.randint(1, 25)
    user = int(input('What is ' + str(randNum1) + '-' + str(randNum2) + '? '))

    return user, randNum1 - randNum2

def checkCalc(user, ans):
    if user == ans:
        print('You are correct!')
    else:
        print('You are incorrect, the answer was ' + str(ans))

while True:
    menu = int(input('''1) Addition
    2) Subtraction
    Enter 1 or 2: '''))

    if menu == 1:
        user, ans = addition()
        checkCalc(user, ans)
    elif menu == 2:
        user, ans = subtraction()
        checkCalc(user, ans)
    else:
        print('Please only enter 1 or 2')
