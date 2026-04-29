import random
import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

root = tk.Tk()
root.title("Conversor de temperatura")
root.config(width=500, height=500, background="white")

tempC = tk.DoubleVar()
tempC.set(0.0)

tempF = tk.DoubleVar()
tempF.set(0.0)

tempK = tk.DoubleVar()
tempK.set(0.0)

def convertirTemp():
    tempF.set(tempC.get() * 1.8 + 32)
    tempK.set(tempC.get() + 273.15)

labelTexto1 = tk.Label(text="Temperatura en ºC", bg="white", fg="black", font=("Arial", 13))
inputTemperaturaC = tk.Entry(width=20, bg="white", fg="black", textvariable=tempC, font=("Arial", 11))

botonConvertir = tk.Button(text="Convertir", bg="white", fg="black", font=("Arial", 11), command=convertirTemp)

labelTexto2 = tk.Label(text="Temperatura en F:", bg="white", fg="black", font=("Arial", 13))
inputTemperaturaF = tk.Entry(width=20, bg="white", fg="black", textvariable=tempF, font=("Arial", 11))

labelTexto3 = tk.Label(text="Temperatura en K:", bg="white", fg="black", font=("Arial", 13))
inputTemperaturaK = tk.Entry(width=20, bg="white", fg="black", textvariable=tempK, font=("Arial", 11))

labelTexto1.place(x=20, y=20)
inputTemperaturaC.place(x=170, y=23)
botonConvertir.place(x=20, y=65)

labelTexto2.place(x=20, y=130)
inputTemperaturaF.place(x=20, y=165)

labelTexto3.place(x=20, y=200)
inputTemperaturaK.place(x=20, y=235)

root.mainloop()