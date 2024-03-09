package ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class CuadriculaVirtual {
    private char[][] tableroHumano;
    private char[][] tableroIA;
    private int filas;
    private int columnas;
    private Scanner scanner;
    private int turnos;

    public CuadriculaVirtual(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tableroHumano = new char[filas][columnas];
        this.tableroIA = new char[filas][columnas];
        this.scanner = new Scanner(System.in);
        this.turnos = 0;
        inicializarTableros();
    }

    private void inicializarTableros() {
        //Inicializar tableros con agua, marcada por '0'
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroHumano[i][j] = '0';
                tableroIA[i][j] = '0';
            }
        }
    }

    public void jugar() {
        //Lógica del juego con desafío humano vs. máquina
        System.out.println("¡Bienvenido a la Guerra de Barcos!");
        while (!juegoTerminado()) {
            turnoHumano();
            if (!juegoTerminado()) {
                turnoIA();
            }
            turnos++;
            visualizar();
        }
        System.out.println("Juego terminado. Gracias por jugar.");
    }

    private void turnoHumano() {
        System.out.println("Turno del jugador humano: ");
        //Lógica para que el jugador humano realice un movimiento
        //Pedir al usuario la entrada de filas y columnas al jugar
        System.out.println("Ingrese la fila (0 - " + (filas - 1) + "): ");
        int fila = scanner.nextInt();

        System.out.println("Ingrese la columna (0 - " + (columnas - 1) + "): ");
        int columna = scanner.nextInt();

        //Validar la la entrada del jugador y actualizar el tablero correspondiente
        if (esMovimientoValido(fila, columna, tableroIA)) {
            if (esAtaqueExitoso(fila, columna, tableroIA)) {
                System.out.println("¡Ataque exitoso! Has hundido un barco enemigo.");
                tableroIA[fila][columna] = 'X'; //Marcador para un ataque exitoso
            } else {
                System.out.println("Ataque válido pero no has hundido un barco enemigo.");
            }
            tableroIA[fila][columna] = 'A'; //Marcador para hueco atacado con agua
        } else {
            System.out.println("¡Ataque fallido!");
            tableroIA[fila][columna] = 'A'; //Marcador para hueco atacado con agua
        }
    }

    private void turnoIA() {
        System.out.println("Turno de la IA: ");
        Random random = new Random();
        int fila;
        int columna;
        //Lógica para que la IA realice un movimiento
        //Estrategia con movimientos aleatorios
        do {
            fila = random.nextInt(filas);
            columna = random.nextInt(columnas);
        } while (!esMovimientoValido(fila, columna, tableroHumano));

        System.out.println("La IA ataca la posición: (" + fila + ", " + columna + ")");
        //Actualizar el tablero correspondiente
        if (esAtaqueExitoso(fila, columna, tableroHumano)) {
            System.out.println("¡Ataque exitoso para la IA!");
            tableroHumano[fila][columna] = 'X'; //Marcador para un ataque exitoso
        } else {
            System.out.println("¡La IA falló el ataque!");
            tableroHumano[fila][columna] = 'A'; //Marcador para hueco atacado con agua
        }
    }

    private boolean esMovimientoValido(int fila, int columna, char[][] tablero) {
        //Verificar si la posición no ha sido atacada previamente
        return tablero[fila][columna] == '0';
    }

    private boolean esAtaqueExitoso(int fila, int columna, char[][] tablero) {
        //Verificar si la posición contiene un barco del oponente
        return tablero[fila][columna] == 'B';
    }

    private boolean juegoTerminado() {
        //Lógica para determinar si el juego ha terminado
        //El juego termina después de 10 turnos
        return turnos >= 10;
    }

    public void visualizar() {
        //Visualización del entorno virtual, gráficos 3D...
        System.out.println("Tablero del jugador humano: ");
        imprimirTablero(tableroHumano);

        System.out.println("\n Tablero de la IA: ");
        imprimirTablero(tableroIA);
    }

    private void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void adaptarEstrategias() {
        //Adaptación de estrategias basada en el juego humano
    }
}
