import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

root = tk.Tk()
root.title("Saluda")
root.config(width=500, height=500, background="white")

contenido = tk.IntVar()
multi = tk.IntVar()
objetivo = tk.IntVar()

multi.set(1)
objetivo.set(100)
multiObjetivo = tk.IntVar()
multiObjetivo.set(0)
def contador():

    contenido.set(contenido.get() + multi.get())
    if contenido.get() >= objetivo.get():
        objetivo.set(contenido.get() * 2)

        multiObjetivo.set(multiObjetivo.get() + 1)
        if multiObjetivo.get() == 2:
            multi.set(multi.get() + 1)
            multiObjetivo.set(0)



label1 = tk.Label(textvariable=contenido, bg="white", fg="black", font=("Cascadia Code", 15), justify="center")
label2 = tk.Label(text="Objetivo: ", bg="white", fg="black", font=("Cascadia Code", 15), justify="center")
label3 = tk.Label(textvariable=objetivo, bg="white", fg="black", font=("Cascadia Code", 15), justify="center")
boton = tk.Button(text="Click", bg="white", fg="black", font=("Cascadia Code", 12), command=contador)

boton.place(x=200,y=10)
label1.place(x=200,y=50)
label2.place(x=270,y=10)
label3.place(x=390,y=10)
root.mainloop()