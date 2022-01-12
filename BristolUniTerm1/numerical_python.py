import numpy as np

pi = np.pi # value for pi
e = np.e # value for e
absolute_value = np.abs(-5) # -5 => 5     |-5|
exponential = np.exp(2.0)
arccos = np.arccos

list_x = [1.1, 2.0, 3.3, 4.0]
x = np.array(list_x)
print(x)

x = [0.707,0.707,0.0] # list which is numpy arrayable
y = [0.866,0.5,0.0] # list which is numpy arrayable
x = np.array(x) # list is now a numpy "object"
y = np.array(y) # list is now a numpy "object"
xmag = np.linalg.norm(x) # this creates vector
ymag = np.linalg.norm(y) # this creates vector
theta_radians = np.arccos(np.dot(x,y) / (xmag * ymag))
theta_degrees = (180.0 / np.pi) * theta_radians
print(theta_degrees)
