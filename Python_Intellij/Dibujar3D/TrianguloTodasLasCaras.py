import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d.art3d import Poly3DCollection

# Define los vértices del cubo
vertices = np.array([
    [0, 0, 0],  # Vértice 0
    [1, 0, 0],  # Vértice 1
    [1, 1, 0],  # Vértice 2
    [0, 1, 0],  # Vértice 3
    [0.5, 0.5, 1],  # Vértice 4
])

# Define las caras del cubo mediante los índices de los vértices
faces = [
    [vertices[0], vertices[1], vertices[4]],  # Cara inferior
    [vertices[0], vertices[3], vertices[4]],  # Cara inferior
    [vertices[1], vertices[2], vertices[4]],  # Cara inferior
    [vertices[2], vertices[3], vertices[4]],  # Cara inferior
    [vertices[0], vertices[1], vertices[2], vertices[3]]
]

# Crear la figura y el eje 3D
fig = plt.figure(figsize=(8, 8))
ax = fig.add_subplot(111, projection='3d')

# Añadir las caras del cubo al gráfico
poly3d = Poly3DCollection(faces, edgecolors='k', linewidths=1, alpha=0.5, facecolors='lime')
ax.add_collection3d(poly3d)

# Ajustar los límites de los ejes
ax.set_xlim([0, 1])
ax.set_ylim([0, 1])
ax.set_zlim([0, 1])

# Etiquetas y título
ax.set_xlabel('X')
ax.set_ylabel('Y')
ax.set_zlabel('Z')
ax.set_title('Triángulo en 3D')

# Mostrar la gráfica
plt.show()