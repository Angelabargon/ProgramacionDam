package ejercicioConIteradores;

import java.util.Scanner;

public class Main 
{
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) 
	{
		RedSocial nuevaRedSocial = new RedSocial();
		System.out.println("Introduce el número de personas en tu lista de amigos (min 6): ");
		int num = sc.nextInt();
		if (num < 6) 
		{
	        System.out.println("Debes ingresar al menos 6 amigos.");
	        return;
	    }
		sc.nextLine();
		for (int i = 0; i < num; i++) 
		{
	        System.out.println("Introduce el nombre del amigo " + (i + 1) + ":");
	        String nombre = sc.nextLine();
            System.out.println("Introduce la edad del amigo " + (i + 1) + ":");
            int edad = sc.nextInt();
            sc.nextLine(); 
            Usuario nuevoAmigo = new Usuario(nombre, edad);
            nuevaRedSocial.agregarAmigo(nuevoAmigo);
        }
		System.out.println("\nLista de amigos agregados:");
		nuevaRedSocial.mostrarAmigos();
		System.out.println("\nIntroduce la edad mínima para eliminar amigos:");
        int edadMin = sc.nextInt();
        nuevaRedSocial.eliminarAmigosMenores(edadMin);
        System.out.println("\nLista de amigos después de eliminar menores de " + edadMin + " años:");
		nuevaRedSocial.mostrarAmigos();
		System.out.println("\nIntroduce el nombre del amigo que quieres buscar:");
        String nombre = sc.nextLine();
        nuevaRedSocial.buscarAmigo(nombre);
	}
}
