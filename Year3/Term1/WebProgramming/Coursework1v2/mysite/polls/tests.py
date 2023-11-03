# Python 3 classes for the automated checking of assignments.
#
# Marker class by Fabrizio Smeraldi <f.smeraldi@qmul.ac.uk>
# Addapted to Django by Paulo Oliva <p.oliva@qmul.ac.uk>

import unittest # mandatory
import os # as required

# Using Django's TestCase class instead of unittest.TestCase
from django.test import TestCase, Client
from django.urls import reverse
from django.utils import timezone

# report is a global variable

report = []

def collect_report(test_function):
    def modified_test_function(self):
        cls=type(self)
        try:
            test_function(self, cls)
            cls.report['feedback'][-1] += "OK"
        except Exception as e:
            cls.report['feedback'][-1] += "FAILED"
            cls.report['feedback'].append(f"   Error: {e}")
    return modified_test_function


class Marker(TestCase):
    """ Basic infrastructure for reporting. Do not write any test
    methods here - extend this class to mark each (sub)question, see 
    example below. """
    
    @classmethod
    def setUpClass(cls):
        cls.report = {
            'topic': cls.topic,
            'subtopic': cls.subtopic,
            'totalmarks': cls.totalmarks,
            'marks': 0,
            'feedback': [f"\n----------------- Marking {cls.topic} {cls.subtopic} -----------------"],
        }
        cls.client = Client()

    @classmethod
    def tearDownClass(cls):
        cls.report['feedback'].append(
            f">> Total marks for {cls.report['topic']} {cls.report['subtopic']}: {cls.report['marks']} out of {cls.report['totalmarks']}"
        )
        # print and add individual report to list of reports
        for feedback in cls.report['feedback']:
            print(feedback)
        report.append(cls.report)

class Part1Marker(Marker):

    @classmethod
    def setUpClass(cls):
        cls.topic = 'Tutorial'
        cls.subtopic = '(part 1)'
        cls.totalmarks = 1.0
        super().setUpClass()

    @collect_report
    def test_index_view(self, cls):
        cls.report['feedback'].append(" - View function with 'index' name created and returning '200 OK' response...")
        try:
            response = cls.client.get(reverse('index'), follow=True)
        except:
            response = cls.client.get(reverse('polls:index'), follow=True)
        self.assertEquals(response.status_code, 200)
        cls.report['marks'] += 1.0


class Part2Marker(Marker):

    @classmethod
    def setUpClass(cls):
        cls.topic = 'Tutorial'
        cls.subtopic = '(part 2)'
        cls.totalmarks = 1.5
        super().setUpClass()

    @collect_report
    def test_admin_view(self, cls):
        cls.report['feedback'].append(" - Admin page included and returning 200 response...")
        response = cls.client.get('/admin/', follow=True)
        self.assertEquals(response.status_code, 200)
        cls.report['marks'] += 0.5

    @collect_report
    def test_question_model(self, cls):
        cls.report['feedback'].append(" - Question model created...")
        from polls.models import Question
        question_count = Question.objects.all().count()
        self.assertEquals(1, 1)
        cls.report['marks'] += 0.5

    @collect_report
    def test_choice_model(self, cls):
        cls.report['feedback'].append(" - Choice model created...")
        from polls.models import Choice
        choice_count = Choice.objects.all().count()
        self.assertEquals(1, 1)
        cls.report['marks'] += 0.5


class Part3Marker(Marker):

    @classmethod
    def setUpClass(cls):
        cls.topic = 'Tutorial'
        cls.subtopic = '(part 3)'
        cls.totalmarks = 1.5
        super().setUpClass()

    @collect_report
    def test_detail_view(self, cls):
        cls.report['feedback'].append(" - Detail view created and returning 200 response...")
        # create test a question
        from polls.models import Question
        question = Question.objects.create(
            question_text='Test question',
            pub_date=timezone.now(),
        )
        try:
            response = cls.client.get(reverse('detail', args={question.id}), follow=True)
        except:
            response = cls.client.get(reverse('polls:detail', args={question.id}), follow=True) 
        self.assertEquals(response.status_code, 200)
        cls.report['marks'] += 0.5

    @collect_report
    def test_index_view_uses_template(self, cls):
        cls.report['feedback'].append(" - Index view using index.html template...")
        try:
            response = cls.client.get(reverse('index'), follow=True)
        except:
            response = cls.client.get(reverse('polls:index'), follow=True)
        self.assertTemplateUsed(response, 'polls/index.html')
        cls.report['marks'] += 0.5

    @collect_report
    def test_detail_view_raises_404(self, cls):
        cls.report['feedback'].append(" - Detail view raises 404 on invalid question id...")
        try:
            url = reverse('detail', args={25})
        except:
            url = reverse('polls:detail', args={25})
        response = cls.client.get(url, follow=True)
        self.assertEquals(response.status_code, 404)
        cls.report['marks'] += 0.5

# class Part4Marker(Marker):

#     @classmethod
#     def setUpClass(cls):
#         cls.topic = 'Tutorial'
#         cls.subtopic = '(part 4)'
#         cls.totalmarks = 1.0
#         super().setUpClass()

#     @collect_report
#     def test_results_view_uses_template(self, cls):
#         cls.report['feedback'].append(" - Results view using results.html template...")
#         # create test a question
#         from polls.models import Question
#         question = Question.objects.create(
#             question_text='Test question',
#             pub_date=timezone.now(),
#         )
#         # test view
#         try:
#             url = reverse('results', kwargs={'question_id':question.id})
#         except:
#             url = reverse('polls:results', kwargs={'question_id':question.id})
#         response = cls.client.get(url, follow=True)
#         self.assertTemplateUsed(response, 'polls/results.html')
#         cls.report['marks'] += 1.0
