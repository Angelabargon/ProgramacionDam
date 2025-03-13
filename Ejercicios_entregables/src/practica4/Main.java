package practica4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Participante> pCarrera = new ArrayList<Participante>();
        ArrayList<Equipo> e = new ArrayList<Equipo>();
        ArrayList<Participante> pEquipo = new ArrayList<Participante>();
        System.out.println("¿Qué tipo de evento desea crear? (1: Carrera, 2: Torneo de Fútbol)");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del evento:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el lugar del evento:");
        String lugar = scanner.nextLine();
        System.out.print("Ingrese la fecha del evento (dia-mes-año):");
        String fechaTexto = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaTexto, formatter);
        if (opcion == 1) 
        {
            System.out.println("Ingrese la distancia de la carrera en km:");
            double distancia = scanner.nextDouble();
            scanner.nextLine();
            Carrera carrera = new Carrera(nombre, lugar,  fecha, pCarrera, distancia);
            System.out.println("¿Cuántos participantes desea inscribir?");
            int numParticipantes = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numParticipantes; i++) 
            {
                System.out.println("Ingrese nombre, apellido y edad del participante:");
                String nombreP = scanner.next();
                String apellidoP = scanner.next();
                int edadP = scanner.nextInt();
                System.out.println("Ingrese el tiempo registrado en segundos:");
                double tiempo = scanner.nextDouble();
                Participante participante = new Participante(nombreP, apellidoP, edadP, tiempo);
                carrera.inscribirParticipante(participante);
            }
            System.out.println("Ganador de la carrera: " + carrera.obtenerGanador());
        } 
        else if (opcion == 2) 
        {
            TorneoDeFutbol torneo = new TorneoDeFutbol(nombre, lugar, fecha, pEquipo, e);
            System.out.println("Ingrese el número de equipos:");
            int numEquipos = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numEquipos; i++) 
            {
                System.out.println("Ingrese el nombre del equipo:");
                String nombreEquipo = scanner.nextLine();
                System.out.println("Ingrese los puntos del equipo:");
                int puntos = scanner.nextInt();
                scanner.nextLine();
                Equipo equipo = new Equipo(nombreEquipo, pEquipo, puntos);
                e.add(equipo);
            }
            System.out.println("Ganador del torneo: " + torneo.obtenerGanador().getNombre());
        }
        scanner.close();
    }
}