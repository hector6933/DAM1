import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

from numpy.f2py.crackfortran import sourcecodeform

root = tk.Tk()
root.title("cosa")
root.config(width=500, height=500, background="white")

num = tk.IntVar()
multiplicador = tk.IntVar()
multiplicador.set(1)

def sumarNum():
    num.set(num.get() + multiplicador.get())
def restarNum():
    num.set(num.get() - multiplicador.get())

labelTexto1 = tk.Label(text="Numero:", bg="white",fg="black",font=("JetBrains Mono", 12))
labelNumero = tk.Label(textvariable=num, bg="white",fg="black",font=("JetBrains Mono", 9))
botonSumar = tk.Button(text="Sumar", bg="white", fg="black", font=("Cascadia Code", 10), command=sumarNum)
botonRestar = tk.Button(text="Restar", bg="white", fg="black", font=("Cascadia Code", 10), command=restarNum)

labelTexto2 = tk.Label(text="Multiplicador:", bg="white",fg="black",font=("JetBrains Mono", 12))
inputMultiplicador = tk.Entry(width=20, bg="white", fg="black", textvariable=multiplicador)

labelTexto1.place(x=220,y=10)
labelNumero.place(x=240,y=45)

botonSumar.place(x=190,y=85)
botonRestar.place(x=250,y=85)

labelTexto2.place(x=185,y=135)
inputMultiplicador.place(x=190,y=165)



root.mainloop()