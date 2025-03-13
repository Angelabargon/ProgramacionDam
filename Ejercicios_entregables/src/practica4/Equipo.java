package practica4;

import java.util.ArrayList;

public class Equipo
{
	//Atributos:
	//	● nombre (String)
	//	● jugadores (ArrayList de objetos de tipo `Participante`)
	//	● puntos (int)
	//Métodos:
	//	● Constructor que reciba el nombre del equipo e inicialice los valores (inicializar puntos
	//	en 0 y jugadores como un ArrayList vacío)
	//	● Getters y setters para cada atributo
	//	● Método `añadirJugador(Participante jugador)` que añada un jugador al equipo
	//	● Método `eliminarJugador(Participante jugador)` que elimine un jugador del equipo
	//	por su nombre y apellido. Si el jugador no existe, lanza una excepción personalizada
	//	llamada `JugadorNoEncontradoException`.
	//	● Método `toString()` que devuelva una cadena con la información del equipo,
	//	incluyendo los jugadores y los puntos acumulados
	String nombre;
	ArrayList<Participante> jugadores = new ArrayList<Participante>();
	int puntos;
	/**
	 * @param nombre
	 * @param jugadores
	 * @param puntos
	 */
	public Equipo(String nombre, ArrayList<Participante> jugadores, int puntos) 
	{
		super();
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.puntos = puntos;
	}
	public int getPuntos() {	return puntos;	}
	public void setPuntos(int puntos) {	this.puntos = puntos;	}
	public String getNombre() {	return nombre;	}
	public void setNombre(String nombre) {	this.nombre = nombre;	}
}
