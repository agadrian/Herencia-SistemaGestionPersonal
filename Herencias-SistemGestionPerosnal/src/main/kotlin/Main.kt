

open class Persona(val nombre: String, var edad: Int){


    fun celebrarCumple(): String{
        this.edad++
        return "Feliz cumpleaños ${this.nombre}, ahora tienes ${this.edad} años"
    }

    override fun toString(): String {
        return "Nombre: ${this.nombre}; Edad: ${this.edad}"
    }
}


open class Empleado(nombre: String, edad: Int, val salarioBase: Double, open val porcentajeImpuestos: Double = 10.0):Persona(nombre, edad){

    // Permitimos aceptar valores Int en las 2 ultimas variables tambien, y delegamos al contructor primario como .toDouble()
    constructor(nombre: String, edad: Int, salarioBase: Int, porcentajeImpuestos: Int = 10): this(nombre, edad, salarioBase.toDouble(), porcentajeImpuestos.toDouble()){

    }

    private val salario : Double
        get() = salarioBase - (salarioBase * (porcentajeImpuestos / 100))


    open fun calcularSalario(): Double{
        return salario
    }

    fun trabajar(): String{
        return "$nombre esta trabajando"
    }

    override fun toString(): String {
        return "${super.toString()}; Salario: $salario; Porcentaje impuesto: $porcentajeImpuestos"
    }
}


class Gerente(nombre: String, edad: Int, salarioBase: Double, porcentajeImpuestos: Double, val bonus: Double, val exentoImpuestos: Boolean = false): Empleado(nombre,edad, salarioBase, porcentajeImpuestos){

    constructor(nombre:String, edad: Int, salarioBase: Int, porcentajeImpuestos: Int, bonus: Double, exentoImpuestos: Boolean ): this(nombre, edad, salarioBase.toDouble(), porcentajeImpuestos.toDouble(), bonus, exentoImpuestos)


    override val porcentajeImpuestos = 33.99



    override fun calcularSalario(): Double {
        if (exentoImpuestos) return (salarioBase + bonus)
        return (super.calcularSalario() + bonus)

        //return (salarioBase - (salarioBase * (porcentajeImpuestos / 100))) + bonus
    }

    override fun toString(): String {
        //TODO Si lo pongo como el comentado, me muestra el toString de la clAse padre, por lo que no se muestra con los nuevos datos del salario
        //return "${super.toString()}; Bonus: $bonus; Exento Impuestos?: $exentoImpuestos"

        return "Nombre: ${this.nombre}; Edad: ${this.edad}; Salario: ${calcularSalario()}; Bonus: $bonus; Exento Impuestos?: $exentoImpuestos"
    }

    fun administrar():String{
        return "$nombre esta administrando la empresa"
    }
}


fun main() {

    val persona1 = Persona("Juan", 21)
    val empleado1 = Empleado("Ana", 30, 1500)
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