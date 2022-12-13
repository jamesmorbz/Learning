word = input("Enter a word: ")
start = word[0]
length = len(word)
rest = word[1:length]
if start == "a" and start == "e" and start == "i" and start == "o" and start == "u":
    newword1 = rest + start + "ay"
    print(newword1.lower())
else:
    newword2 = word + "way"
    print(newword2.lower())
