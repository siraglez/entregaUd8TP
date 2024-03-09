package ejercicio3;

import java.util.Random;

public class CuadriculaIA {
    private char[][] tablero; //Matriz para representar el tablero de juego
    private int[][] simulacionAmbiental; //Matriz para simular condiciones marinas
    private Random random;

    public CuadriculaIA(int filas, int columnas) {
        tablero = new char[filas][columnas];
        simulacionAmbiental = new int[filas][columnas];
        random = new Random();

        //Inicializar el tablero y la simulación ambiental
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ' ';
                simulacionAmbiental[i][j] = random.nextInt(2); //Valores aleatorios para simular condiciones marinas
            }
        }
    }

    public void mostrarTablero() {
        // Mostrar el estado actual del tablero con índices de fila y columna
        System.out.print("   ");
        for (int i = 0; i < tablero[0].length; i++) {
            System.out.print((i) + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i) + " |");
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void depositarBarco(int fila, int columna, int longitud, boolean esHorizontal) {
        // Colocar un barco en la posición dada en el tablero
        // En este ejemplo se deposita el barco horizontalmente
        for (int i = 0; i < longitud; i++) {
            if (esHorizontal && columna + i < tablero[0].length) {
                tablero[fila][columna + i] = 'B';
            } else if (!esHorizontal && fila + i < tablero.length) {
                tablero[fila + i][columna] = 'B';
            } else {
                // El barco no cabe completamente en la fila/columna actual
                System.out.println("No se puede posicionar el barco completamente en la fila/columna actual.");
                break;
            }
        }
    }

    public void posicionarBarcoIA(int longitud) {
        for (int intento = 0; intento < 100; intento++) {
            int fila = random.nextInt(tablero.length - longitud + 1);
            int columna = random.nextInt(tablero[0].length - longitud + 1);
            boolean esHorizontal = random.nextBoolean();

            // Validar que la posición sea válida y que no haya un barco previamente
            if (esPosicionValidaParaBarco(fila, columna, longitud, esHorizontal)) {
                depositarBarco(fila, columna, longitud, esHorizontal);
                return;
            }
        }
        System.out.println("No se pudo posicionar el barco después de 100 intentos.");
    }

    public void disparar(int fila, int columna) {
        // Simular el disparo en la posición dada y actualizar el tablero
        if (esPosicionValida(fila, columna)) {
            if (tablero[fila][columna] == 'B') {
                System.out.println("¡Impacto! Has disparado un barco.");
                tablero[fila][columna] = 'X'; // Marcar el impacto en el tablero
            } else {
                System.out.println("Agua. No se ha alcanzado ningún barco.");
                tablero[fila][columna] = 'O'; // Marcar el agua en el tablero
            }
        } else {
            System.out.println("Posición fuera de los límites del tablero.");
        }
    }

    public void ataqueIA() {
        for (int intento = 0; intento < 100; intento++) {
            int fila = random.nextInt(tablero.length);
            int columna = random.nextInt(tablero[0].length);

            // Validar que la posición no haya sido atacada previamente
            if (tablero[fila][columna] != 'X' && tablero[fila][columna] != 'O') {
                mostrarTablero(); //Mostrar tablero antes del ataque
                disparar(fila, columna);

                //Mostrar el tablero depués del ataque
                System.out.println("La IA ataca en fila " + (fila) + " columna " + (columna) + ".");
                mostrarTablero();

                return;
            }
        }
        System.out.println("La IA no encontró una posición para atacar después de 100 intentos.");
    }

    public void visualizacion() {
        //Mostrar el estado actual del tablero
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.println(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length;
    }

    private boolean esPosicionValidaParaBarco(int fila, int columna, int longitud, boolean esHorizontal) {
        if (esHorizontal) {
            return columna + longitud <= tablero[0].length && esPosicionValida(fila, columna);
        } else {
            return fila + longitud <= tablero.length && esPosicionValida(fila, columna);
        }
    }
}
