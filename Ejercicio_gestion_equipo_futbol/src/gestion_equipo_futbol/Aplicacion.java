package gestion_equipo_futbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aplicacion {

    public static void main(String[] args) 
    {
    	
        Equipo equipo = new Equipo("FBC", new ArrayList<>());
        Futbolista fut1 = new Futbolista("Yamal", 17, Posicion.DELANTERO); //-
        Futbolista fut2 = new Futbolista("Kuvarsí", 18, Posicion.DEFENSA); //-
        Futbolista fut3 = new Futbolista("Carlos", 28, Posicion.DEFENSA); //-
        Futbolista fut4 = new Futbolista("Ter Steegen", 33, Posicion.PORTERO); //-
        Futbolista fut5 = new Futbolista("Sergio", 24, Posicion.DEFENSA); //-
        Futbolista fut6 = new Futbolista("Andrés", 27, Posicion.CENTROCAMPISTA); //-
        Futbolista fut7 = new Futbolista("Borja", 23, Posicion.CENTROCAMPISTA); //-
        Futbolista fut8 = new Futbolista("Álvaro", 29, Posicion.DELANTERO); //-
        Futbolista fut9 = new Futbolista("Raúl", 21, Posicion.DELANTERO); //-
        Futbolista fut10 = new Futbolista("Matrínez", 33, Posicion.PORTERO); //-
        Futbolista fut11 = new Futbolista("Luis", 27, Posicion.DEFENSA); //-
        Futbolista fut12 = new Futbolista("Diego", 25, Posicion.DEFENSA); //-
        Futbolista fut13 = new Futbolista("Isco", 31, Posicion.CENTROCAMPISTA); //-
        Futbolista fut14 = new Futbolista("Modric", 35, Posicion.CENTROCAMPISTA); //-
        Futbolista fut15 = new Futbolista("Kroos", 34, Posicion.CENTROCAMPISTA); //-
        Futbolista fut16 = new Futbolista("Pedro", 30, Posicion.PORTERO); //-
        Futbolista fut17 = new Futbolista("Pedri", 22, Posicion.CENTROCAMPISTA); //-
        Futbolista fut18 = new Futbolista("Raphinha", 27, Posicion.DELANTERO); //-
        Futbolista fut19 = new Futbolista("Baldé", 21, Posicion.DEFENSA); //-
        Futbolista fut20 = new Futbolista("Vinicius", 25, Posicion.DELANTERO); //-
        try 
        {
            equipo.agregarFutbolista(fut10);
            equipo.agregarFutbolista(fut2);
            equipo.agregarFutbolista(fut3);
            equipo.agregarFutbolista(fut5);
            equipo.agregarFutbolista(fut11);
            equipo.agregarFutbolista(fut19);
            equipo.agregarFutbolista(fut6);
            equipo.agregarFutbolista(fut7);
            equipo.agregarFutbolista(fut4);
            equipo.agregarFutbolista(fut17);
            equipo.agregarFutbolista(fut15);
            equipo.agregarFutbolista(fut14);
            equipo.agregarFutbolista(fut8);
            equipo.agregarFutbolista(fut9);
            equipo.agregarFutbolista(fut1);
            equipo.agregarFutbolista(fut18);
        } 
        catch (Equipo.RegistroFutbolistaException e) 
        {    System.err.println("Error al agregar futbolista: " + e.getMessage());    }
        System.out.println("\n    Formación del equipo ordenados por posición    \n");
        List<Futbolista> formacionOrdenada = new ArrayList<>(equipo.getListadoDeFutbolistas());
        formacionOrdenada.sort((f1, f2) -> {   return f1.getPosicion().compareTo(f2.getPosicion());	});
        Iterator<Futbolista> iterator = formacionOrdenada.iterator();
        while (iterator.hasNext()) 
        {    System.out.println(iterator.next());   }
        try 
        {	equipo.agregarFutbolista(fut20);  } 
        catch (Equipo.RegistroFutbolistaException e) 
        {    System.err.println("Error al agregar futbolista: " + e.getMessage());    }
        try 
        {	equipo.agregarFutbolista(fut16);  } 
        catch (Equipo.RegistroFutbolistaException e) 
        {    System.err.println("Error al agregar futbolista: " + e.getMessage());    }
        try 
        {	equipo.agregarFutbolista(fut12);  } 
        catch (Equipo.RegistroFutbolistaException e) 
        {    System.err.println("Error al agregar futbolista: " + e.getMessage());    }
        try 
        {	equipo.agregarFutbolista(fut13);  } 
        catch (Equipo.RegistroFutbolistaException e) 
        {    System.err.println("Error al agregar futbolista: " + e.getMessage());    }
    }
}