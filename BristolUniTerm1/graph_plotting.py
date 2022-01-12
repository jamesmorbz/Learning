import matplotlib.pyplot as plt
import numpy as np

x = [1, 2, 3, 4, 5]
y = [5, 10, 50, 100, 300]

plt.rcParams.update({
    'font.size': 8,
    'xtick.major.size': 8,
    'xtick.major.width': 2,
    'ytick.major.size': 8,
    'ytick.major.width': 2,

    })

plt.plot(x, y)
plt.xlabel('X Axis')
plt.ylabel('Y Axis')
plt.title('Graph Title')
# plt.show()
plt.savefig('SavingGraph.png')

