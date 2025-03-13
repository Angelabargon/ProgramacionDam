package practica4;
import java.time.LocalDate;
import java.util.ArrayList;
public class TorneoDeFutbol extends EventoDeportivo<Equipo>
{
	//Para `TorneoDeFutbol`:
	//	● Añade el atributo `equipos` (ArrayList de objetos de tipo `Equipo`)
	//	● Modifica el constructor para incluir el nuevo atributo
	//	● Implementa el método `obtenerGanador()` de forma que devuelva el equipo con la
	//	mayor cantidad de puntos acumulados (asumiendo que cada equipo tiene un atributo
	//	de puntos acumulados)
	ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	/**
	 * @param nombre
	 * @param lugar
	 * @param fecha
	 * @param participantes
	 * @param equipos
	 */
	public TorneoDeFutbol(String nombre, String lugar, LocalDate fecha, ArrayList<Participante> participantes, ArrayList<Equipo> equipos) 
	{
		super(nombre, lugar, fecha, participantes);
		this.equipos = equipos;
	}
	public ArrayList<Equipo> getEquipos() {	return equipos;	}
	public void setEquipos(ArrayList<Equipo> equipos) {	this.equipos = equipos;	}
	@Override
	public Equipo obtenerGanador() 
	{	
		if (equipos.isEmpty()) 
		{
			throw new IllegalStateException("No hay equipos en el torneo");
		}
		else if (equipos.size() < 2)
		{
			Equipo ganador = equipos.get(0);
			return ganador;
		}
		else
		{
			Equipo ganador = equipos.get(0);
			for (Equipo e : equipos)
			{
				if (e.getPuntos() > ganador.getPuntos()) 
				{
					ganador = e;
				}
			}
			return ganador;
		}
	}	
}
