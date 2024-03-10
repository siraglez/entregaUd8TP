package ejercicio1;

import java.util.Random;


public class JugadorGuerraAR {
    private int fichas;
    private int dadoVirtual;
    private String nombre;

    //Constructor
    public JugadorGuerraAR(String nombre) {
        this.nombre = nombre;
        this.fichas = 10; //Se inicializa con 10 fichas
    }

    //Método para lanzar el dado virtual y obtener el resultado
    public void lanzarDadoVirtual() {
        Random random = new Random();
        this.dadoVirtual = random.nextInt(6) + 1; //Números del 1 al 6 para el dado
    }

    //Método para simular la batalla y actualizar las fichas
    public void simularBatalla(JugadorGuerraAR oponente) {
        this.lanzarDadoVirtual();
        oponente.lanzarDadoVirtual();

        System.out.println((this.nombre + " lanzó un " + this.dadoVirtual));
        System.out.println(oponente.nombre + " lanzó un " + oponente.dadoVirtual);

        if (this.dadoVirtual > oponente.dadoVirtual) {
            System.out.println(this.nombre + " gana la batalla.");
            oponente.fichas--;
        } else if (this.dadoVirtual < oponente.dadoVirtual) {
            System.out.println(oponente.nombre + " gana la batalla.");
            this.fichas--;
        } else {
            System.out.println("Empate. Ningún jugador pierde fichas.");
        }
    }

    //Método para animación de lanzamiento de dado en 3D
    public void animacionLanzamientoDado() {
        System.out.println("Realizando animación de lanzamiento de dado en 3D");
        //Código para animación en 3D
    }

    //Método para efecto visual de victoria en realidad aumentada
    public void efectoVictoriaAR() {
        System.out.println("¡" + this.nombre + " ha ganado la batalla en realidad aumentada!");
        //Código para efectos visuales en realidad aumentada
    }

    //Método para efecto visual de derrota en realidad aumentada
    public void efectoDerrotaAR() {
        System.out.println("¡" + this.nombre + " ha perdido la batalla en realidad aumentada!");
        //Código para efectos visuales en realidad aumentada
    }

    //Método para efecto visual de empate en realidad aumentada
    public void efectoEmpateAR() {
        System.out.println("La batalla ha terminado en empate en realidad aumentada.");
        //Código para efectos visuales en realidad aumentada
    }

    //Método para mostrar el estado actual de las fichas en realidad aumentada
    public void mostrarEstadoFichasAR() {
        System.out.println("Estado actual de las fichas de " + this.nombre + " en realidad aumentada: " + this.fichas);
        //Código para efectos visuales en realidad aumentada
    }

    //Método para obtener el número actual de fichas del jugador
    public int obtenerFichas() {
        return this.fichas;
    }
}
