package ejercicio4;

public class GuerraBarcosAvanzada {
    public static void main(String[] args) {
        //Crear una cuadrícula virtual con 5 filas y 5 columnas
        CuadriculaVirtual cuadricula = new CuadriculaVirtual(5, 5);

        //Mostrar los tableros antes de comenzar
        cuadricula.visualizar();

        //Jugar el juego
        cuadricula.jugar();

        //Mostrar el tablero después de terminar el juego
        cuadricula.visualizar();

        //Adaptar las estrategias basadas en el juego humano
        cuadricula.adaptarEstrategias();
    }
}
