firstnumber=int(input("Enter a number over 100!  "))
secondnumber=int(input("Enter a number under 10!  "))

divided=firstnumber/secondnumber
remainder=firstnumber%secondnumber

print (secondnumber , 'goes into' , firstnumber , int(divided) , 'times giving a remainder of' , remainder , '\nIf you want to be precise' , firstnumber , '/' , secondnumber , '=' , divided)
