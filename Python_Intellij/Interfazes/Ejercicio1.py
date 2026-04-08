import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

root = tk.Tk()

root.title("Saluda")
root.config(width=500, height=500, background="white")


contenido = tk.StringVar()

label = tk.Label(textvariable=contenido, bg="white", fg="black", font=("Cascadia Code", 12))

boton = tk.Button(text="Saluda", bg="white", fg="black", font=("Cascadia Code", 12), command=lambda:contenido.set("Hola"))

boton.place(x=10,y=10)
label.place(x=10,y=50)


root.mainloop()
