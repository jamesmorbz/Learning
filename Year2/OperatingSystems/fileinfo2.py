import os
from datetime import datetime
import glob

# Define the table header
print("{:<20} {:<7} {:<7} {:<20}".format("File Name", "Size", "Type", "Link"))
files_dict = {}
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
    if os.path.islink(file_name):
        link_target = os.readlink(file_name)
    else:
        link_target = ""
    # Print the table row
    if os.path.isfile(file_name) and os.path.exists(file_name):
        inode = os.stat(file_name).st_ino
        if inode in files_dict:
            files_dict[inode].append(file_name)
        else:
            files_dict[inode] = [file_name]
    print("{:<20} {:<7} {:<7} {:<20}".format(file_name, file_size, file_type, link_target))

for inode, files in files_dict.items():
    if len(files) > 1:
        print("The following files are synonyms:")
        for file_path in files:
            print("- {}".format(file_path))