import glob

# ECS518U Lab 5
#
# fileInfo version 0
#
# This script prints information about the files in a directory.
#
# Update the file_info function and the headers, width arrays to
# print more file information.
#
# The script uses the Format Specification Mini-Language for formated output.
# You can read about it if you wish to change the layout, but this is not necessary.
# https://docs.python.org/3.10/library/string.html#formatspec


# The arrays header and width control the width of columns and the header.
# The arrays should be the same length. Extra columns can be added to the arrays.
# This will need to be modified to print the required information (4 columns, then declare the width of each column)
headers = ["File Name", "Characters"]  # column headers
width = [20, 11]  # max width of data in each column


# Get information about one file
# The info array contains the information about the file
def file_info(name):
    global info
    info = []
    info.append(name)  # the file name
    info.append(len(name))  # the number of characters in the name which is pointless - replace!

# ------------------------------------------------
# There should be no need to modify this part of the script, provided
# that the width and info arrays are updated correctly.
#
# Printing is controlled by
#     1. the headers array, which has column headers (see print_header)
#     2. the info array, which has fields for one file (see print_file_info)
#     3. the width array, which has column widths (see both)
# All three arrays should have the same length.
# ------------------------------------------------


# Print the file information.
# Print the info entries, using the corresponding width entries.
def print_file_info():
    global info
    fieldNum = 0
    output = ''
    while fieldNum < len(info):
        output += '{field:{fill}<{width}}'.format(field=info[fieldNum], fill=' ', width=width[fieldNum])
        fieldNum += 1
    print(output)


# Print a header.
# Print the header entries, using the corresponding width entries.
def print_header():
    field_num = 0
    output = ''
    while field_num < len(headers):
        output += '{field:{fill}<{width}}'.format(field=headers[field_num], fill=' ', width=width[field_num])
        field_num += 1

    print(output)
    length = sum(width)
    print("-" * length)


# The glob function returns an array of file names matching the pattern
# in the current directory. Here the pattern is to match everything.
print_header()
for filename in glob.glob('*'):
    file_info(filename)
    print_file_info()
