def suma(a,b):
    return a+b

def resta(a,b):
    return a-b

a = 30
b = 40
resultado = suma(suma(suma(suma(a,b), suma(a,b)), suma(suma(a,b),suma(a,b))),suma(suma(suma(a,b), suma(a,b)), suma(suma(a,b), suma(a,b))))

if  resultado > 500:
    print("El resultado es mayor a 500")
else:
    print("El resultado es menor a 500")

print("----------------------------------")
# Imprimir de 0 a 5
for i in range(6):
    print(i)

print("----------------------------------")
for i in range(10,20):
    print(i)

print("----------------------------------")
lista = ["Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"]

for i in lista:
    print(i)

print("----------------------------------")
i = 0
while i < 10:
    print(i)
    i = i + 1
