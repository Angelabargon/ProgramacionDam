package club_de_futbol;
import java.util.ArrayList;
import java.util.Scanner;

public class Personal extends Persona
{
	static 	Scanner sc = new Scanner(System.in);
	private String trabajo;
	private float salario;
	public Personal(String nombre1, String apellidos1, String DNI1, String trabajo1, float salario1)
	{
		super(nombre1,apellidos1,DNI1);
		this.trabajo = trabajo1;
		this.salario = salario1;
	}
	public String getTrabajo() 
	{	return trabajo;	}
	public void setTrabajo(String trabajo) 
	{	this.trabajo = trabajo;	}
	public float getSalario() 
	{	return salario;	}
	public void setSalario(float salario) 
	{	this.salario = salario;	}
	public String trabajar()
	{	
		System.out.println("Ingrese el cargo del personal:");
		String trabajo = sc.nextLine();
		return "Cargo: " + trabajo;	
	}
	public String toStringPersonal()
	{
		return "Nombre: " + nombre + "\nApellidos: " + apellidos + "\nDNI: " + DNI + "\nCargo:"
				+ trabajo + "\nSalario: " + salario;
	}
}
