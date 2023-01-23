def get_checksum(word: str):
    # Call the OrdSum Function
    ord_sum = calculate_ordsum(word)
    # Call the Checksum Function
    checksum = calculate_checksum(ord_sum)
    # Print the checksum value for the input word
    print(f"Checksum for '{word}' is {checksum}")
    # Return the checksum value
    return checksum

def calculate_checksum(ord_sum: int):
    # Calculate the checksum by taking modulo 10 of ord_sum 
    checksum = ord_sum % 10
    # Return the calculated checksum
    return checksum

def calculate_ordsum(word: str):
    # Initialize variable ord_sum to 0
    ord_sum = 0
    # Iterate through each character in word
    for char in word:
        # Add ord value of the character to ord_sum
        ord_sum += ord(char)
    # Return the calculated ord_sum
    return ord_sum

def main():
    # Input word
    word = "cat"
    # Get the checksum value for the input word
    checksum_val = get_checksum(word)

if __name__ == '__main__':
    # Call the main function
    main()