from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import tkinter as tk
import pandas as pd
import os
import sys
import matplotlib.pyplot as plt
from pandas import DataFrame

def graph_data(dataframe: DataFrame):
    fig1 = plt.figure()
    fig2 = plt.figure()
    ax1 = fig1.add_subplot(111)
    ax2 = fig2.add_subplot(111)
    summed = dataframe.sum(numeric_only=True)

    summed.plot(figsize=(15,10), kind='bar', ax=ax2)
    summed.plot(figsize=(15,10), kind='line', color='red', linewidth='5', ax=ax2)

    dataframe.plot(x="Item", kind='bar', figsize=(10,5), ax=ax1)
    #Add x and y axis labels and a title
    plt.xlabel('Item')
    plt.ylabel('Price')
    plt.title('Price of Each Item in given times')
    fig1.set_tight_layout(True)
    fig2.set_tight_layout(True)
    ax1.legend(loc='upper left', bbox_to_anchor=(1,1), fontsize=6)
    ax1.text(0,1.2,'Here we see the big peak of Chicken which is clearly the max price value of the dataset', transform=ax1.transAxes)
    canvas1 = FigureCanvasTkAgg(fig1, master=root)
    canvas1.get_tk_widget().pack()
    canvas1.draw()
    canvas2 = FigureCanvasTkAgg(fig2, master=root)
    canvas2.get_tk_widget().pack()
    canvas2.draw()

def on_closing():
    root.destroy()

def main():
    dataframe: DataFrame = pd.read_excel((os.path.join(sys.path[0],'food-data.xlsx')))
    button = tk.Button(root, text="Show Graph", bg="green", fg="white", font=("Helvetica", 16), command=lambda: graph_data(dataframe))
    button.pack()
    root.protocol("WM_DELETE_WINDOW", on_closing)
    root.mainloop()

if __name__ == "__main__":
    root = tk.Tk()
    main()