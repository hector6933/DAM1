
# Arrays

print("---------------------------------------------------------")

L = ["Dylan M","Iker","Alonso","Héctor C","Pablo"]
print("Primer alumno de la primera fila")
print(L[0])

print("Alumnos de la primera fila: ")
for alumno in L:
    print(alumno)

print("---------------------------------------------------------")

print("Alumnos de la primera y segunda fila: ")
L = L + ["Dylan Rojas","Héctor Enguita","Daniel Quiles", "Andrés Stan","Remón"]
for alumno in L:
    print(alumno)

# Diccionarios

print("---------------------------------------------------------")

usuario = {"nombre":"Ana","edad":30}
print(usuario["edad"])

print("---------------------------------------------------------")

colores = {"red":"rojo","blue":"azul","green":"verde","yellow":"amarillo"}
print(colores["green"])

print("---------------------------------------------------------")

usuario2 = {"nombre":"Marcos","edad":45,"localidad":"Teruel"}
print(usuario2["edad"])
print(usuario2["localidad"])

# Tuplas

print("---------------------------------------------------------")

a = (1,2,3,4)
b = (5,6,7,8)

c = a + b
print(c)
