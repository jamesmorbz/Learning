import json
import pprint
import requests
import csv
import sys
import fileinput
import math
import os
import time
import pdb

key = '0288dbe31e25440ec081d6dad892805f' # I stored it in plaintext, I know, stupid, Easy tho ;)
inputted_user_variables = []
incorrect_usage_counter = 1
query_input = ""

#TODO read Country code + Country from an API

def converting_csv_to_lowercase():
    for line in fileinput.input('E:\QMULwork\WeatherAPP\Country-CountryCode.csv', inplace=1):
        print(line.lower(), end='') 

def reading_csv_to_dict():
    with open('E:\QMULwork\WeatherAPP\Country-CountryCode.csv', mode='r') as infile:
        reader = csv.reader(infile)
        c_cc_dict = {rows[0]:rows[1] for rows in reader}
        return c_cc_dict

def get_user_input_city():
    city = inputted_user_variables.append(str.lower(input("City Name: ")))
    return city

def get_user_input_country():
    country = (str.lower(input("Country: ")))
    return country

def get_country_code(country_code_dict, country):
    global incorrect_usage_counter
    global inputted_user_variables
    try:
        inputted_user_variables.append(country_code_dict[country])
        country_code = str.upper(country_code_dict[country])
        os.system('clear')
        return country_code
    except:
        inputted_user_variables = []
        os.system('clear')
        print("Error Count " + str(incorrect_usage_counter) + " : \"" + country + "\" not registered as a valid country, try again with different country.")
        
        if incorrect_usage_counter > 4:
            print("Error Count exceeded allowed threshold. Program Exiting.")
            sys.exit(1)
        else:
            incorrect_usage_counter += 1
            print("Returning")
            print()
            print()
            time.sleep(1)
            main()
            
def get_current_weather():
    global incorrect_usage_counter
    global inputted_user_variables
    global query_input
    query_input = ",".join(inputted_user_variables)
    current_weather = requests.get("https://api.openweathermap.org/data/2.5/weather?q=" + query_input + "&APPID=" + key )
    try:
        current_weather = current_weather.json()
        country_code = current_weather["sys"]["country"]
        city = current_weather["name"]
        longitude = (current_weather["coord"]["lon"])
        latitude = (current_weather["coord"]["lat"])
        gmaps_answer = "https://www.google.com/maps/place/" + str(latitude) + "," + str(longitude)
        temp_deg = str(round((current_weather["main"]["temp"] - 273.15),1))
        feels_like = str(round((current_weather["main"]["feels_like"] - 273.15),1))
        os.system('clear')
        print("Link for Location: " + gmaps_answer)
        print("The current weather report is -")
        print("Temperature: %s Degrees (ºC) but it feels like %s Degrees (ºC)." % (temp_deg, feels_like))
        return latitude, longitude, country_code, city
    except:
        inputted_user_variables = []
        if incorrect_usage_counter < 4:
            print("City Not Found in Database - Try a different name")
            print()
            print()
            incorrect_usage_counter += 1
        else:
            print("City Not Found in Database")
            print("Error Count exceeded allowed threshold. Program Exiting.")
            time.sleep(2)
            sys.exit(1)

        main()

def get_historic_data():
    global query_input
    query_input = ",".join(inputted_user_variables)
    something_data = requests.get("https://api.openweathermap.org/data/2.5/weather?q=" + query_input + "&appid=" + key)
    something_data = something_data.json()
    
def DecimaltoDMSLat(Decimal):
    d = int(Decimal)
    m = int((Decimal - d) * 60)
    s = (Decimal - d - m/60) * 3600.00
    z= round(s, 1)
    if d >= 0:
        lat = ( abs(d), "º", abs(m), "'", abs(z), '"', "N")
    else:
        lat = ( abs(d), "º", abs(m), "'", abs(z), '"', "S")
    return lat

def DecimaltoDMSLong(Decimal):
    d = int(Decimal)
    m = int((Decimal - d) * 60)
    s = (Decimal - d - m/60) * 3600.00
    z= round(s, 1)
    if d >= 0:
        long = ( abs(d), "º", abs(m), "'", abs(z), '"', "E")
    else:
        long = ( abs(d), "º", abs(m), "'", abs(z), '"', "W")
    return long

def outputting_DMS_string(lat, long, city, country_code):
    lat = ''.join(map(str, lat))
    long = ''.join(map(str, long))
    print()
    print("The exact location of %s (%s) is %s %s" % (city, country_code, lat, long))
    

def main():
    converting_csv_to_lowercase()
    country_code_dict = reading_csv_to_dict()
    query_city = get_user_input_city()
    country = get_user_input_country()
    country_code = get_country_code(country_code_dict, country)
    lat_long = get_current_weather()
    DMS_Lat = DecimaltoDMSLat(lat_long[0])
    DMS_Long = DecimaltoDMSLong(lat_long[1])
    outputting_DMS_string(DMS_Lat, DMS_Long, lat_long[3], country_code)
    sys.exit(1)

if __name__ == "__main__":
    main()