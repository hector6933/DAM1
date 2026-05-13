import tkinter as tk
from tkinter import ttk


root = tk.Tk()
root.title("Formulario")
root.config(width=550, height=500, background="white")

class Input:
    def __init__(self,fila,columna):
        self.input = tk.Entry(bg="white",fg="black",font=("Arial",14,"bold"),width=15)
        self.input.grid(row=fila,column=columna,padx=5,pady=5)

class textoLabel:
    def __init__(self,texto,fila,columna):
        self.label = tk.Label(text=texto,bg="white",fg="blue",font=("Arial",10,"bold"),width=10)
        self.label.grid(row=fila,column=columna,padx=5,pady=5)

nombre = textoLabel("Nombre",0,0)
apellidos = textoLabel("Apellidos",1,0)
direccion = textoLabel("Dirección",2,0)
cp = textoLabel("CP",3,0)
localidad = textoLabel("Localidad",4,0)
provincia = textoLabel("Provincia",5,0)
pais = textoLabel("Pais",6,0)
edad = textoLabel("Edad",7,0)
profesion = textoLabel("Profesion",8,0)

inNombre = Input(0,1)
inApellidos = Input(1,1)
inDir = Input(2,1)
inCp = Input(3,1)
inLocalidad = Input(4,1)
inProvincia = Input(5,1)
inPais = Input(6,1)
inEdad = Input(7,1)
inProfesion = Input(8,1)

root.mainloop()