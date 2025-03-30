package ejercicioColecciones3;


public interface Prestable 
{
	boolean Prestar(String usuario) throws LibroNoDisponible;
	boolean Devolver(String usuario) throws LibroNoPrestado, PrestamoNoValido ;
	class LibroNoDisponible extends Exception 
	{
	    public LibroNoDisponible(String message) 
	    {    super(message);    }
	}
	class LibroNoPrestado extends Exception 
	{
	    public LibroNoPrestado(String message) 
	    {	super(message);    }
	}
	class PrestamoNoValido extends Exception 
	{
	    public PrestamoNoValido (String message) 
	    {	super(message);    }
}