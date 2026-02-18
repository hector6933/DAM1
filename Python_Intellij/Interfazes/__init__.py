import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

root = tk.Tk()

root.title("Ventana guapa")

root.config(width=500, height=500, background="#447766")

label = tk.Label(text="Hola", bg="#447766", fg="white", font=("Cascadia Code", 20))

entry = tk.Entry(justify=tk.LEFT)

boton = tk.Button(text="Botonaco", bg="white", fg="black", font=("Cascadia Code", 15))
boton2 = tk.Button(text="   Botonaco2   ", bg="#447766", fg="black", font=("Cascadia Code", 15), borderwidth=50, width=20, height=5)
# command=lambda:root.destroy()

label.place(x=20,y=20)
entry.place(x=20,y=80)
boton.place(x=20,y=140)
boton2.place(x=20,y=220)



root.mainloop()