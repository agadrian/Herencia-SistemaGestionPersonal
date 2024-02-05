/**
 * Clase base que representa a una persona con nombre y edad.
 * @property nombre El nombre de la persona.
 * @property edad La edad de la persona.
 */
open class Persona(val nombre: String, var edad: Int){

    /**
     * Metodo que suma un año a la persona y muestra un mensaje
     * @return Un mensaje de felicitación por el cumpleaños.
     */
    fun celebrarCumple(): String{
        this.edad++
        return "Feliz cumpleaños ${this.nombre}, ahora tienes ${this.edad} años"
    }

    /**
     * Método que devuelve una representación en cadena de la persona.
     * @return La representación en cadena de la persona.
     */
    override fun toString(): String {
        return "Nombre: ${this.nombre}; Edad: ${this.edad}"
    }
}