package ejercicio1;

public class Main {
    public static void main(String[] args) {
        JugadorGuerraAR jugador1 = new JugadorGuerraAR("Jimena");
        JugadorGuerraAR jugador2 = new JugadorGuerraAR("Lucía");

        //Lógica de juego con efectos de realidad aumentada y simulación de dados
        for (int i = 0; i < 5; i++) {
            System.out.println("--Ronda " + (i + 1) + " --");

            //Animación de lanzamiento de dado en 3D
            jugador1.animacionLanzamientoDado();
            jugador2.animacionLanzamientoDado();

            jugador1.simularBatalla(jugador2);

            //Efectos visuales en realidad aumentada según el resultado de la batalla
            if (jugador1.obtenerFichas() > 0) {
                jugador1.efectoVictoriaAR();
                jugador2.efectoDerrotaAR();
            } else if (jugador2.obtenerFichas() > 0) {
                jugador2.efectoVictoriaAR();
                jugador1.efectoDerrotaAR();
            } else {
                jugador1.efectoEmpateAR();
                jugador2.efectoEmpateAR();
            }

            //Mostrar estado de fichas en realidad aumentada
            jugador1.mostrarEstadoFichasAR();
            jugador2.mostrarEstadoFichasAR();

            System.out.println();
        }
    }
}
