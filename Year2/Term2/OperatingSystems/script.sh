#!/bin/bash

function create_file()
{
    echo "Creating file $1"
    sleep 2
    touch $1
}

function delete_file()
{
    echo "Deleting file $1"
    sleep 2
    rm $1
}

dir=$1
echo -e "\n================================"
echo "Script Starting to run"
echo "Information" 
echo "Program: $0"
echo "Parameter: $dir"
echo -e "================================ \n "
files=("happy.txt" "sad.txt" "doc.txt" "grumpy.txt")
len_files=${#files[@]}

echo -e "Going to create $len_files new files \n"

if [ -f "$dir" ];
then
    echo "$dir directory exists."
else
    echo "Making a Dir"
    mkdir $dir
fi

echo "Changing into Dir"
cd $dir
echo "Creating Files"

for (( i=0; i<$len_files; i++ ));
do
  create_file "${files[$i]}"
done

echo -e "\n================================"
ls -lrt
echo -e "================================\n "


for (( i=0; i<$len_files; i++ ));
do
  delete_file "${files[$i]}"
done


cd ..

echo -e "\n================================"
ls -lrt
echo -e "================================\n "

echo "Cleaning Up Dir"
rmdir $dir

echo -e "\n================================"
ls -lrt
echo -e "================================\n "

input_file="input.txt"

line_count=$(cat $input_file | wc -l)
word_count=$(cat $input_file | wc -w)

echo "$lines lines in $input_file"
echo "$word_count words in $input_file"