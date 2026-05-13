import tkinter as tk
from tkinter import ttk

class Boton:
    def __init__(self, texto,fila,columna):
        self.boton = tk.Button(text=texto,bg="blue",fg="white",font=("Arial",14,"bold"),width=3,height=2)
        self.boton.grid(row=fila,column=columna,padx=5,pady=5)

root = tk.Tk()
root.title("Calculadora")
root.config(width=550, height=500, background="black")

numero = tk.DoubleVar()
numero.set(0)

resultado = tk.Button(text="Resultado",bg="blue",fg="white",font=("Arial",14,"bold"),width=18,height=2)
resultado.grid(row=1,column=0,columnspan=4,padx=5,pady=5)

label = tk.Label(textvariable=numero, bg="blue", fg="white", font=("JetBrains Mono", 15), width=18, height=2, justify="center")
label.grid(row=0,column=0,columnspan=4,padx=5,pady=5)


Boton7 = Boton("7",2,0)
Boton8 = Boton("8",2,1)
Boton9 = Boton("9",2,2)

Boton4 = Boton("4",3,0)
Boton5 = Boton("5",3,1)
Boton6 = Boton("6",3,2)

Boton1 = Boton("1",4,0)
Boton2 = Boton("2",4,1)
Boton3 = Boton("3",4,2)

Boton0 = Boton("0",5,1)

BotonDiv = Boton("/",2,3)
BotonMult = Boton("*",3,3)
BotonMinus = Boton("-",4,3)
BotonMas = Boton("+",5,3)
BotonC = Boton("C",5,0)
BotonPunto = Boton(".",5,2)


root.mainloop()
