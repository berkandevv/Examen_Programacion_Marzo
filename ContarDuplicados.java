import java.util.HashMap;

/**
 * Escribe un método llamado especiesDuplicadas que recibe un array de cadenas,
 * donde cada cadena representa el nombre de una especie de planta. El método
 * debe devolver el número de especies únicas que aparecen más de una vez en
 * el array. Los nombres de las especies no son key sensitive, es decir, no
 * distinguen entre mayúsculas y minúsculas, por ejemplo, "rosa" y "Rosa"
 * deben considerarse la misma especie.
 */

public class ContarDuplicados {

    public static int especiesDuplicadas(String[] especies) {
        // Crear un HashMap para rastrear si una especie es repetida o no
        HashMap<String, Integer> repetidos = new HashMap<>();

        // Recorrer cada especie en el array
        for (String especie : especies) {
            // Convertir la especie a minúsculas para tratar "ROSA" y "rosa" como iguales
            especie = especie.toLowerCase();

            Integer contador = repetidos.get(especie);

            // Verificar si la especie ya se encuentra en el HashMap
            if (contador == null) {
                // Si ya está, marcarla como repetida
                repetidos.put(especie, 1);
            } else {
                // Si no está, agregarla con valor false (no repetida)
                repetidos.put(especie, contador + 1);
            }
        }

        // Contar cuántas especies están repetidas (tienen valor true)
        int totalRepetidos = 0;
        for (int esRepetido : repetidos.values()) {
            if (esRepetido > 1) {
                totalRepetidos++;
            }
        }

        return totalRepetidos;
    }

    public static void main(String[] args) {
        String[] especies = { "Rosa", "Lirio", "rosa", "Tulipan", "LIRIO", "Margarita" };
        String[] especies2 = { "Orquidea", "Girasol", "Clavel", "Azucena" };
        String[] especies3 = { "Bambu", "bambu", "BAMBU", "Bambu" };

        System.out.println("Total de especies repetidas: " + especiesDuplicadas(especies)); // 2
        System.out.println("Total de especies repetidas: " + especiesDuplicadas(especies2)); // 0
        System.out.println("Total de especies repetidas: " + especiesDuplicadas(especies3)); // 1
    }
}
