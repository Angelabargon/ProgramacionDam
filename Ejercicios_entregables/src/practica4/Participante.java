package practica4;

public class Participante 
{
	//Atributos:
	//	● nombre (String)
	//	● apellido (String)
	//	● edad (int)
	//Métodos:
	//	● Constructor que reciba todos los atributos e inicialice los valores
	//	● Getters y setters para cada atributo
	//	● Método `toString()` que devuelva una cadena con la información del participante
	String nombre, apellidos;
	int edad;
	Double tiempo;
	/**
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param tiempo
	 */
	public Participante(String nombre, String apellidos, int edad, double tiempo) 
	{
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.tiempo = tiempo;
	}
	public String getNombre() {	return nombre;	}
	public void setNombre(String nombre) {	this.nombre = nombre;	}
	public String getApellidos() {	return apellidos;	}
	public void setApellidos(String apellidos) {	this.apellidos = apellidos;	}
	public int getEdad() {	return edad;	}
	public void setEdad(int edad) {	this.edad = edad;	}
	public Double getTiempo() {		return tiempo;	}
	public void setTiempo(Double tiempo) {	this.tiempo = tiempo;	}
	@Override
	public String toString() 
	{	return "Participante \nNombre=" + nombre + "\nApellidos=" + apellidos + "\nEdad=" + edad;	}
}
