package Sesion7.Reto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalizadorDeLogs {

    public static void main(String[] args) {
        String archivoLogs = "errores.log";
        String archivoRegistroFallos = "registro_fallos.txt";

        int totalLineas = 0;
        int contadorErrores = 0;
        int contadorWarnings = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoLogs))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    contadorErrores++;
                }
                if (linea.contains("WARNING")) {
                    contadorWarnings++;
                }
            }

            System.out.println("----- Resumen del análisis de logs -----");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + contadorErrores);
            System.out.println("Cantidad de advertencias: " + contadorWarnings);

            int lineasConErroresYWarnings = contadorErrores + contadorWarnings;
            double porcentaje = totalLineas == 0 ? 0 : (lineasConErroresYWarnings * 100.0) / totalLineas;
            System.out.printf("Porcentaje de líneas con errores y advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo de logs: " + e.getMessage());
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoRegistroFallos))) {
                bw.write("Error al procesar el archivo '" + archivoLogs + "': " + e.getMessage());
            } catch (IOException ex) {
                System.err.println("No se pudo escribir en el archivo de registro de fallos: " + ex.getMessage());
            }
        }
    }
}

