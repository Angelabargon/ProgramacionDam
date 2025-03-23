package club_de_futbol;

public class Persona 
{
	protected String nombre, apellidos, DNI;
	public Persona (String nombre1, String apellidos1, String DNI1)
	{
		super();
		this.apellidos = apellidos1;
		this.nombre = nombre1;
		this.DNI = DNI1;
	}
	public String getNombre() 
	{	return nombre;	}
	public void setNombre(String nombre) 
	{	this.nombre = nombre;	}
	public String getApellidos() 
	{	return apellidos;	}
	public void setApellidos(String apellidos) 
	{	this.apellidos = apellidos;	}
	public String getDNI() 
	{	return DNI;	}
	public void setDNI(String dNI) 
	{	DNI = dNI;	}
	public String obtenerRol(Jugador jugador, Personal personal)
	{
		if( jugador == null)
			return "Es parte del personal";
		else if( personal == null )
			return "Es un jugador";
		else 
			return "ERROR. Debe introducir o a un jugador o a un personal";
	}
}
