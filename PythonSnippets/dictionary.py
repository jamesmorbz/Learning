dictionary = {"letter_a" : "a", "letter_b" : "b", "letter_c" : "c"} # {key : value}

#print(dictionary)
#print(type(dictionary))

dictionary_keys = dictionary.keys()
dictionary_values = dictionary.values()

#print(dict_keys)
#print(dict_values)


dict_1 = {"letter_a" : "a", "letter_b" : "b", "letter_c" : "c"}
dict_2 = {"letter_d" : "d", "letter_e" : "e", "letter_f" : "f"}
dict_3 = {**dict_1,**dict_2,}

dict_3_keys = dict_3.keys()
dict_3_values = dict_3.values()

#print(dict_3)
#print(dict_3_keys)
#print(dict_3_values)

dict_4 = {"letter" : "a", "letter" : "b", "letter" : "c"} # You can't have the same key twice in a dictionary
#print(dict_4)

dict_5 = {"letter" : ["a","b","c"]} # Key to Value is a 1-1 relationship. You can't have multiple values for a given key either. You can have lists though!
#print(dict_5["letter"]) # You access the value of the dictionary through the key. Same way you call a value from a list through an index

