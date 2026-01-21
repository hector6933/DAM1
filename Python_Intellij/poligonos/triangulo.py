from importlib.util import source_hash
from tkinter import *
from turtledemo.penrose import start
canvas = Canvas(width=640, height=640, bg="white")
canvas.pack(expand=YES, fill=BOTH)

points = [225,150,125,350,325,350]
canvas.create_polygon(points,outline="lime",fill="lime",width=2)
mainloop()