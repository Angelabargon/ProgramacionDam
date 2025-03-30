package ejercicioColecciones2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ejercicioColecciones2.Competidor.JugadorYaRegistrado;

public class Torneo 
{
    private List<Jugador> jugadores;
    public Torneo() 
    {    this.jugadores = new ArrayList<>();    }
    public void agregarJugador(Jugador jugador) throws JugadorYaRegistrado 
    {
        for (Jugador j : jugadores) 
        {
            if (j.getNombre().equals(jugador.getNombre())) 
            {
                throw new JugadorYaRegistrado ("El jugador con el nombre '" + jugador.getNombre() + "' ya está registrado en el torneo.");
            }
        }
        jugadores.add(jugador);
    }
    public void mostrarTop3Jugadores() 
    {
        System.out.println("<- Top 3 Jugadores ->");
        jugadores.stream()
                .sorted(Comparator.comparingInt(Jugador::obtenerPuntosTotales).reversed())
                .limit(3)
                .forEach(System.out::println);
        System.out.println(".                        .");
    }
    public List<Jugador> filtrarJugadoresPorPuntos(int puntosMinimos) 
    {
        return jugadores.stream()
                .filter(jugador -> jugador.obtenerPuntosTotales() > puntosMinimos)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) 
    {
        Torneo torneo = new Torneo();
        try 
        {
            Jugador ana = new Jugador("Ana", LocalDate.now());
            Jugador pepe = new Jugador("Pepe", LocalDate.now().minusDays(2));
            Jugador juana = new Jugador("Juana", LocalDate.now().minusWeeks(1));
            Jugador ana2 = new Jugador("Ana", LocalDate.now()); 
            torneo.agregarJugador(ana);
            torneo.agregarJugador(pepe);
            torneo.agregarJugador(juana);
            torneo.agregarJugador(ana2); 
            ana.registrarResultado(15);
            ana.registrarResultado(20);
            pepe.registrarResultado(30);
            juana.registrarResultado(10);
            juana.registrarResultado(12);
            juana.registrarResultado(8);
            torneo.mostrarTop3Jugadores();
            List<Jugador> jugadoresConMasDe20Puntos = torneo.filtrarJugadoresPorPuntos(20);
            System.out.println("\nJugadores con más de 20 puntos:");
            jugadoresConMasDe20Puntos.forEach(System.out::println);
        } 
        catch (JugadorYaRegistrado e) 
        {    System.err.println("Error al registrar jugador: " + e.getMessage());    }
    }
}
