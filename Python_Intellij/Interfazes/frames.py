import tkinter as tk
from tkinter import ttk
from tkinter import mainloop

root = tk.Tk()

root.title("Ventana guapa")

root.config(width=500, height=500, background="white")

frame = tk.Frame(bg="red", width=250, height=250)
frame2 = tk.Frame(bg="green", width=250, height=250)
frame3 = tk.Frame(bg="blue", width=250, height=250)
frame4 = tk.Frame(bg="yellow", width=250, height=250)

separacion = 20


sexo = tk.BooleanVar(value=False)
nivel = tk.BooleanVar(value=False)
aficiones = tk.BooleanVar(value=False)
frame.grid(row=0, column=0, padx=separacion, pady=separacion)
etiqueta = tk.Label(frame, text="Sexo:")
etiqueta.place(relx=0.15, rely=0.1)

radiobutton1 = ttk.Radiobutton(frame, text="Hombre", variable=sexo, value=1)
radiobutton2 = ttk.Radiobutton(frame, text="Mujer", variable=sexo, value=2)

radiobutton1.place(relx=0.15, rely=0.25)
radiobutton2.place(relx=0.15, rely=0.40)

frame2.grid(row=250, column=0, padx=separacion, pady=separacion)
etiqueta2 = tk.Label(frame2, text="Aficiones:")
etiqueta2.place(relx=0.15, rely=0.1)

checkbutton1 = ttk.Checkbutton(frame2, text="Cine", variable=aficiones, onvalue=1)
checkbutton2 = ttk.Checkbutton(frame2, text="Viajes", variable=aficiones,onvalue=2)
checkbutton3 = ttk.Checkbutton(frame2, text="Deportes", variable=aficiones,onvalue=3)

checkbutton1.place(relx=0.15, rely=0.25)
checkbutton2.place(relx=0.15, rely=0.40)
checkbutton3.place(relx=0.15, rely=0.55)


frame3.grid(row=0, column=250, padx=separacion, pady=separacion)
etiqueta3 = tk.Label(frame3, text="Nivel de estudios:")
etiqueta3.place(relx=0.15, rely=0.1)

radiobutton3 = ttk.Radiobutton(frame3, text="Estudios Básicos", variable=nivel, value=3)
radiobutton4 = ttk.Radiobutton(frame3, text="Estudios Medios", variable=nivel, value=4)
radiobutton5 = ttk.Radiobutton(frame3, text="Estudios Avanzados", variable=nivel, value=5)

radiobutton3.place(relx=0.15, rely=0.25)
radiobutton4.place(relx=0.15, rely=0.40)
radiobutton5.place(relx=0.15, rely=0.55)

frame4.grid(row=250, column=250, padx=separacion, pady=separacion)
etiqueta4 = tk.Label(frame4, text="Días disponibles:")
etiqueta4.place(relx=0.15, rely=0.1)

checkbutton3 = ttk.Checkbutton(frame4, text="Lunes")
checkbutton4 = ttk.Checkbutton(frame4, text="Miércoles")
checkbutton5 = ttk.Checkbutton(frame4, text="Viernes")

checkbutton3.place(relx=0.15, rely=0.25)
checkbutton4.place(relx=0.15, rely=0.40)
checkbutton5.place(relx=0.15, rely=0.55)

mainloop()
