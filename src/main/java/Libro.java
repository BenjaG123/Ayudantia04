public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int cantidadDisponible;
    private boolean disponible;


    public Libro(String isbn, String titulo, String autor, String editorial, int cantidadDisponible, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = editorial;
        this.cantidadDisponible = cantidadDisponible;
        this.disponible = cantidadDisponible > 0;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void prestar(){
        if (cantidadDisponible > 0){
            cantidadDisponible--;
            setCantidadDisponible(cantidadDisponible);
            System.out.println("Libro prestado.");
        } else {
            System.out.println("No está disponible");
        }
    }

    public void devolver(){
        if (cantidadDisponible == 0){
            cantidadDisponible++;
            setCantidadDisponible(cantidadDisponible);
            setDisponible(true);
        } else {
            cantidadDisponible++;
            setCantidadDisponible(cantidadDisponible);
        }
        System.out.println("Libro devuelto.");
    }

    @Override
    public String toString() {
        return "ISBN: "+this.isbn+", Titulo: "+this.titulo+", Autor: "+this.autor+", Genero: "+this.genero+", Cantidad Disponible: "+this.cantidadDisponible+", Disponible: "+this.disponible;
    }

}
