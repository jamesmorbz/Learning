import os
import sys
import csv
import pprint

def clean_data(raw_data):
    raw_data = raw_data.replace("\t", ",")
    raw_data = raw_data.split("\n")
    for counter, row in enumerate(raw_data):
        if counter == 0:
            y = [x.strip() for x in row.split(",")]
            deats = y[1].split("(")
            y[1] = deats[0]
            y.insert(2, deats[1].split("/")[0])
            y[4] = y[4][4:]
            y[7] = y[7][:-1]
            raw_data[counter] = ",".join(y)
        else:
            columns = [x.strip() for x in row.split(",")]
            new_part = columns[0].split(" ")
            if len(new_part) == 3:
                new_part[0], new_part[1] = new_part[1], new_part[0]
            if len(new_part) == 4:
                new_part[0], new_part[1] = f"{new_part[1]} {new_part[2]}", new_part[0]
                new_part.pop(2)
            new_part[2] = new_part[2].replace("(", "").replace(")", "")
            columns.pop(0)
            raw_data[counter] = ",".join([*new_part, *columns])
    cleaned_data = list(csv.DictReader(raw_data))
    for row in cleaned_data:
        row['Last Name'] = row['Last Name'].upper()
        row['First Name'] = row['First Name'].upper()
    return cleaned_data

def read_file():
    file_name = input("Enter File Name (Make sure it's in the same directory): ")
    try:
        with open((os.path.join(sys.path[0], file_name)), 'r') as input_file:
            raw_data = input_file.read()
        return clean_data(raw_data)
    except FileNotFoundError: # Errors could be raised if the user does not type the right file name these should be handled
        raise FileNotFoundError("Please Enter a Valid File Name")

def lineCount(data):
    number_of_lines = len(data) # Since we have put the data cleanly into a dictionary we can simply call len
    print(f"Number of Lines in Input File is {number_of_lines}") # Print the len

def runnerCountry(data):
    runner_name = input("Enter the runner's name (In Capitals): ") # Getting User input
    data = {x["Last Name"]:x for x in data}
    try:
        print(f"This runner is from {data[runner_name]['Country']}")
    except KeyError:
        raise Exception("No Valid Runner Name entered")

def countryInformation(data):
    all_countries = list(set([row["Country"] for row in data])) # Giving the user the options
    print(f"Printing all countries in list: {all_countries}")
    country = input("Enter the country you want information from: ") # Getting User input
    if country not in all_countries:
        raise Exception("You must choose a country in the list")
    output = [row for row in data if row["Country"] == country] # Finding all the rows the user asked for
    
    print(f"{len(output)} Rows matching country user specified")
    for row in output:
        pprint.pprint(row)

def format_hhmmss_to_seconds(time_str):
    """Get seconds from time."""
    h, m, s = time_str.split(':')
    return int(h) * 3600 + int(m) * 60 + int(s)

def format_seconds_to_hhmmss(seconds):
    hours = seconds // (60*60)
    seconds %= (60*60)
    minutes = seconds // 60
    seconds %= 60
    return f"{hours:02.0f}:{minutes:02.0f}:{seconds:02.0f}"

def averageTime(data):
    all_times = []
    for row in data:
        time = format_hhmmss_to_seconds(row['Net Time'])
        all_times.append(time)
    average_time_secs = sum(all_times)/len(data)
    average_time_formatted = format_seconds_to_hhmmss(average_time_secs)
    print(f"The average time across all runners is {average_time_secs} in seconds. {average_time_formatted} in the format provided in the data")

def main():
    data = read_file()
    lineCount(data)
    runnerCountry(data)
    countryInformation(data)
    averageTime(data)

if __name__ == "__main__":
    main()