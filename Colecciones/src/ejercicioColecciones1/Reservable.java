package ejercicioColecciones1;

public interface Reservable 
{
	boolean reservar(String usuario, int cantidad) throws CapacidadMaxima;
	boolean cancelarReserva(String usuario) throws ReservaInexistente;
	int plazasDisponibles();
	class CapacidadMaxima extends Exception
	{
		public CapacidadMaxima(String msj) 
		{
	        super(msj);
	    }
	}
	class ReservaInexistente extends Exception
	{
		public ReservaInexistente(String msj) 
		{
	        super(msj);
	    }
	}
}
