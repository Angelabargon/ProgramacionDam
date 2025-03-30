package ejercicioColecciones3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public List<Libro> listarLibrosDisponibles() {
        return libros.stream()
                .filter(libro -> libro.getUsuarioPrestamo().isEmpty())
                .collect(Collectors.toList());
    }

    public void mostrarLibrosMasAntiguos(int cantidad) {
        System.out.println("<- Los " + cantidad + " libros más antiguos ->");
        libros.stream()
                .sorted(Comparator.comparing(Libro::getFechaPublicacion))
                .limit(cantidad)
                .forEach(System.out::println);
        System.out.println(".                                .");
    }

    public long contarLibrosPrestados() {
        return libros.stream()
                .filter(libro -> libro.getUsuarioPrestamo().isPresent())
                .count();
    }

    public List<Libro> filtrarLibrosPorAutor(String autor) {
        return libros.stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", LocalDate.of(1943, 4, 6));
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", LocalDate.of(1967, 5, 30));
        Libro libro3 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", LocalDate.of(1605, 1, 16));
        Libro libro4 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", LocalDate.of(1997, 6, 26));
        Libro libro5 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", LocalDate.of(1985, 1, 1));

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);

        System.out.println("Libros disponibles:");
        biblioteca.listarLibrosDisponibles().forEach(System.out::println);
        System.out.println("\n");

        biblioteca.mostrarLibrosMasAntiguos(3);
        System.out.println("\n");

        try {
            libro1.prestar("Sofía");
            libro4.prestar("Mateo");
            libro2.prestar("Sofía");
            libro1.devolver("Sofía");
            libro2.devolver("Pedro"); // Esto lanzará una excepción
        } catch (LibroNoDisponibleException | LibroNoPrestadoException | PrestamoNoValidoException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("Cantidad de libros prestados: " + biblioteca.contarLibrosPrestados());
        System.out.println("\n");

        System.out.println("Libros de Gabriel García Márquez:");
        biblioteca.filtrarLibrosPorAutor("Gabriel García Márquez").forEach(System.out::println);
    }
}