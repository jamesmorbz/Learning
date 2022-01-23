import threading
import requests

threads = []
number_of_loops = 1

years = [2013,2014,2015,2016,2017,2018,2019,2020,2021,2022]
months = [1,2,3,4,5,6,7,8,9,10,11,12]


urls = []
for year in years:
    for month in months:
        urls.append(f"https://api.chess.com/pub/player/purplebishop123/games/{year}/{month}")

for url in urls:
    r = requests.get(url)
    data = r.json()
    print(data)
    print("")
