def recurse_oxy(strings):
    if len(strings) == 1:
        return strings[0]
    if len(strings) <= 2:
        return max(strings[0], strings[1])
    else:
        bit_dict = {'1': 0, '0': 0}
        for string in strings:
            bit_dict[string[0]] += 1
        if bit_dict['1'] >= bit_dict['0']:
            new_strings = [i[1:] for i in strings if i[0] == '1']
            return '1' + recurse_oxy(new_strings)
        else:
            new_strings = [i[1:] for i in strings if i[0] == '0']
            return '0' + recurse_oxy(new_strings)

def recurse_co2(strings):
    if len(strings) == 1:
        return strings[0]
    if len(strings) <= 2:
        return max(strings[0], strings[1])
    else:
        bit_dict = {'1': 0, '0': 0}
        for string in strings:
            bit_dict[string[0]] += 1
        if bit_dict['1'] > bit_dict['0']:
            new_strings = [i[1:] for i in strings if i[0] == '0']
            return '0' + recurse_co2(new_strings)
        else:
            new_strings = [i[1:] for i in strings if i[0] == '1']
            return '1' + recurse_co2(new_strings)

with open("E:\QMULwork\AdventOfChristmas2021\Day3Input.txt") as f:
    all = list(f.read().splitlines())
    boxy = recurse_oxy(all)
    bco2 = recurse_co2(all)
    oxy = int(boxy, 2)
    co2 = int(bco2, 2)
    print(boxy, oxy)
    print(bco2, co2)
    print(oxy * co2)

    
# 111101010001 = 3921
# 001101001011 = 843

# 3305403