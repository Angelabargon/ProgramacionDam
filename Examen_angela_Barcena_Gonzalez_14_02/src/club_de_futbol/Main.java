package club_de_futbol;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	static ArrayList<Personal> personalTotal = new ArrayList<Personal>();
	static ArrayList<ClubDeFutbol> club1 = new ArrayList<ClubDeFutbol>(1);
	//He creado arrayList para almacenar los jugadores y el personal, aunque el club
	//también, lo he creado con tamaño 1
	static 	Scanner sc = new Scanner(System.in);
	public static void JugadorFut()
	{
		System.out.println("Ingrese el nombre del jugador: ");
		String nombre = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese los apellidos del jugador: ");
		String apellidos = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese el DNI del jugador: ");
		String DNI = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese el numero de camiseta: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese la posición: ");
		String posicion = sc.nextLine();
		sc.nextLine();
		Jugador jugador = new Jugador(nombre, apellidos, DNI, numero, posicion);
		jugador.entrenando();
		jugador.obtenerRol(jugador, null);
		System.out.println("\nJugador creado con éxito.");
		jugadores.add(jugador);
	}
	public static void Personal()
	{
		System.out.println("Ingrese el nombre del personal: ");
		String nombre = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese los apellidos del personal: ");
		String apellidos = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese el DNI del personal: ");
		String DNI = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese el salario del personal: ");
		float salario = sc.nextFloat();
		sc.nextLine();
		Personal personal = new Personal(nombre, apellidos, DNI, null, salario);
		personal.trabajar();
		personal.obtenerRol(null, personal);
		System.out.println("\nPersonal creado con éxito.");
		personalTotal.add(personal);
	}
	public static void ClubFut()
	{
		ClubDeFutbol club = new ClubDeFutbol(null,null);
		System.out.println("Ingrese el nombre del club");
		String nombre = sc.nextLine();
		sc.nextLine();
		System.out.println("Ingrese la ciudad del club");
		String ciudad = sc.nextLine();
		sc.nextLine();
		club.setCiudad(ciudad);
		club.setNombre(nombre);
		System.out.println("\nClub creado con éxito.");
		club1.add(club);
	}
	
	public static void main(String[] args) 
	{
		int opcionMenu = 1;
		do 
		{
		System.out.println("===== MENÚ CLUB DE FÚTBOL =====\n" 
				+ "1. Crear Jugador\n"  
				+ "2. Crear Personal\n" 
				+ "3. Crear Club\n"
				+ "4. Mostrar Información\n"
				+ "5. Salir\n");
		System.out.println("Seleccione una opción");
		opcionMenu = sc.nextInt();
			switch(opcionMenu)
			{
				case 1:
					JugadorFut();
					break;
				case 2:
					Personal();
					break;
				case 3:
					ClubFut();
					break;
				case 4:
					//No recuerdo como imprimir bien un arrayList :,)
					System.out.println("===== INFORMACIÓN DEL CLUB =====");
					System.out.println(club1.toString());
					System.out.println("===== JUGADORES =====");
					System.out.println(jugadores.toString());
					System.out.println("===== Personal =====");
					System.out.println(personalTotal.toString());
					break;
				case 5:
					System.out.println("Saliendo........");
					break;
				default:
					System.out.println("ERROR. No es una opción del menú.");
					break;
			}
		} while(opcionMenu != 5);
	}
}
