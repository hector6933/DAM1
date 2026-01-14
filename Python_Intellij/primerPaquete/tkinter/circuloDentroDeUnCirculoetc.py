from importlib.util import source_hash
from tkinter import *
from turtledemo.penrose import start

canvas = Canvas(width=640, height=640, bg="white")
canvas.pack(expand=YES, fill=BOTH)
contador = 600
contador2 = 100
for i in range(25):
    if i % 2 == 0:
        canvas.create_oval(contador2, contador2, contador, contador, fill="red", outline="black")
    else:
        canvas.create_oval(contador2,contador2,contador,contador,fill="white",outline="black")
    contador -= 10
    contador2 += 10
mainloop()