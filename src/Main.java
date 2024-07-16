import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        boolean turnoJugador1 = true; // true: Jugador 1 (X), false: Jugador 2 (O)
        char jugadorActual = 'X'; // Comenzamos con el jugador 1 (X)

        inicializarTablero(tablero);

        Scanner scanner = new Scanner(System.in);

        while (!hayGanador(tablero) && !tableroLleno(tablero)) {
            mostrarTablero(tablero);
            System.out.println("Turno del jugador " + jugadorActual);
            System.out.print("Ingresa la fila (0-2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingresa la columna (0-2): ");
            int columna = scanner.nextInt();

            if (esMovimientoValido(tablero, fila, columna)) {
                tablero[fila][columna] = jugadorActual;
                turnoJugador1 = !turnoJugador1;
                jugadorActual = turnoJugador1 ? 'X' : 'O';
            } else {
                System.out.println("Movimiento inválido. Inténtalo de nuevo.");
            }
        }

        mostrarTablero(tablero);

        if (hayGanador(tablero)) {
            System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
        } else {
            System.out.println("Empate. ¡Fin del juego!");
        }
    }

    private static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private static void mostrarTablero(char[][] tablero) {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }

    private static boolean esMovimientoValido(char[][] tablero, int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '-';
    }

    private static boolean hayGanador(char[][] tablero) {
        // Implementa la lógica para verificar si hay un ganador
        // (combinaciones de filas, columnas y diagonales)
        // Devuelve boolean true si hay un ganador, false en caso contrario.
        // ¡Tarea para el lector!
        return false;
    }

    private static boolean tableroLleno(char[][] tablero) {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                if (celda == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
