def askNum():
    num = int(input('Enter a number: '))
    return num

def countToNum(num):
    for i in range(0, num):
        print(i)

countToNum(askNum())
