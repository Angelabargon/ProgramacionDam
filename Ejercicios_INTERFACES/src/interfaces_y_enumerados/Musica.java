package interfaces_y_enumerados;

public class Musica implements Reproducible
{
	@Override
	public void obtenerTipoContenido() {	TipoContenido contenido = TipoContenido.MUSICA;	}
	@Override
	public String reproducir() {	return "Reproduciendo la cancion...";	}
	@Override
	public String pausar() {	return "Pausando la canción...";	}
}
