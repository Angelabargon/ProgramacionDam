package ejercicioColecciones1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ejercicioColecciones1.Reservable.CapacidadMaxima;
import ejercicioColecciones1.Reservable.ReservaInexistente;

public class SistemaReservas 
{
    private List<Evento> eventos;
    public SistemaReservas() 
    {    this.eventos = new ArrayList<>();    }
    public void agregarEvento(Evento evento) 
    {    this.eventos.add(evento);    }
    public List<Evento> filtrarEventosPorFecha(LocalDate fecha) 
    {
        return eventos.stream()
                .filter(evento -> evento.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
    public List<Evento> filtrarEventosPorFechaHora(LocalDateTime fechaHora) 
    {
        return eventos.stream()
                .filter(evento -> evento.getFecha().isEqual(fechaHora.toLocalDate())) // Consideramos solo la fecha para este ejemplo
                .collect(Collectors.toList());
    }
    public List<Evento> obtenerEventosProximos7Dias() 
    {
        LocalDate hoy = LocalDate.now();
        LocalDate en7Dias = hoy.plusDays(7);
        return eventos.stream()
                .filter(evento -> !evento.getFecha().isBefore(hoy) && !evento.getFecha().isAfter(en7Dias))
                .collect(Collectors.toList());
    }
    public List<Evento> obtenerEventosSinReservas() 
    {
        return eventos.stream()
                .filter(evento -> evento.getReservas().isEmpty())
                .collect(Collectors.toList());
    }
    public void ordenarEventosPorFecha() 
    {    eventos.sort(Comparator.comparing(Evento::getFecha));    }
    public List<Evento> filtrarEventos(Predicate<Evento> criterio) 
    {
        return eventos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }
    public int calcularTotalReservas() 
    {
        return eventos.stream()
                .flatMap(evento -> evento.getReservas().values().stream())
                .mapToInt(Integer::intValue)
                .sum();
    }
    public static void main(String[] args) 
    {
        SistemaReservas sistema = new SistemaReservas();
        Evento concierto = new Evento("Concierto de Música", LocalDate.of(2025, 4, 5), 100);
        Evento taller = new Evento("Taller de Arte", LocalDate.of(2025, 4, 10), 20);
        Evento charla = new Evento("Charla Educativa", LocalDate.of(2025, 4, 3), 50);
        sistema.agregarEvento(concierto);
        sistema.agregarEvento(taller);
        sistema.agregarEvento(charla);
        try {
            concierto.reservar("Usuario1", 5);
            concierto.reservar("Usuario2", 10);
            taller.reservar("Usuario3", 15);
            System.out.println(concierto);
            System.out.println(taller);
        } 
        catch (CapacidadMaxima e) 
        {
	        System.err.println("Error al reservar: " + e.getMessage());
        }
        try 
        {
            taller.cancelarReserva("Usuario3");
            System.out.println(taller);
        } 
        catch (ReservaInexistente e) 
        {	System.err.println("Error al cancelar reserva: " + e.getMessage());	}
        System.out.println("Plazas disponibles en Concierto: " + concierto.plazasDisponibles());
        System.out.println("Eventos para el 5 de abril: " + sistema.filtrarEventosPorFecha(LocalDate.of(2025, 4, 5)));
        System.out.println("Eventos próximos en 7 días: " + sistema.obtenerEventosProximos7Dias());
        System.out.println("Eventos sin reservas: " + sistema.obtenerEventosSinReservas());
        sistema.ordenarEventosPorFecha();
        System.out.println("Eventos ordenados por fecha:");
        sistema.eventos.forEach(System.out::println);
        List<Evento> eventosAbril = sistema.filtrarEventos(evento -> evento.getFecha().getMonthValue() == 4);
        System.out.println("Eventos en abril: " + eventosAbril);
        int totalReservas = sistema.calcularTotalReservas();
        System.out.println("Total de reservas en todos los eventos: " + totalReservas);
   }
}
