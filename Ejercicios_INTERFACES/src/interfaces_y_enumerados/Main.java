package interfaces_y_enumerados;

import java.util.Arrays;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué tipo de contenido quiere reproducir o pausar? (en mayúsculas)" + Arrays.toString(TipoContenido.values()));
		String tipoC = sc.nextLine();
		TipoContenido contenido = TipoContenido.valueOf(tipoC);
		System.out.println("¿Quiere pausarlo o reproducirlo (pause/play)?");
		String pausePlay = sc.nextLine();
		switch (contenido) 
		{
		    case MUSICA:
		    	Musica m = new Musica();
		        if (pausePlay.equals("pause"))
		            System.out.println(m.pausar());                      
		        else if (pausePlay.equals("play"))							  
		            System.out.println(m.reproducir());				  
		        else
		            System.out.println("Error, intentelo de nuevo");
		        break;
		    case PELICULA:
		    	Pelicula p = new Pelicula();
		        if (pausePlay.equals("pause"))
		            System.out.println(p.pausar());
		        else if (pausePlay.equals("play"))
		            System.out.println(p.reproducir());
		        else
		            System.out.println("Error, intentelo de nuevo");
		        break;
		    case SERIE:
		    	Serie s = new Serie();
		    	if (pausePlay.equals("pause"))
		            System.out.println(s.pausar());
		        else if (pausePlay.equals("play"))
		            System.out.println(s.reproducir());
		        else
		            System.out.println("Error, intentelo de nuevo");
		        break;
		    case PODCAST:
		    	Podcast pc = new Podcast();
		    	if (pausePlay.equals("pause"))
		            System.out.println(pc.pausar());
		        else if (pausePlay.equals("play"))
		            System.out.println(pc.reproducir());
		        else
		            System.out.println("Error, intentelo de nuevo");
		        break;
		    default:
		    	System.out.println("No existe ese tipo de contenido");
		}
	}
}
