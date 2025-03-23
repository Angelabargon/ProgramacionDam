package club_de_futbol;

public class ClubDeFutbol 
{
	private String nombre, ciudad;
	public ClubDeFutbol(String nombre1, String ciudad1)
	{
		this.ciudad = ciudad1;
		this.nombre = nombre1;
	}
	public String getNombre() 
	{	return nombre;	}
	public void setNombre(String nombre) 
	{	this.nombre = nombre;	}
	public String getCiudad() 
	{	return ciudad;	}
	public void setCiudad(String ciudad) 
	{	this.ciudad = ciudad;	}
	public String toStringClub() 
	{
		return "Nombre del club: " + nombre + "\nUbicación:" + ciudad;
	}
	
}
