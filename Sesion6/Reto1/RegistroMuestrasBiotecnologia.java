package Sesion6.Reto1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class RegistroMuestrasBiotecnologia {
    public static void main(String[] args) {

        // Paso 1: ArrayList para registrar todas las especies en orden de llegada
        ArrayList<String> muestrasOrdenLlegada = new ArrayList<>();
        muestrasOrdenLlegada.add("Homo sapiens");
        muestrasOrdenLlegada.add("Mus musculus");
        muestrasOrdenLlegada.add("Arabidopsis thaliana");
        muestrasOrdenLlegada.add("Homo sapiens"); // Muestra replicada
        muestrasOrdenLlegada.add("Drosophila melanogaster");

        // Paso 2: HashSet para identificar especies únicas (no se repiten)
        HashSet<String> especiesUnicas = new HashSet<>(muestrasOrdenLlegada);

        // Paso 3: HashMap para asociar el ID de la muestra con el investigador
        HashMap<String, String> idMuestraInvestigador = new HashMap<>();
        idMuestraInvestigador.put("M-001", "Dra. López");
        idMuestraInvestigador.put("M-002", "Dr. Hernández");
        idMuestraInvestigador.put("M-003", "Mtra. Jiménez");
        idMuestraInvestigador.put("M-004", "Dr. Gómez");

        // Paso 4: Mostrar resultados

        // Muestras en orden de llegada
        System.out.println(" Muestras en orden de llegada:");
        for (String especie : muestrasOrdenLlegada) {
            System.out.println("- " + especie);
        }

        // Especies únicas procesadas
        System.out.println("\n Especies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        // Relación ID → Investigador
        System.out.println("\n Relación de ID de muestra → Investigador:");
        for (String id : idMuestraInvestigador.keySet()) {
            System.out.println("- " + id + " → " + idMuestraInvestigador.get(id));
        }

        // Búsqueda por ID de muestra (ejemplo: M-002)
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Ingrese el ID de muestra para buscar al investigador (ej. M-002): ");
        String idBusqueda = scanner.nextLine();

        if (idMuestraInvestigador.containsKey(idBusqueda)) {
            System.out.println(" Investigador responsable: " + idMuestraInvestigador.get(idBusqueda));
        } else {
            System.out.println(" ID no encontrado en el registro.");
        }

        scanner.close();
    }
}
