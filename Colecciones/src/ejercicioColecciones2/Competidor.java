package ejercicioColecciones2;

public interface Competidor 
{
	void registrarResultado(int puntos);
    int obtenerPuntosTotales();
    class JugadorYaRegistrado extends Exception 
    {
        public JugadorYaRegistrado (String message) 
        {    super(message);    }
    }
}
