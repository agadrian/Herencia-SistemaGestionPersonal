

fun main() {
    val persona1 = Persona("Juan", 21)
    val empleado1 = Empleado("Ana", 30, 1500, 10)
    val gerente1 = Gerente("Francisco", 50, 1000, 20, 200.0, false)
    val gerente2 = Gerente("Francisquito", 50, 1000, 20, 200.0, true)

    println(persona1.celebrarCumple())
    println(persona1.toString())

    println("************************************")

    println(empleado1.celebrarCumple())
    println(empleado1.trabajar())
    println(empleado1.calcularSalario())
    println(empleado1.toString())

    println("************************************")

    println("GERENTE 1 EXENTOIMPUESTOS = FALSE")
    println(gerente1.celebrarCumple())
    println(gerente1.trabajar())
    println(gerente1.calcularSalario())
    println(gerente1.administrar())
    println(gerente1.toString())

    println("************************************")

    println("GERENTE 2 EXENTOIMPUESTOS = TRUE")
    println(gerente2.celebrarCumple())
    println(gerente2.trabajar())
    println(gerente2.calcularSalario())
    println(gerente2.administrar())
    println(gerente2.toString())




}