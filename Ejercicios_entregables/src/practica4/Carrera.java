package practica4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Carrera extends EventoDeportivo<Participante>
{
	//Para `Carrera`:
	//	● Añade el atributo `distancia` (double) que represente la distancia de la carrera en
	//	kilómetros
	//	● Modifica el constructor para incluir el nuevo atributo
	//	● Implementa el método `obtenerGanador()` de forma que devuelva el participante con
	//	el menor tiempo registrado (asumiendo que cada participante tiene un atributo de
	//	tiempo registrado en segundos)
	Double distancia;
	/**
	 * @param nombre
	 * @param lugar
	 * @param fecha
	 * @param participantes
	 * @param distancia
	 */
	public Carrera(String nombre, String lugar, LocalDate fecha, ArrayList<Participante> participantes, Double distancia) 
	{
		super(nombre, lugar, fecha, participantes);
		this.distancia = distancia;
	}
	@Override
	public Participante obtenerGanador() 
	{	
		if (participantes.isEmpty()) 
		{
			throw new IllegalStateException("No hay participantes en la carrera");
		}
		Participante ganador = participantes.get(0);
		for (Participante p : participantes) 
		{
			if (p.getTiempo() < ganador.getTiempo()) 
			{
				ganador = p;
			}
		}
		return ganador;
	}
	public Double getDistancia() {	return distancia;	}
	public void setDistancia(Double distancia) {	this.distancia = distancia;	}
}
