import random

def randNum():
    num1 = int(input('Enter a low number: '))
    num2 = int(input('Enter a high number: '))

    comp_num = random.randint(num1, num2)

    return comp_num

def guessNum():
    guess = int(input('I am thinking of a number, can you guess it? '))
    return guess

def checkNum():
    comp_num = randNum()
    while True:
        guess = guessNum()
        if guess == comp_num:
            print('You are correct!')
            break
        elif guess > comp_num:
            print('You are guessing too high')
        elif guess < comp_num:
            print('You are guessing too low')

checkNum()
