import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

root = tk.Tk()

root.title("Ventana guapa")

root.config(width=500, height=500, background="white")

frame = tk.Frame(bg="red", width=250, height=250)
frame2 = tk.Frame(bg="blue", width=250, height=250)
frame3 = tk.Frame(bg="green", width=250, height=250)
frame4 = tk.Frame(bg="yellow", width=250, height=250)

separacion = 20
frame.grid(row=0, column=0, padx=separacion, pady=separacion)
etiqueta = tk.Label(frame, text="Etiqueta")
etiqueta.place(relx=0.40, rely=0.05)
radiobutton1 = tk.Radiobutton(frame, text="Estudios Básicos")
radiobutton2 = tk.Radiobutton(frame, text="Estudios Medios")
radiobutton3 = tk.Radiobutton(frame, text="Estudios Avanzados")

frame2.grid(row=250, column=0, padx=separacion, pady=separacion)
etiqueta2 = tk.Label(frame2, text="Etiqueta")
etiqueta2.place(relx=0.40, rely=0.05)

frame3.grid(row=0, column=250, padx=separacion, pady=separacion)
etiqueta3 = tk.Label(frame3, text="Etiqueta")
etiqueta3.place(relx=0.40, rely=0.05)

frame4.grid(row=250, column=250, padx=separacion, pady=separacion)
etiqueta4 = tk.Label(frame4, text="Etiqueta")
etiqueta4.place(relx=0.40, rely=0.05)

mainloop()
