def dispense_change(change: int):
    # This function takes in the amount of change that is due and calls the calculate_coin_count function
    one_penny, two_pence, five_pence, ten_pence, twenty_pence, fifty_pence = calculate_coin_count(change)
    return one_penny, two_pence, five_pence, ten_pence, twenty_pence, fifty_pence

def calculate_coin_count(change: int):
    # This function calls all the specific coin functions to calculate the number of each coin denomination and returns them and the remaining change
    remaining_change = change
    fifty_pence, remaining_change = calculate_fifty_pence(remaining_change)
    twenty_pence, remaining_change = calculate_twenty_pence(remaining_change)
    ten_pence, remaining_change = calculate_ten_pence(remaining_change)
    five_pence, remaining_change = calculate_five_pence(remaining_change)
    two_pence, remaining_change = calculate_two_pence(remaining_change)
    one_penny, remaining_change = calculate_one_penny(remaining_change)
    return one_penny, two_pence, five_pence, ten_pence, twenty_pence, fifty_pence

def calculate_one_penny(change: int):
    '''
    calculate_one_penny(1)
    returns 1,0

    calculate_one_penny(0)
    returns 0,0 
    '''
    # This function calculates the number of one penny coins required for the given change
    number_of_coins = change % 2
    new_change_value = (change - number_of_coins*1)
    return number_of_coins, new_change_value

def calculate_two_pence(change: int):
    '''
    calculate_two_pence(2)
    returns 1,0
    
    calculate_two_pence(1)
    returns 0,1 
    '''
    # This function calculates the number of two pence coins required for the given change
    number_of_coins = change // 2
    new_change_value = (change - number_of_coins*2)
    return number_of_coins, new_change_value

def calculate_five_pence(change: int):
    '''
    calculate_five_pence(3)
    returns 0,3
    
    calculate_five_pence(8)
    returns 1,3
    '''
    # This function calculates the number of five pence coins required for the given change
    number_of_coins = change // 5
    new_change_value = (change - number_of_coins*5)
    return number_of_coins, new_change_value

def calculate_ten_pence(change: int):
    '''
    calculate_ten_pence(3)
    returns 0,3
    
    calculate_ten_pence(27)
    returns 2,7
    '''
    # This function calculates the number of ten pence coins required for the given change
    number_of_coins = change // 10
    new_change_value = (change - number_of_coins*10)
    return number_of_coins, new_change_value

def calculate_twenty_pence(change: int):
    '''
    calculate_twenty_pence(3)
    returns 0,3
    
    calculate_twenty_pence(27)
    returns 1,7
    '''
    # This function calculates the number of twenty pence coins required for the given change
    number_of_coins = change // 20
    new_change_value = (change - number_of_coins*20)
    return number_of_coins, new_change_value

def calculate_fifty_pence(change: int):
    '''
    calculate_fifty_pence(2)
    returns 0,2
    
    calculate_fifty_pence(63)
    returns 1,13
    '''
    # This function calculates the number of fifty pence coins required for the given change
    number_of_coins = change // 50
    new_change_value = (change - number_of_coins*50)
    return number_of_coins, new_change_value

def main():
    change = 86
    if change > 99:
        print("Change must be below 99")
    else:
        one_penny, two_pence, five_pence, ten_pence, twenty_pence, fifty_pence = dispense_change(change)
        print(f"Change: {change}p")
        print(f"1p: {one_penny}")
        print(f"2p: {two_pence}")
        print(f"5p: {five_pence}")
        print(f"10p: {ten_pence}")
        print(f"20p: {twenty_pence}")
        print(f"50p: {fifty_pence}")

if __name__ == '__main__':
    main()
