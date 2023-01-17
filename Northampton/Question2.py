import re

class SentimentLexicon:
    def __init__(self):
        self.dictionary = {}

    def create_lexicon(self, positive_words_file, negative_words_file):
        with open(positive_words_file, 'r') as positive_words:
            for line in positive_words:
                if ";" not in line:
                    word = line.strip()
                    self.dictionary[word] = 1
        
        with open(negative_words_file, 'r') as negative_words:
            for line in negative_words:
                if ";" not in line:
                    word = line.strip()
                    self.dictionary[word] = -1
                
class Classifier:
    def __init__(self, sentiment_lexicon):
        self.sentiment_lexicon: SentimentLexicon = sentiment_lexicon
        self.classified_sentences: list[dict] = []
        self.negation_words = ["not", "never", "nothing", "nowhere", "noone", "none", 
                               "havent", "hasnt", "hadnt", "cant", "couldnt", "shouldnt", 
                               "wont", "wouldnt", "dont", "doesnt", "didnt", "isnt", "arent", "aint"]

    def classify(self, text: str):
        score = 0
        negation = False
        for word in text.split():
            word = re.sub(r'[^\w\s]','', word)
            if word in self.negation_words:
                negation = True if not negation else False
            
            if word in self.sentiment_lexicon.dictionary:
                if negation:
                    score -= self.sentiment_lexicon.dictionary[word]
                    negation = False
                else:
                    score += self.sentiment_lexicon.dictionary[word]
        if score > 0:
            sentiment = 1
        elif score < 0:
            sentiment = -1
        else:
            sentiment = 0
        result = {"text": text, "sentiment": sentiment}
        self.classified_sentences.append(result)

    def classify_multiple_words(self, list_of_text):
        for text in list_of_text:
            self.classify(text)
    
    def show_classified_sentences(self):
        for sentence in self.classified_sentences:
            print(sentence)

lexicon = SentimentLexicon()
lexicon.create_lexicon("positive-words.txt", "negative-words.txt")
classifier = Classifier(lexicon)
example_text = [
    "I love Python", 
    "Python is the language I love!", 
    "The iPhone is clearly not the most terrible and worst phone ever. It is the best."
]
classifier.classify_multiple_words(example_text)
classifier.show_classified_sentences()
