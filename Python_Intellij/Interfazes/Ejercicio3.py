import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

root = tk.Tk()
root.title("Saluda")
root.config(width=500, height=500, background="white")

contenido = tk.StringVar()

label = tk.Label(textvariable=contenido, bg="white", fg="black", font=("Cascadia Code", 15))
boton1 = tk.Button(text="Uno", bg="white", fg="black", font=("Cascadia Code", 12), command=lambda:contenido.set("Uno"))
boton2 = tk.Button(text="Dos", bg="white", fg="black", font=("Cascadia Code", 12), command=lambda:contenido.set("Dos"))


boton1.place(x=190,y=10)
boton2.place(x=250,y=10)
label.place(x=220,y=70)

root.mainloop()