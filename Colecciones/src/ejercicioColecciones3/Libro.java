package ejercicioColecciones3;

import java.time.LocalDate; 

class Libro implements Prestable
{
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
    private String usuarioPrestamo; 
    public Libro(String titulo, String autor, LocalDate fechaPublicacion) 
    {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.usuarioPrestamo = null;
    }
    public String getTitulo() 
    {    return titulo;    }
    public String getAutor() 
    {    return autor;    }
    public LocalDate getFechaPublicacion() 
    {    return fechaPublicacion;    }
    public String getUsuarioPrestamo() 
    {    return usuarioPrestamo;    }
    public boolean Prestar(String usuario) throws LibroNoDisponible
    {
        if (usuarioPrestamo == null) 
        {
            usuarioPrestamo = usuario;
            return true;
        } else 
        {    throw new LibroNoDisponible("El libro '" + titulo + "' ya está prestado a " + usuarioPrestamo + ".");    }
    }
    @Override
    public boolean Devolver(String usuario) throws LibroNoPrestado, PrestamoNoValido 
    {
        if (usuarioPrestamo != null) 
        {
            if (usuarioPrestamo.equals(usuario)) 
            {
                usuarioPrestamo = null;
                return true;
            } else 
            {    throw new PrestamoNoValido("El libro '" + titulo + "' fue prestado a " + usuarioPrestamo + ", no a " + usuario + ".");    }
        } 
        else 
        {    throw new LibroNoPrestado("El libro '" + titulo + "' no está actualmente prestado.");    }
    }
    @Override
    public String toString() 
    {
        return "Libro\n[" +
               "titulo ='" + titulo + "/" +
               ", autor ='" + autor + "/" +
               ", fecha de publicacion =" + fechaPublicacion + "/" +
               ", prestado a =" + (usuarioPrestamo != null ? usuarioPrestamo : "nadie") +
               "]";
    }
}
