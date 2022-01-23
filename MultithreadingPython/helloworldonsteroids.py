import threading

def hello_world():
    print(f"Hello World")

threads = []
number_of_loops = 1000000

for i in range(number_of_loops):
    t = threading.Thread(target=hello_world())
    t.daemon = True
    threads.append(t)

for i in range(number_of_loops):
    threads[i].start()

for i in range(number_of_loops):
    threads[i].join()