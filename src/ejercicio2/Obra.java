package ejercicio2;

public class Obra {
    protected String titulo;
    protected double precio;

    public Obra(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Obra [título=" + titulo + ", precio=" + precio + "]";
    }
}
