import pprint

forward = 0
aim = 0
depth = 0
i = 0

list = []
with open('E:\QMULwork\AdventOfChristmas2021\Day2Input.txt') as inputs:
  for line in inputs:
    direction = line.split(" ")[0]
    value = line.split(" ")[1]
    line = [direction, value]
    list.append(line)

while i < len(list):

    if list[i][0] == "forward":
        forward += int(list[i][1])
        depth += int(list[i][1])*aim
    elif list[i][0] == "down":
        aim += int(list[i][1])
    if list[i][0] == "up":
        aim -= int(list[i][1])

    i += 1

answer = depth * forward
if answer < 0:
    answer = answer * -1
print("Gone forward %s steps" % forward)
print("Depth = %s" % depth)
print("Answer = %i" % answer)