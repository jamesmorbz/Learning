import numpy as np
import matplotlib.pyplot as plt 

range(0,10)
x = np.arange(0, 2*np.pi, 000000000000000.1)   # arange = ARRAY RANGE => 0, 2*pi, 
y = np.sin(x)
z = np.cos(x)
plt.plot(x,y,x,z)
plt.xlabel('x values from 0 to 2pi')  # string must be enclosed with quotes '  '
plt.ylabel('sin(x) and cos(x)')
plt.title('Plot of sin and cos from 0 to 2pi')
plt.legend(['sin(x)', 'cos(x)'])      # legend entries as seperate strings in a list
plt.show()