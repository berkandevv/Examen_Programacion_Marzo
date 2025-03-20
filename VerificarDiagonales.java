/**
 * Implementa un método llamado verificarDiagonales que reciba una matriz (o
 * array bidimensional) de números enteros y verifique si los elementos en
 * la primera columna y la última fila son idénticos. Esto significa que todos
 * los elementos de la primera columna deben ser iguales entre sí, y todos los
 * elementos de la última fila también deben ser iguales entre sí.
 */

public class VerificarDiagonales {

    public static boolean verificarDiagonales(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Verificar si todos los elementos de la primera columna son iguales
        for (int i = 1; i < filas; i++) {
            if (matriz[i][0] != matriz[0][0]) {
                return false;
            }
        }

        // Verificar si todos los elementos de la última fila son iguales
        for (int j = 1; j < columnas; j++) {
            if (matriz[filas - 1][j] != matriz[filas - 1][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                { 5, 2, 3 },
                { 5, 4, 5 },
                { 5, 5, 5 },
        };

        if (verificarDiagonales(matriz)) {
            System.out.println("Los elementos de la primera columna y la última fila son idénticos.");
        } else {
            System.out.println("Los elementos de la primera columna y la última fila NO son idénticos.");
        }
    }
}
