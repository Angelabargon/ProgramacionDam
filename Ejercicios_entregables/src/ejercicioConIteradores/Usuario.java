package ejercicioConIteradores;
import java.util.ArrayList;
public class Usuario 
{
    String nombre;
    int edad;
    public Usuario(String nombre, int edad) 
    {   
    	this.nombre = nombre;
        this.edad = edad;    
    }
    public String getNombre() {    return nombre;    }
    public int getEdad() {    return edad;    }
    @Override
    public String toString() {    return "Nombre: " + nombre + "\nEdad: " + edad;    }
}

