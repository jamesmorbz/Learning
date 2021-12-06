import pprint

forward = 0
height_change = 0
i = 0

list = []
with open('E:\QMULwork\AdventOfChristmas2021\Day2Input.txt') as inputs:
  for line in inputs:
    direction = line.split(" ")[0]
    value = line.split(" ")[1]
    line = [direction, value.split("\n")[0]]
    list.append(line)

while i < len(list):

    if list[i][0] == "forward":
        forward += int(list[i][1])
    elif list[i][0] == "down":
        height_change -= int(list[i][1])
    if list[i][0] == "up":
        height_change += int(list[i][1])

    i += 1

answer = height_change * forward
if answer < 0:
    answer = answer * -1
print("Gone forward %s steps" % forward)
print("Height changed by %s" % height_change)
print("Answer = %i" % answer)