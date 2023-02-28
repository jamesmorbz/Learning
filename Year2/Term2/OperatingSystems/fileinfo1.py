import os
from datetime import datetime
import glob

# Define the table header
print("{:<20} {:<7} {:<7} {:<20}".format("File Name", "Size", "Type", "Modified"))

# Get the file information and print the table rows
for file_name in glob.glob('*'):
    # Get the file size and type
    if os.path.isfile(file_name):
        file_size = os.path.getsize(file_name)
        file_type = "file"
    elif os.path.isdir(file_name):
        file_size = os.path.getsize(file_name)
        file_type = "dir"
    else:
        file_size = "N/A"
        file_type = "N/A"
    # Get the file modified time and format it
    modified_time = os.path.getmtime(file_name)
    modified_time_str = datetime.fromtimestamp(modified_time).strftime("%b %d %Y %H:%M")
    # Print the table row
    print("{:<20} {:<7} {:<7} {:<20}".format(file_name, file_size, file_type, modified_time_str))