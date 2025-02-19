package interfaces_y_enumerados;

public class Pelicula implements Reproducible
{
	@Override
	public void obtenerTipoContenido() {	TipoContenido contenido = TipoContenido.PELICULA;		}
	@Override
	public String reproducir() {	return "Reproduciendo la película...";	}
	@Override
	public String pausar() {	return "Pausando la película...";	}
}
