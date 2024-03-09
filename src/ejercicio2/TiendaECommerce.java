package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TiendaECommerce {
    private List<ClienteECommerce> clientes;
    private List<Obra> obras;
    private List<Pedido> pedidos;
    private static final AtomicInteger contadorClientes = new AtomicInteger(0);

    public TiendaECommerce() {
        this.clientes = new ArrayList<>();
        this.obras = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        //Agregar obras y clientes predeterminados
        inicializarDatos();
    }

    private void inicializarDatos() {
        clientes.add(new ClienteECommerce("Cliente1", 1));
        clientes.add(new ClienteECommerce("Cliente2", 2));

        obras.add(new Libro("Libro1", 20.0, "Autor1"));
        obras.add(new Video("Video1", 16.0, "Director1"));
    }

    public void agregarCliente(ClienteECommerce cliente) {
        clientes.add(cliente);
    }

    public void mostrarClientes() {
        for (ClienteECommerce cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public ClienteECommerce buscarCliente(int numeroCliente) {
        for (ClienteECommerce cliente : clientes) {
            if (cliente.getNumeroCliente() == numeroCliente) {
                return cliente;
            }
        }
        return null;
    }

    public int generarNumeroCliente() {
        //Utiliza un contador atómico para asegurar que cada cliente tenga un número único
        return contadorClientes.incrementAndGet();
    }

    public void agregarObra(Obra obra) {
        obras.add(obra);
    }

    public void mostrarObras() {
        for (Obra obra : obras) {
            System.out.println(obra);
        }
    }

    public Obra buscarObra(String titulo) {
        for (Obra obra : obras) {
            if (obra.getTitulo().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null;
    }

    public void realizarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
