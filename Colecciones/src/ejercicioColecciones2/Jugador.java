package ejercicioColecciones2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Competidor 
{
	private String nombre;
    private LocalDate fechaRegistro;
    private List<Integer> partidas;

    public Jugador(String nombre, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.partidas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public List<Integer> getPartidas() {
        return partidas;
    }

    @Override
    public void registrarResultado(int puntos) {
        partidas.add(puntos);
    }

    @Override
    public int obtenerPuntosTotales() {
        return partidas.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        return "Jugador{" +
               "nombre='" + nombre + '\'' +
               ", puntosTotales=" + obtenerPuntosTotales() +
               '}';
    }
}
