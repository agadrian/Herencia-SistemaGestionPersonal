/**
 * Clase que representa a un empleado, que es una persona con salario y porcentaje de impuestos.
 *
 * @property salarioBase El salario base del empleado.
 * @property porcentajeImpuestos El porcentaje de impuestos aplicado al salario.
 */
open class Empleado(nombre: String, edad: Int, val salarioBase: Double, open val porcentajeImpuestos: Double = 10.0):Persona(nombre, edad){

    /**
     * Constructor secundario que permite aceptar valores enteros para las variables salariales.
     * @param salarioBase El salario base del empleado.
     * @param porcentajeImpuestos El porcentaje de impuestos aplicado al salario.
     */
    // Permitimos aceptar valores Int en las 2 ultimas variables tambien, y delegamos al contructor primario como .toDouble()
    constructor(nombre: String, edad: Int, salarioBase: Int, porcentajeImpuestos: Int = 10): this(nombre, edad, salarioBase.toDouble(), porcentajeImpuestos.toDouble()){
    }

    private val salario : Double
        get() = salarioBase - (salarioBase * (porcentajeImpuestos / 100))

    /**
     * Método que calcula el salario del empleado.
     * @return El salario calculado.
     */
    open fun calcularSalario(): Double{
        return salario
    }

    /**
     * Metotdo que devuelve una cadena de que esta trabajando
     */
    fun trabajar(): String{
        return "$nombre esta trabajando"
    }

    /**
     * Método que devuelve una representación en cadena de la persona.
     * @return La representación en cadena de la persona.
     */
    override fun toString(): String {
        return "${super.toString()}; Salario: $salario; Porcentaje impuesto: $porcentajeImpuestos"
    }
}
