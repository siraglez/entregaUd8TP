package ejercicio2;

public class Libro extends Obra {
    private String autor;

    public Libro(String titulo, double precio, String autor) {
        super(titulo, precio);
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro [título=" + titulo + ", precio=" + precio + ", autor=" + autor + "]";
    }
}
