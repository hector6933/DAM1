class Datos:

    def cosa(self):
        return "Six Seven"

    color = "red"
    x = 67
    y = -67

a = Datos()
a.color = "blue"
print(a.color)
print(a.x)
print(a.y)

print(a.cosa())

class Coche:
    marca = "Toyota"
    def __init__(self, modelo):
        self.modelo = modelo

coche = Coche("Corolla")
print(coche.marca)
print(coche.modelo)
