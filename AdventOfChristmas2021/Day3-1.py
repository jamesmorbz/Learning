gamma_rate = ""
epsilon_rate = ""
position_1 = ""
position_2 = ""
position_3 = ""
position_4 = ""
position_5 = ""
position_6 = ""
position_7 = ""
position_8 = ""
position_9 = ""
position_10 = ""
position_11 = ""
position_12 = ""

list = []
with open('E:\QMULwork\AdventOfChristmas2021\Day3Input.txt') as inputs:
  for line in inputs:
    list.append(line)

for item in list:
    position_1 += item[0]
    position_2 += item[1]
    position_3 += item[2]
    position_4 += item[3]
    position_5 += item[4]
    position_6 += item[5]
    position_7 += item[6]
    position_8 += item[7]
    position_9 += item[8]
    position_10 += item[9]
    position_11 += item[10]
    position_12 += item[11]
    
position_list = [position_1, position_2, position_3, position_4, position_5, position_6, position_7, position_8,
                 position_9, position_10, position_11, position_12]

counter_1 = 0
counter_0 = 0

for item in position_list:
    counter_1 = item.count("1")
    counter_0 = item.count("0")
    if counter_1 >= counter_0:
        gamma_rate += "1"
        epsilon_rate += "0"
    else:
        gamma_rate += "0"
        epsilon_rate += "1"
print(gamma_rate)
print(epsilon_rate)
gamma_rate = int(gamma_rate,2)
epsilon_rate = int(epsilon_rate,2)
answer = gamma_rate * epsilon_rate
print(answer)

#Num 1 = 110100010101
#Num 2 = 001011101010
#2498354