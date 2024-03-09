package ejercicio3;

import java.util.Scanner;

public class JuegoNavalIA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuadriculaIA cuadricula = new CuadriculaIA(10, 10);

        //Mostrar el tablero antes de comenzar
        cuadricula.mostrarTablero();

        //Colocar un barco automáticamente con la IA
        cuadricula.posicionarBarcoIA(3); //Ejemplo con barco de longitud 3

        //Realizar disparos automáticos de la IA
        cuadricula.ataqueIA();
        cuadricula.ataqueIA();

        //Mostrar el estado actual del tablero
        cuadricula.visualizacion();

        scanner.close();
    }
}
