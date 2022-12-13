movie = ["Borat","Kingsmen","Toy Story","Paddington Bear"]
#couldn't think of TV shows :)
for i in movie:
    print(i)
print()
newmovie = input("Enter another movie")
number = int(input("Enter where in the list you want to insert 1-4: "))
number1 = (number-1)
movie.insert(number1,newmovie)
for i in movie:
    print(i)
