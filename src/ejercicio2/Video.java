package ejercicio2;

public class Video extends Obra {
    private String director;

    public Video(String titulo, double precio, String director) {
        super(titulo, precio);
        this.director = director;
    }

    @Override
    public String toString() {
        return "Video [título=" + titulo + ", precio=" + precio + ", director=" + director + "]";
    }
}
