/**
 * Clase que representa a un gerente, que es un empleado con bonus y opción de estar exento de impuestos.
 * @property bonus El bonus adicional del gerente.
 * @property exentoImpuestos Indica si el gerente está exento de impuestos.
 */
class Gerente(nombre: String, edad: Int, salarioBase: Double, porcentajeImpuestos: Double, val bonus: Double, val exentoImpuestos: Boolean = false): Empleado(nombre,edad, salarioBase, porcentajeImpuestos){

    /**
     * Constructor secundario que permite aceptar valores enteros para las variables salariales.
     * @param salarioBase El salario base del gerente.
     * @param porcentajeImpuestos El porcentaje de impuestos aplicado al salario.
     * @param bonus El bonus adicional del gerente.
     * @param exentoImpuestos Indica si el gerente está exento de impuestos.
     */
    constructor(nombre:String, edad: Int, salarioBase: Int, porcentajeImpuestos: Int, bonus: Double, exentoImpuestos: Boolean ): this(nombre, edad, salarioBase.toDouble(), porcentajeImpuestos.toDouble(), bonus, exentoImpuestos)

    override val porcentajeImpuestos = 33.99

    /**
     * Método que calcula el salario del gerente.
     * @return El salario calculado teniendo en cuenta el bonus y la exención de impuestos.
     */
    override fun calcularSalario(): Double {
        if (exentoImpuestos) return (salarioBase + bonus)
        return (super.calcularSalario() + bonus)

        //return (salarioBase - (salarioBase * (porcentajeImpuestos / 100))) + bonus
    }

    /**
     * Método que devuelve una representación en cadena de la persona.
     * @return La representación en cadena de la persona.
     */
    override fun toString(): String {
        //TODO Si lo pongo como el comentado, me muestra el toString de la clAse padre, por lo que no se muestra con los nuevos datos del salario
        //return "${super.toString()}; Bonus: $bonus; Exento Impuestos?: $exentoImpuestos"

        return "Nombre: ${this.nombre}; Edad: ${this.edad}; Salario: ${"%.2f".format(calcularSalario())}; Bonus: $bonus; Exento Impuestos?: $exentoImpuestos"
    }

    /**
     * Método que indica que el gerente está administrando la empresa.
     * @return Un mensaje indicando que el gerente está administrando la empresa.
     */
    fun administrar():String{
        return "$nombre esta administrando la empresa"
    }
}