import random
import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

from numpy.f2py.crackfortran import sourcecodeform

root = tk.Tk()
root.title("cosa")
root.config(width=500, height=500, background="white")

numeroRandom = random.randint(1,100)
adivinar = tk.IntVar()
textoAdivinado = tk.StringVar()
print(numeroRandom)
def intentoAdivinar():
    if adivinar.get() == numeroRandom:
        textoAdivinado.set("¡ Correcto !")
    else:
        textoAdivinado.set("¡ Incorrecto, inténtalo otra vez !")

labelAdivinar = tk.Label(text="Adivina el número (1 al 100):", bg="white", fg="black", font=("Arial", 15))
inputAdivinar = tk.Entry(width=35, bg="white", fg="black", textvariable=adivinar)
botonAdivinar = tk.Button(text="Adivinar", bg="white", fg="black", font=("Cascadia Code", 12), command=intentoAdivinar)
labelAdivinado = tk.Label(textvariable=textoAdivinado, bg="white", fg="black", font=("Arial", 15))

labelAdivinar.place(x=20, y=20)
inputAdivinar.place(x=20, y=60)
botonAdivinar.place(x=20, y=100)
labelAdivinado.place(x=20, y=150)

root.mainloop()





