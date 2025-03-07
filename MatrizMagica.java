/**
 * Implementad un método en Java que solicite los elementos de una matriz de
 * tamaño N x N. El método debe devolver si la matriz introducida corresponde 
 * a una matriz mágica, que es aquella donde la suma de los elementos de cualquier 
 * fila o de cualquier columna valen lo mismo.
 */

public class MatrizMagica {

    // Método para verificar si la matriz es un cuadrado mágico
    public static boolean matrizMagica(int[][] matriz) {

        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return false; // Si la matriz es nula o vacía, no es un cuadrado mágico
        }

        int filas = matriz.length; // Número de filas y columnas (porque es cuadrada)

        // Verificar si la matriz es cuadrada (el número de filas debe ser igual al número de columnas)
        for (int i = 0; i < filas; i++) {
            if (matriz[i].length != filas) {
                return false; // Si alguna fila no tiene el mismo número de columnas, no es un cuadrado mágico
            } 
        }

        // Calcular la suma de la primera fila para establecer el objetivo
        int sumaObjetivo = 0;

        for (int j = 0; j < filas; j++) {
            sumaObjetivo += matriz[0][j];
        }

        // Verificar las sumas de las filas
        for (int i = 0; i < filas; i++) {

            int sumaFila = 0;

            for (int j = 0; j < filas; j++) {
                sumaFila += matriz[i][j];
            }

            if (sumaFila != sumaObjetivo) {
                return false; // Si alguna fila no tiene la misma suma, no es un cuadrado mágico
            }
        }

        // Verificar las sumas de las columnas
        for (int j = 0; j < filas; j++) {

            int sumaColumna = 0;

            for (int i = 0; i < filas; i++) {
                sumaColumna += matriz[i][j];
            }
            if (sumaColumna != sumaObjetivo) {
                return false; // Si alguna columna no tiene la misma suma, no es un cuadrado mágico
            }
        }

        // Verificar la suma de la diagonal principal
        int sumaDiagonalPrincipal = 0;

        for (int i = 0; i < filas; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
        }
        if (sumaDiagonalPrincipal != sumaObjetivo) {
            return false; // Si la suma de la diagonal principal no es igual a la suma objetivo
        }

        // Verificar la suma de la diagonal secundaria
        int sumaDiagonalSecundaria = 0;

        for (int i = 0; i < filas; i++) {
            sumaDiagonalSecundaria += matriz[i][filas - 1 - i];
        }
        if (sumaDiagonalSecundaria != sumaObjetivo) {
            return false; // Si la suma de la diagonal secundaria no es igual a la suma objetivo
        }

        return true; // Si todas las verificaciones pasan, es un cuadrado mágico
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
        System.out.println(matrizMagica(matriz4)); // false

        // Ejemplo 5: Matriz vacía
        int[][] matriz5 = {};
        System.out.println(matrizMagica(matriz5)); // false
    }
}
