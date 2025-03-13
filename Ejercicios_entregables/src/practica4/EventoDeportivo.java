package practica4;
import java.util.ArrayList;
import java.time.LocalDate;

public abstract class EventoDeportivo<T> implements Ganador<T>
{
	//Atributos:
	//	● nombre (String)
	//	● fecha (utilizar clase más adecuada de java.time)
	//	● lugar (String)
	//	● participantes (ArrayList de objetos de tipo `Participante`)
	//Métodos:
	//	● Constructor que reciba los atributos e inicialice los valores
	//	● Getters y setters para cada atributo
	//	● Método `inscribirParticipante(Participante participante)` que reciba un objeto de tipo
	//	`Participante` y lo añada a la lista de participantes
	//	● Método `obtenerGanador()` que devuelva el objeto de tipo `Participante` que
	//	represente al ganador del evento. Este método debe ser implementado en las
	//	subclases.
	String nombre, lugar;
	LocalDate fecha;
	ArrayList<Participante> participantes = new ArrayList<Participante>();
	/**
	 * El constructor está compuesto de los siguientes atributos:
	 * @param nombre
	 * @param lugar
	 * @param fecha
	 * @param participantes
	 */
	public EventoDeportivo(String nombre, String lugar, LocalDate fecha, ArrayList<Participante> participantes) 
	{
		super();
		this.nombre = nombre;
		this.lugar = lugar;
		this.fecha = fecha;
		this.participantes = participantes;
	}
	/**
	 * Estos son los métodos getters y setters de los atributos de un evento deportivo
	 * @return
	 */
	public String getNombre() {	return nombre;	}
	public void setNombre(String nombre) {	this.nombre = nombre;	}
	public String getLugar() {	return lugar;	}
	public void setLugar(String lugar) {	this.lugar = lugar;	}
	public LocalDate getFecha() {	return fecha;	}
	public void setFecha(LocalDate fecha) {	this.fecha = fecha;	}
	public ArrayList<Participante> getParticipantes() {	return participantes;	}
	public void setParticipantes(ArrayList<Participante> participantes) {	this.participantes = participantes;	}
	/**
	 * 
	 * @param participante
	 */
	public void inscribirParticipante (Participante participante) 
	{	
		if (participante == null) {
			throw new IllegalArgumentException("El participante no puede ser nulo");
		}
		if (participante.getEdad() < 14) {
			throw new ParticipanteNoValidoException("La edad del participante no puede ser menor a 14 años");
		}
		if (!participantes.contains(participante)) {
			participantes.add(participante);
			System.out.println("Participante inscrito: " + participante.getNombre());
		} else {
			System.out.println("El participante ya está inscrito.");
		}
	}
	@Override
	/**
	 * Método para obtener el ganador del evento deportivo, en las subclases se ve cada tipo de ganador
	 */
	public abstract T obtenerGanador();
	/**
	 * Excepción para cuando el participante es menor de 14 que devuelve el mensaje del throw
	 */
	 public static class ParticipanteNoValidoException extends RuntimeException 
	 { 
	        private static final long serialVersionUID = 1L;                    // He tenido que mirar como se podía corregir el error en gemini ya que no podía sacarlo :,)
	        public ParticipanteNoValidoException(String mensaje) {
	            super(mensaje);
	        }
	    }
}
