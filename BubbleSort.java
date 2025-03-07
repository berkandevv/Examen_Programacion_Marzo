/**
 * Implementad en Java un método de ordenación para un array bidimensional (o
 * matriz) de números enteros. Este método debe recibir una array bidimensional
 * como parámetro y permitir la ordenación tanto ascendente como descendente.
 * El tipo de ordenación (ascendente o descendente) se especificará mediante
 * un parámetro booleano a tu criterio.
 */

public class BubbleSort {

    public static void burbuja(int[][] matriz, boolean ascendente) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return;
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;
        int totalElementos = filas * columnas;

        for (int i = 0; i < totalElementos - 1; i++) {
            for (int j = 0; j < totalElementos - i - 1; j++) {
                int filaActual = j / columnas;
                int columnaActual = j % columnas;
                int filaSiguiente = (j + 1) / columnas;
                int columnaSiguiente = (j + 1) % columnas;

                if (ascendente) {
                    // Orden ascendente
                    if (matriz[filaActual][columnaActual] > matriz[filaSiguiente][columnaSiguiente]) {
                        // Swap elementos
                        int temp = matriz[filaActual][columnaActual];
                        matriz[filaActual][columnaActual] = matriz[filaSiguiente][columnaSiguiente];
                        matriz[filaSiguiente][columnaSiguiente] = temp;
                    }
                } else {
                    // Orden descendente
                    if (matriz[filaActual][columnaActual] < matriz[filaSiguiente][columnaSiguiente]) {
                        // Swap elementos
                        int temp = matriz[filaActual][columnaActual];
                        matriz[filaActual][columnaActual] = matriz[filaSiguiente][columnaSiguiente];
                        matriz[filaSiguiente][columnaSiguiente] = temp;
                    }
                }
            }
        }
    }

    public static void printmatriz(int[][] matriz) {
        for (int[] row : matriz) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrizAscendente = {
                { 9, 8, 5 },
                { 4, 2, 1 },
        };

        int[][] matrizDescendente = {
                { 8, 1, 5 },
                { 4, 2, 10 },
        };

        // Ordenación ascendente
        burbuja(matrizAscendente, true);
        System.out.println("\nMatriz ordenada ascendente:");
        printmatriz(matrizAscendente);

        // Ordenación descendente
        burbuja(matrizDescendente, false);
        System.out.println("\nMatriz ordenada descendente:");
        printmatriz(matrizDescendente);
    }
}
