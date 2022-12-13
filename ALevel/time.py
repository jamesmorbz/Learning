miliTime = input("Enter a time in hh:mm (military) format: ")
def timeConvert():
    hours, minutes = miliTime.split(":")
    hours, minutes = int(hours), int(minutes)
    setting = "AM"
    if hours > 12:
        setting = "PM"
        hours -= 12
    print(("%02d:%02d" + setting) % (hours, minutes))
