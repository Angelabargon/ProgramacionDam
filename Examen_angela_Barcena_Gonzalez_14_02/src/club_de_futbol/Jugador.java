package club_de_futbol;
import java.util.ArrayList;
import java.util.Scanner;
public class Jugador extends Persona
{
	static 	Scanner sc = new Scanner(System.in);
	private int numero;
	private String posicion;
	private boolean siNo;
	public Jugador (String nombre1, String apellidos1, String DNI1, int numero1, String posicion1)
	{
		super(nombre1,apellidos1,DNI1);
		this.numero = numero1;
		this.posicion = posicion1;
	}
	public int getNumero() 
	{	return numero;	}
	public void setNumero(int numero) 
	{	this.numero = numero;	}
	public String getPosicion() 
	{	return posicion;	}
	public void setPosicion(String posicion) 
	{	this.posicion = posicion;	}
	public String entrenando()
	{
		System.out.println("¿Está entrenando actualmente?");
		siNo = sc.nextBoolean();
		if (siNo == true)
			return "Si";
		else
			return "No";
	}
	public String toString(Jugador j) 
	{
		String YesNo;
		if (siNo == true)
			YesNo = "Si";
		else
			YesNo = "No";
		return "Nombre: " + nombre + "\nApellidos: " + apellidos + "\nDNI: " + DNI + "\nNumero:"
				+ numero + "\nPosicion: " + posicion + "\n¿Entrenando?: " + YesNo;
		
	}
}
