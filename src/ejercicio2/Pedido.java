package ejercicio2;

import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private ClienteECommerce cliente;
    private List<Obra> obrasCompradas;

    public Pedido(ClienteECommerce cliente) {
        this.cliente = cliente;
        this.obrasCompradas = new ArrayList<>();
    }

    public void agregarObra(Obra obra) {
        obrasCompradas.add(obra);
        cliente.agregarCompra(obra); //Actualizar historial y recomendaciones del cliente
    }
}
