from importlib.util import source_hash
from tkinter import *
from turtledemo.penrose import start

canvas = Canvas(width=640, height=640, bg="white")
canvas.pack(expand=YES, fill=BOTH)

canvas.create_line(100, 100, 500, 100, fill="blue")

canvas.create_rectangle(100,125,300,150,fill="red")

canvas.create_oval(100,175,200,250,fill="yellow")

canvas.create_arc(100,275,200,350, fill="lime",start=180)
canvas.create_arc(100,275,200,350, fill="lime",start=0)
canvas.create_arc(100,275,200,350, fill="black",start=90)
canvas.create_arc(100,275,200,350, fill="black",start=270)

canvas.create_rectangle(100,375,225,450,fill="red",outline="lime",width=5)
canvas.create_oval(100,375,225,450,fill="lime")

mainloop()