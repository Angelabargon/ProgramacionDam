package ejercicioConIteradores;
import java.util.ArrayList;
import java.util.Iterator;
public class RedSocial 
{
	ArrayList<Usuario> amigos;
    public RedSocial() 
    {    
    	amigos = new ArrayList<>();    
    }
    public void agregarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }
    public void mostrarAmigos() 
    {
    	int count = 0;
        if (amigos.isEmpty()) 
        {    
        	System.out.println("No hay personas en tu lista.");    
        } 
        else 
        {
            System.out.println("Lista de amigos:");
            for (Usuario amigo : amigos) 
            {
            	count++;
                System.out.println(count + "- " + amigo);
            }
        }
    }
    public void eliminarAmigosMenores(int edadMinima) 
    {
    	Iterator<Usuario> iterador = amigos.iterator();
    	while (iterador.hasNext()) 
    	{
    		Usuario amigo = iterador.next();
        	if (amigo.getEdad() < edadMinima) 
        	{
        		iterador.remove(); 
        	}
    	}
    }
    public void buscarAmigo(String nombre) 
    {
        for (Usuario amigo : amigos) 
        {
            if (amigo.getNombre().equalsIgnoreCase(nombre)) 
            {
                System.out.println("Información de la persona:");
                System.out.println(amigo);
                return;
            }
        }
        System.out.println("No se encontró ninguna persona con ese nombre.");
    }
}
