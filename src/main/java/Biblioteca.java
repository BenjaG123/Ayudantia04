import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;

    public Biblioteca() {
        this.nombre = "Biblioteca Garcés";
        this.libros = new ArrayList<Libro>();
    }



    public boolean agregarLibro(String isbn, String titulo, String autor, String genero, int cantidadDisponible, boolean disponible) {
        for (Libro libro : this.libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.setCantidadDisponible(libro.getCantidadDisponible() + cantidadDisponible);
                return true;
            }
        }
        Libro libroNuevo = new Libro(isbn, titulo, autor, genero, cantidadDisponible, disponible);
        this.libros.add(libroNuevo);
        return true;
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for(Libro libro : libros){
            if (libro.getTitulo().equals(titulo)) {
                System.out.println("Libro encontrado: ");
                System.out.println(libro.toString());
                return libro;
            }
        }
        return null;
    }

    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                librosEncontrados.add(libro);
            }
        }

        if (!librosEncontrados.isEmpty()) {
            System.out.println("Libros de " + autor + " encontrados: ");
            for (Libro libro : librosEncontrados) {
                System.out.println(libro.toString());
            }
        } else {
            System.out.println("No se encontraron libros de " + autor);
        }

        return librosEncontrados;
    }


    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles: ");
        boolean hayLibrosDisponibles = false;
        for(Libro libro : libros){
            if (libro.getDisponible()) {
                System.out.println(libro.toString());
                hayLibrosDisponibles = true;
            }
        }
        if (!hayLibrosDisponibles) {
            System.out.println("No hay libros disponibles");
        }
    }

    public void eliminarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                this.libros.remove(libro);
                System.out.println("Libro eliminado: " + libro.getTitulo());
                break;
            }
        }
    }
    public boolean prestarLibro(String titulo) {
        for (Libro libro : this.libros) {
            if (libro.getTitulo().equals(titulo) && libro.getDisponible()) {
                libro.prestar();
                if (libro.getCantidadDisponible() == 0) {
                    libro.setDisponible(false);
                }
                return true;
            }
        }
        System.out.println("El libro no está disponible para prestar.");
        return false;
    }

    public boolean devolverLibro(String titulo) {
        for (Libro libro : this.libros) {
            if (libro.getTitulo().equals(titulo)) {
                libro.devolver();
                return true;
            }
        }
        System.out.println("El libro no se encontró para devolver.");
        return false;
    }

    public String getNombre() {
        return nombre;
    }
}


