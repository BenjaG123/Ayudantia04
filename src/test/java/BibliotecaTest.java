import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void testAgregarLibroNuevo() {
        boolean result = biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 3, true);
        assertTrue(result);
        assertEquals(1, biblioteca.buscarLibrosPorAutor("George Orwell").size());
    }

    @Test
    public void testAgregarLibroExistente() {
        biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 3, true);
        boolean result = biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 2, true);
        assertTrue(result);
        assertEquals(5, biblioteca.buscarLibroPorTitulo("1984").getCantidadDisponible());
    }

    @Test
    public void testBuscarLibroPorTitulo() {
        biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 3, true);
        Libro libro = biblioteca.buscarLibroPorTitulo("1984");
        assertNotNull(libro);
        assertEquals("1984", libro.getTitulo());
    }

    @Test
    public void testBuscarLibrosPorAutor() {
        biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 3, true);
        biblioteca.agregarLibro("9876", "Vuelo Nocturno", "George Orwell", "Distopia", 2, true);
        List<Libro> libros = biblioteca.buscarLibrosPorAutor("George Orwell");
        assertEquals(2, libros.size());
    }

    @Test
    public void testPrestarLibro() {
        biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 3, true);
        boolean result = biblioteca.prestarLibro("1984");
        assertTrue(result);
        assertEquals(2, biblioteca.buscarLibroPorTitulo("1984").getCantidadDisponible());
    }

    @Test
    public void testDevolverLibro() {
        biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 3, true);
        biblioteca.prestarLibro("1984");
        boolean result = biblioteca.devolverLibro("1984");
        assertTrue(result);
        assertEquals(3, biblioteca.buscarLibroPorTitulo("1984").getCantidadDisponible());
    }

    @Test
    public void testEliminarLibro() {
        biblioteca.agregarLibro("12345", "1984", "George Orwell", "Distopia", 3, true);
        biblioteca.eliminarLibro("1984");
        assertNull(biblioteca.buscarLibroPorTitulo("1984"));
    }
}
