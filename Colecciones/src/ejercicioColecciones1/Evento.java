package ejercicioColecciones1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Evento implements Reservable
{
	private String nombre;
	private LocalDate fecha;
	private int capacidad;
	Map<String, Integer> reservas = new HashMap<>();
	/**
	 * @param nombre
	 * @param fecha
	 * @param capacidad
	 * @param reservas
	 */
	public Evento(String nombre, LocalDate fecha, int capacidad, Map<String, Integer> reservas) 
	{
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.capacidad = capacidad;
		this.reservas = reservas;
	}
	/**
	 * @param nombre
	 * @param fecha
	 * @param capacidad
	 */
	public Evento(String nombre, LocalDate fecha, int capacidad) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.capacidad = capacidad;
		this.reservas = new HashMap<>(); 
	}
	@Override
	public boolean reservar(String usuario, int cantidad) throws CapacidadMaxima
	{	 
		 if (plazasDisponibles() + cantidad <= capacidad) 
		 {
			 	reservas.put(usuario, reservas.getOrDefault(usuario, 0) + cantidad);
	            System.out.println("Reserva realizada para " + usuario + " con " + cantidad + " plazas.");
	            return true;
		}    	
	    else 
	    {   
	    	throw new CapacidadMaxima("Límite de reservas alcanzado, no quedan plazas.");
	    }
	}	
	@Override
	public boolean cancelarReserva(String usuario) throws ReservaInexistente
	{	
		if (reservas.containsKey(usuario))
		{
			reservas.remove(usuario);
			System.out.println("Reserva eliminada con éxito");
			return true;
		}
		else
		{
			throw new ReservaInexistente("El usuario no tiene reserva, no se puede eliminar");
		}
	}
	@Override
	public int plazasDisponibles()  
	{	
		int reservadas= 0;
		for (int cantidad : reservas.values())
		{	reservadas += cantidad;  }
		return capacidad - reservadas;
	}
	public String getNombre() 
	{	return nombre;	}
	public void setNombre(String nombre) 
	{	this.nombre = nombre;	}
	public LocalDate getFecha() 
	{	return fecha;	}
	public void setFecha(LocalDate fecha) 
	{	this.fecha = fecha;	}
	public int getCapacidad() 
	{	return capacidad;	}
	public void setCapacidad(int capacidad) 
	{	this.capacidad = capacidad;	}
	public Map<String, Integer> getReservas() 
	{	return reservas;	}
	public void setReservas(Map<String, Integer> reservas) 
	{	this.reservas = reservas;	}
	@Override
	public String toString() {
		return "Evento [nombre=" + nombre + ", fecha=" + fecha + ", capacidad=" + capacidad + ", reservas=" + reservas
				+ ", plazasDisponibles()=" + plazasDisponibles() + ", getNombre()=" + getNombre() + ", getFecha()="
				+ getFecha() + ", getCapacidad()=" + getCapacidad() + ", getReservas()=" + getReservas()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
