from operator import truediv
from turtle import *
speed(9999999999999999)
color("red")
contador = 1
hideturtle()
colorr = 1
while True:
    if colorr % 2 == 0:
        color("red")
    else:
        color("green")
    colorr += 1
    for i in range(4):
        forward(200)
        left(90)
        left(90)
        forward(200)
        left(90)
    left(contador)
    forward(contador)
    contador += 0.5
