link al repositorio: https://github.com/siraglez/entregaUd8TP.git



# Ejercicio 2: Plataforma de E-Commerce con Recomendaciones Inteligentes y Análisis de Preferencias

## 1. Clase `ClienteECommerce`:

- Representa a un cliente de la tienda en línea.
- Mantiene un historial de compras, recomendaciones y otros datos del cliente.
- Contiene métodos para agregar compras, mostrar historial de compras y generar recomendaciones personalizadas.

## 2. Clase `TiendaECommerce`:

- Representa la tienda en línea y contiene listas de clientes, obras y pedidos.
- Proporciona métodos para gestionar clientes, obras, realizar pedidos y mostrar información.

## 3. Clase `Obra`:

- Clase base para representar obras genéricas con un título y precio.

## 4. Clase `Libro`:

- Extiende la clase `Obra` y agrega un atributo adicional (`autor`).
- Representa un libro específicamente.

## 5. Clase `Video`:

- Extiende la clase `Obra` y agrega un atributo adicional (`director`).
- Representa un video específicamente.

## 6. Clase `Pedido`:

- Representa un pedido realizado por un cliente, manteniendo una lista de obras compradas.
- Agrega las obras al historial de compras del cliente.

## 7. Clase `Main`:

- Contiene el método `main` que actúa como punto de entrada del programa.
- Ofrece un menú de opciones para el cliente, permitiendo ver el catálogo, realizar pedidos, mostrar historial de compras y generar recomendaciones.

El código utiliza características de Java como listas, mapas, expresiones lambda y streams para realizar operaciones sobre las colecciones de datos. Además, implementa la generación de recomendaciones basadas en el historial de compras y preferencias del cliente.

# Pseudocódigo

```java
Clase ClienteECommerce:
    Atributos:
        - nombre: String
        - numeroCliente: int
        - historialCompras: Lista de Obra
        - recomendaciones: Mapa de (String, Lista de Obra)

    Método ClienteECommerce(nombre: String, numeroCliente: int):
        Asignar nombre y numeroCliente
        Inicializar historialCompras como Lista vacía
        Inicializar recomendaciones como Mapa vacío

    Método getNombre(): String:
        Devolver nombre

    Método setNombre(nombre: String):
        Asignar nombre

    Método getNumeroCliente(): int:
        Devolver numeroCliente

    Método setNumeroCliente(numeroCliente: int):
        Asignar numeroCliente

    Método getHistorialCompras(): Lista de Obra:
        Devolver historialCompras

    Método setHistorialCompras(historialCompras: Lista de Obra):
        Asignar historialCompras

    Método getRecomendaciones(): Mapa de (String, Lista de Obra):
        Devolver recomendaciones

    Método setRecomendaciones(recomendaciones: Mapa de (String, Lista de Obra)):
        Asignar recomendaciones

    Método agregarCompra(obra: Obra):
        Añadir obra a historialCompras
        Llamar a actualizarRecomendaciones

    Método mostrarHistorialCompras():
        Imprimir "Historial de compras de nombre:"
        Si historialCompras está vacío:
            Imprimir "El cliente no ha realizado compras."
        Sino:
            Para cada obra en historialCompras:
                Imprimir "- Título: obra.titulo | Precio: $obra.precio"

    Método generarRecomendaciones():
        Imprimir "Recomendaciones para nombre:"
        Para cada categoría en las claves de recomendaciones:
            Imprimir "Categoría: categoría"
            Obtener obrasRecomendadas de recomendaciones para la categoría
            Para cada obra en obrasRecomendadas:
                Imprimir "- Título: obra.titulo"

    Método privado actualizarRecomendaciones():
        Limpiar recomendaciones
        Agrupar obrasPorCategoria por categoría en historialCompras
        Obtener categoríasOrdenadas por frecuencia de compra en obrasPorCategoria
        Para cada categoría en categoríasOrdenadas:
            Si recomendaciones no contiene la categoría:
                Obtener obrasRecomendadas de obrasPorCategoria para la categoría
                Mezclar obrasRecomendadas para variedad
                Añadir las primeras 3 obrasRecomendadas o todas si hay menos de 3 a recomendaciones

    Método privado obtenerCategoria(obra: Obra): String:
        Si obra es instancia de Libro:
            Devolver "Libros"
        Sino si obra es instancia de Video:
            Devolver "Videos"
        Sino:
            Devolver "Otras categorías"

```


# Ejercicio 3: Juego de Estrategia Naval con Inteligencia Artificial y Simulación de Entornos Marinos

## 1. Clase CuadriculaIA

La clase `CuadriculaIA` representa un juego de estrategia naval con inteligencia artificial y simulación de entornos marinos.

### 1.1. Atributos

- `tablero`: Matriz para representar el tablero de juego.
- `simulacionAmbiental`: Matriz para simular condiciones marinas.
- `random`: Objeto de la clase `Random` utilizado para generar números aleatorios.

### 1.2. Métodos

- `mostrarTablero()`: Muestra el estado actual del tablero con índices de fila y columna.
- `depositarBarco(int fila, int columna, int longitud, boolean esHorizontal)`: Coloca un barco en la posición dada en el tablero.
- `posicionarBarcoIA(int longitud)`: Posiciona automáticamente un barco en el tablero utilizando inteligencia artificial.
- `disparar(int fila, int columna)`: Simula un disparo en la posición dada y actualiza el tablero.
- `ataqueIA()`: Estrategia de ataque automático por parte de la IA.
- `visualizacion()`: Muestra el estado actual del tablero sin formato específico.

### 1.3. Métodos Privados

- `esPosicionValida(int fila, int columna)`: Verifica si una posición dada es válida en el tablero.
- `esPosicionValidaParaBarco(int fila, int columna, int longitud, boolean esHorizontal)`: Verifica si es válida para colocar un barco.

## 2. Clase JuegoNavalIA

La clase `JuegoNavalIA` contiene el método `main` para ejecutar el juego.

### 2.1. Métodos

- `main(String[] args)`: Crea una instancia de `CuadriculaIA`, muestra el tablero antes de comenzar, posiciona automáticamente un barco con la IA, realiza disparos automáticos de la IA y muestra el estado actual del tablero.

# Pseudocódigo

```java
Clase CuadriculaIA:
    - tablero: char[][]
    - simulacionAmbiental: int[][]
    - random: Random

    + CuadriculaIA(filas: int, columnas: int)
    + mostrarTablero(): void
    + depositarBarco(fila: int, columna: int, longitud: int, esHorizontal: boolean): void
    + posicionarBarcoIA(longitud: int): void
    + disparar(fila: int, columna: int): void
    + ataqueIA(): void
    + visualizacion(): void
    - esPosicionValida(fila: int, columna: int): boolean
    - esPosicionValidaParaBarco(fila: int, columna: int, longitud: int, esHorizontal: boolean): boolean

Clase JuegoNavalIA:
    - scanner: Scanner
    - cuadricula: CuadriculaIA

    + main(args: String[]): void

```
