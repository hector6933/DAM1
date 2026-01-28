from importlib.util import source_hash
from tkinter import *
from turtledemo.penrose import start

canvas = Canvas(width=640, height=640, bg="white")
canvas.pack(expand=YES, fill=BOTH)

canvas.create_oval(200, 200, 350, 350, fill="red", outline="red")
canvas.create_line(230, 280, 260, 280, fill="black")
canvas.create_line(290, 280, 320, 280, fill="black")
canvas.create_line(265, 320, 285, 320, fill="black")

points = [275,150,150,250,400,250]
canvas.create_polygon(points,outline="blue",fill="blue",width=2)
canvas.create_text(275, 100, text="Héctor Criado", fill="red", font=("Arial",25))
mainloop()