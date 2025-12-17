from turtle import *
speed(9999999999999999)
color("red")
contador = 1
esferas = 3
while True:
    begin_fill()
    circle(100)
    end_fill()
    forward(100)
    contador += 1
    if contador % 2 == 0:
        color("black")

    else:
        color("red")
    if contador == esferas+1:
        color("blue")
        left(90)
        forward(200)
        left(90)
        forward((esferas+1)*100)
        left(90)
        forward(200)
        left(90)
        forward((esferas+1)*100)
        mainloop()