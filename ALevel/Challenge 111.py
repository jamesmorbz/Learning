import csv
f=open('books.csv','w')
rec0='To Kill a Mockingbird,Harper Lee,1960\n'
rec1='A brief History of Time,Stephen,1988\n'
rec2='The Great Gatsby,F Scott Fitzgerald,1922\n'
rec3='The Man who Mistook His Wife for a Hat,Oliver Sacks,1985\n'
rec4='Pride and Prejudice,Jane Austen,1813\n'


f.write(rec0)
f.write(rec1)
f.write(rec2)
f.write(rec3)
f.write(rec4)
f.close()
