package probatinas

import java.util.Scanner

fun saludar(nombre:String ):String {

    return "Hola $nombre !"

}

fun main(){

    val p1 = Persona("Persona 1",33,2000.0)

    // p1 = 33 No va por que p1 ya está asginado como valor Persona

    // p1.nombre = "Paco" No se puede por que nombre es val

    // Esto si que se puede hacer ya que edad es var
    p1.edad = ++p1.edad

    // p1 = Persona("Persona 2",2,0.0) Esto no se puede hacer ya que p1 es val

    println(p1)


}