/**
 * Implementad un método en Java que solicite los elementos de una matriz de
 * tamaño N x N. El método debe devolver si la matriz introducida corresponde
 * a una matriz mágica, que es aquella donde la suma de los elementos de
 * cualquier
 * fila o de cualquier columna valen lo mismo.
 */

public class MatrizMagica {

    // Método para verificar si la matriz es un cuadrado mágico
    public static boolean matrizMagica(int[][] matriz) {

        if (matriz == null || matriz.length == 0) {
            return false; // Si la matriz es nula o vacía, no es un cuadrado mágico
        }

        int filas = matriz.length;
        int sumaObjetivo = 0;

        // Sumar los elementos de la primera fila para establecer la suma objetivo
        for (int j = 0; j < filas; j++) {
            sumaObjetivo += matriz[0][j];
        }

        // Verificar las sumas de filas, columnas y diagonales
        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;

        for (int i = 0; i < filas; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;

            // Sumar elementos de la fila y columna
            for (int j = 0; j < filas; j++) {
                sumaFila += matriz[i][j];
                sumaColumna += matriz[j][i];
            }

            // Verificar suma de fila y columna
            if (sumaFila != sumaObjetivo || sumaColumna != sumaObjetivo) {
                return false;
            }

            // Verificar diagonales
            sumaDiagonalPrincipal += matriz[i][i];
            sumaDiagonalSecundaria += matriz[i][filas - 1 - i];
        }

        // Verificar las sumas de las diagonales
        return sumaDiagonalPrincipal == sumaObjetivo && sumaDiagonalSecundaria == sumaObjetivo;
    }

    public static void main(String[] args) {

        // Ejemplo 1: Matriz 1x1
        int[][] matriz1 = { { 6 } };
        System.out.println(matrizMagica(matriz1)); // true

        // Ejemplo 2: Matriz 2x2
        int[][] matriz2 = { { 1, 2 }, { 3, 4 } };
        System.out.println(matrizMagica(matriz2)); // false

        // Ejemplo 3: Matriz 3x3
        int[][] matriz3 = {
                { 8, 1, 6 },
                { 3, 5, 7 },
                { 4, 9, 2 }
        };
        System.out.println(matrizMagica(matriz3)); // true

        // Ejemplo 4: Matriz 4x4
        int[][] matriz4 = {
                { 1, 15, 14, 4 },
                { 12, 6, 7, 9 },
                { 8, 10, 11, 5 },
                { 13, 3, 2, 16 }
        };
        System.out.println(matrizMagica(matriz4)); // true

        // Ejemplo 5: Matriz vacía
        int[][] matriz5 = {};
        System.out.println(matrizMagica(matriz5)); // false
    }
}
