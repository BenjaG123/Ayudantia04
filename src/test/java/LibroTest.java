import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    @Test
    public void testCrearLibro() {
        Libro libro = new Libro("1234", "1984", "George Orwell", "Distopia", 3, true);
        assertEquals("1234", libro.getIsbn());
        assertEquals("1984", libro.getTitulo());
        assertEquals("George Orwell", libro.getAutor());
        assertEquals("Distopia", libro.getGenero());
        assertEquals(3, libro.getCantidadDisponible());
        assertTrue(libro.getDisponible());
    }

    @Test
    public void testPrestarLibro() {
        Libro libro = new Libro("1234", "1984", "George Orwell", "Distopia", 3, true);
        libro.prestar();
        assertEquals(2, libro.getCantidadDisponible());
        assertTrue(libro.getDisponible());
    }

    @Test
    public void testPrestarLibroSinDisponibilidad() {
        Libro libro = new Libro("1234", "1984", "George Orwell", "Distopia", 0, false);
        libro.prestar();
        assertEquals(0, libro.getCantidadDisponible());
        assertFalse(libro.getDisponible());
    }

    @Test
    public void testDevolverLibro() {
        Libro libro = new Libro("1234", "1984", "George Orwell", "Distopia", 1, true);
        libro.prestar();
        libro.devolver();
        assertEquals(1, libro.getCantidadDisponible());
        assertTrue(libro.getDisponible());
    }

    @Test
    public void testDevolverLibroYaDisponible() {
        Libro libro = new Libro("1234", "1984", "George Orwell", "Distopia", 3, true);
        libro.devolver();
        assertEquals(4, libro.getCantidadDisponible());
    }
}
