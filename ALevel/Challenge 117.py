import csv
import random

name = input('Enter your name: ')
q1 = ['What is 2 + 2?', 'What is 4 / 2?', 'What is 2 * 4?']
q2 = ['What is 5 ** 2?', 'What is 40 * 3?', 'What is (17 - 2) * 2']
randq1 = random.choice(q1)
randq2 = random.choice(q2)

if randq1 == q1[0]:
    ans1 = 4
elif randq1 == q1[1]:
    ans1 = 2
elif randq1 == q1[2]:
    ans1 = 8

if randq2 == q2[0]:
    ans2 = 25
elif randq2 == q2[1]:
    ans2 = 120
elif randq2 == q2[2]:
    ans2 = 30

qans1 = int(input(randq1 + ' '))
qans2 = int(input(randq2 + ' '))
score = 0

if qans1 == ans1:
    score += 1
if qans2 == ans2:
    score += 1

with open('mathQuiz.csv', 'a+') as f:
    f.write(name + ',' + randq1 + ',' + str(ans1) + ',' + str(qans1) + ',' + randq2 + ',' + str(ans2) + ',' + str(qans2) + ',' + str(score) + '\n')
