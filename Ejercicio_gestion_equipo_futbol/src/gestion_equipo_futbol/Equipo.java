package gestion_equipo_futbol;

import java.util.ArrayList;

public class Equipo 
{
	private String nombre;
	private ArrayList<Futbolista> listadoDeFutbolistas = new ArrayList<Futbolista>();
	/**
	 * @param nombre
	 * @param listadoDeFutbolistas
	 */
	public Equipo(String nombre, ArrayList<Futbolista> listadoDeFutbolistas) 
	{
		super();
		this.setNombre(nombre);
		this.listadoDeFutbolistas = listadoDeFutbolistas;
	}
	class RegistroFutbolistaException extends Exception
	{
		public RegistroFutbolistaException(String msj) {
	        super(msj);
	    }
	}
	public void agregarFutbolista(Futbolista futbolista) throws RegistroFutbolistaException 
	{
        long count = listadoDeFutbolistas.stream().filter(f -> f.getPosicion() == futbolista.getPosicion()).count();
        if (count < futbolista.getPosicion().getLimitePosiciones()) 
        {	listadoDeFutbolistas.add(futbolista);	} 
        else 
        {    throw new RegistroFutbolistaException("Límite alcanzado para la posición " + futbolista.getPosicion());   }
    }
	public void listarFormacionDelEquipo() 
	{
		for (Posicion posicion : Posicion.values()) 
		{
            for (Futbolista fut : listadoDeFutbolistas) 
            {
                if (fut.getPosicion() == posicion) 
                {    System.out.println(fut);   }
            }
        }
    }
	public String getNombre() 
	{	return nombre;	}
	public void setNombre(String nombre) 
	{	this.nombre = nombre;	}
	public ArrayList<Futbolista> getListadoDeFutbolistas() 
	{	return listadoDeFutbolistas;	}
	public void setListadoDeFutbolistas(ArrayList<Futbolista> listadoDeFutbolistas) 
	{	this.listadoDeFutbolistas = listadoDeFutbolistas;	}    	
}
