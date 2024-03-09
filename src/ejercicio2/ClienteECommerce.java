package ejercicio2;

import java.util.*;
import java.util.stream.Collectors;

public class ClienteECommerce {
    private String nombre;
    private int numeroCliente;
    private List<Obra> historialCompras;
    private Map<String, List<Obra>> recomendaciones;

    public ClienteECommerce(String nombre, int numeroCliente) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.historialCompras = new ArrayList<>();
        this.recomendaciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public List<Obra> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<Obra> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public Map<String, List<Obra>> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(Map<String, List<Obra>> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public void agregarCompra(Obra obra) {
        historialCompras.add(obra);
        actualizarRecomendaciones();
    }

    public void mostrarHistorialCompras() {
        System.out.println("Historial de compras de " + nombre + ":");
        if (historialCompras.isEmpty()) {
            System.out.println("El cliente no ha realizado compras.");
        } else {
            for (Obra obra : historialCompras) {
                System.out.println("- " + obra.getTitulo() + " | Precio: $" + obra.getPrecio());
            }
        }
    }

    public void generarRecomendaciones() {
        //Lógica para generar recomendaciones basadas en el historial de compras y preferencias
        System.out.println("Recomendaciones para " + nombre + ":");
        for (String categoria : recomendaciones.keySet()) {
            System.out.println("Categoría: " + categoria);
            List<Obra> obrasRecomendadas = recomendaciones.get(categoria);
            for (Obra obra : obrasRecomendadas) {
                System.out.println("- " + obra.titulo);
            }
        }
    }

    private void actualizarRecomendaciones() {
        //Lógica para actualizar las recomendaciones basadas en el historial de compras y preferencias
        recomendaciones.clear();

        //Agrupar las obras compradas por categoría
        Map<String, List<Obra>> obrasPorCategoria = historialCompras.stream().collect(Collectors.groupingBy(obra -> obtenerCategoria(obra)));

        //Obtener las cateogrías por frecuencia de compra
        List<String> categoriasOrdenadas = obrasPorCategoria.keySet().stream().sorted(Comparator.comparingInt(categoria -> -obrasPorCategoria.get(categoria).size()))
                .collect(Collectors.toList());

        //Generar recomendaciones basadas en las categorías más compradas
        for (String categoria : categoriasOrdenadas) {
            if (!recomendaciones.containsKey(categoria)) {
                List<Obra> obrasRecomendadas = obrasPorCategoria.get(categoria);
                Collections.shuffle(obrasRecomendadas); //Mezclar para variedad en recomendaciones
                recomendaciones.put(categoria, obrasRecomendadas.subList(0, Math.min(3, obrasRecomendadas.size())));
            }
        }
    }

    private String obtenerCategoria(Obra obra) {
        //Lógica para obtener la categoría de la obra
        if (obra instanceof Libro) {
            return "Libros";
        } else if (obra instanceof Video) {
            return "Videos";
        } else {
            return "Otras categorías";
        }
    }
}
