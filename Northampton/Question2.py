# Importing Regex to use later to strip out punctuation
import re
import os
import sys
class SentimentLexicon:
    def __init__(self):
        # Initialising the Dictionary that will store all the words from the input values with their respective positive/negative values
        self.dictionary = {}

    def create_lexicon(self, positive_words_file, negative_words_file):
        # os.path.join(sys.path[0]) takes the path of the directory the python file is running in and joins it with the file name. 
        # This means the input needs to be in the same folder as the code.
        with open((os.path.join(sys.path[0], positive_words_file)), 'r') as positive_words:
            for line in positive_words: # looping through each line in the input file
                if ";" not in line: # the first lines of the input file are commented and contain semi colons. These need to be omitted.
                    word = line.strip() # stripping away /n characters
                    self.dictionary[word] = 1 # adding positive words to the dictionary with the value of positive 1
        
        with open((os.path.join(sys.path[0], negative_words_file)), 'r') as negative_words:
            for line in negative_words: # looping through each line in the input file
                if ";" not in line:  # the first lines of the input file are commented and contain semi colons. These need to be omitted.
                    word = line.strip() # stripping away /n characters
                    self.dictionary[word] = -1 # adding positive words to the dictionary with the value of negative 1
                
class Classifier:
    def __init__(self, sentiment_lexicon):
        self.sentiment_lexicon: SentimentLexicon = sentiment_lexicon # giving the classifier access to the already instantiated SentimentLexicon - This could be done via inheritence
        self.classified_sentences: list[dict] = [] # will store the results of all the processed texts
        self.negation_words = ["not", "never", "nothing", "nowhere", "noone", "none", # a short list of negation words which will allow us to invert the score of positive of negative words
                               "havent", "hasnt", "hadnt", "cant", "couldnt", "shouldnt", 
                               "wont", "wouldnt", "dont", "doesnt", "didnt", "isnt", "arent", "aint"]

    def classify(self, text: str):
        score = 0
        negation = False # the word "bad" would be scored as -1 but if it is "not bad" it should be scored a 1 since it is inverted with the use of not
        for word in text.split():
            word = re.sub(r'[^\w\s]','', word) # stripping punctuation from the word using regex
            if word in self.negation_words:
                negation = True if not negation else False # if negation is False make it True. If it is True make it False. This accounts for double negatives like "not not bad"
            
            if word in self.sentiment_lexicon.dictionary:
                if negation: # if negation is true the next adjective in the list of dictionary words from the lexicon class will have its score inverted. 1 => -1 or -1 => 1
                    score -= self.sentiment_lexicon.dictionary[word]
                    negation = False # after the negative has been used negation is then reset to False
                else:
                    score += self.sentiment_lexicon.dictionary[word]
        if score > 0: # if the sentence score > 0 sentiment is 1
            sentiment = 1
        elif score < 0: # if the sentence score < 0 sentiment is 0
            sentiment = -1
        else: # if the sentence score is not greater than or less than 0 it must be 0 - the sentiment is nothing then.
            sentiment = 0
        result = {"text": text, "sentiment": sentiment}
        self.classified_sentences.append(result) # appending the current result to the history of classified_sentences

    def classify_multiple_words(self, list_of_text): # helper function to loop through and classify multiple words/sentences.
        for text in list_of_text:
            self.classify(text)
    
    def show_classified_sentences(self): # helper function to display all previously classified sentences.
        for sentence in self.classified_sentences:
            print(sentence)

lexicon = SentimentLexicon() # instantiating the lexicon
lexicon.create_lexicon("positive-words.txt", "negative-words.txt") # calling the function that will populate the lexicon dictionary
classifier = Classifier(lexicon) # instatiating the classifier and passing in the lexicon
example_text = [ # example sentences
    "I hate every programming language including Python!", 
    "I really don't hate this but it's not good...", 
    "Anyone who likes coding is good but not great because it's difficult."
]
classifier.classify_multiple_words(example_text) # calling the helper function that loops through the sentences above and classifies them
classifier.show_classified_sentences() # calling the helper function that loops through the stored sentence,sentiment pairs and prints them
