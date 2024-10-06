public class Principal {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("---"+biblioteca.getNombre()+"---");
        System.out.println("");

        biblioteca.agregarLibro("1234", "IT", "Stephen King", "Terror", 4,true);
        biblioteca.agregarLibro("2134", "El Resplandor", "Stephen King", "Terror", 10, true);
        biblioteca.agregarLibro("6789", "La Naranja Mecanica", "Anthony Burgess", "Distopia", 3, true);

        biblioteca.mostrarLibrosDisponibles();
        System.out.println("");

        biblioteca.prestarLibro("IT");
        biblioteca.mostrarLibrosDisponibles();
        System.out.println("");

        biblioteca.devolverLibro("El Resplandor");
        biblioteca.mostrarLibrosDisponibles();
        System.out.println("");

        biblioteca.buscarLibroPorTitulo("El Resplandor");
        System.out.println("");

        biblioteca.buscarLibrosPorAutor("Stephen King");
        System.out.println("");

        biblioteca.eliminarLibro("El Resplandor");
        biblioteca.mostrarLibrosDisponibles();


    }
}
