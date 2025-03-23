package gestion_equipo_futbol;

public class Futbolista
{
	private String nombre;
	private int edad;
	private Posicion posicion;
	/**
	 * @param nombre
	 * @param edad
	 * @param posicion
	 */
	public Futbolista(String nombre, int edad, Posicion posicion) 
	{
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.posicion = posicion; 
	}
	public String getNombre() {	return nombre;	}
	public void setNombre(String nombre) {	this.nombre = nombre;	}
	public int getEdad() {	return edad;	}
	public void setEdad(int edad) {	this.edad = edad;	}
	public Posicion getPosicion() {	return posicion;	}
	public void setPosicion(Posicion posicion) {	this.posicion = posicion;	}
	public void salarioMaxMin(Posicion posicion)
	{
		double salarioMax, salarioMin;
		switch(posicion) 
		{
			case PORTERO: 
				salarioMax = 3000;
				salarioMin = 2000;
				break;
			case DEFENSA: 
				salarioMax = 3500;
				salarioMin = 2500;
				break;
			case CENTROCAMPISTA: 
				salarioMax = 4000;
				salarioMin = 3500;
				break;
			case DELANTERO: 
				salarioMax = 5000;
				salarioMin = 4000;		
				break;
			default:
				System.out.println("No existe esa posición");
				break;
		}
	}
	@Override
	public String toString() 
	{
		return "Futbolista:\n" + "[ Nombre = " + nombre + "   Edad = " + edad + "   Posicion = " + posicion + " ]\n";
	}
}
