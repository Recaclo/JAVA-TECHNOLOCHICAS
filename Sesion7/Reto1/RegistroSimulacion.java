package Sesion7.Reto1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RegistroSimulacion {
    public static void main(String[] args) {
        try {
            // Paso 1: Definir la ruta del archivo en la carpeta config/
            Path carpetaConfig = Paths.get("config");
            Path archivoParametros = carpetaConfig.resolve("parametros.txt");

            // Paso 2: Crear la carpeta config si no existe
            if (!Files.exists(carpetaConfig)) {
                Files.createDirectories(carpetaConfig);
                System.out.println("Carpeta 'config/' creada.");
            }

            // Paso 3: Definir parámetros de simulación
            String parametros = """
                Tiempo de ciclo: 55.8 segundos
                Velocidad de línea: 1.2 m/s
                Número de estaciones: 8
                """;

            // Paso 4: Escribir los parámetros al archivo
            Files.write(archivoParametros, parametros.getBytes(StandardCharsets.UTF_8));
            System.out.println("Archivo de parámetros creado en: " + archivoParametros);

            // Paso 5: Verificar existencia del archivo
            if (Files.exists(archivoParametros)) {
                System.out.println(" Archivo verificado correctamente.");
            } else {
                System.out.println(" Error: El archivo no se encontró.");
                return;
            }

            // Paso 6: Leer el contenido del archivo y mostrarlo
            String contenidoLeido = Files.readString(archivoParametros);
            System.out.println("\n Contenido del archivo:");
            System.out.println("----------------------------");
            System.out.println(contenidoLeido);
            System.out.println("----------------------------");

        } catch (IOException e) {
            System.err.println(" Error al manejar archivos: " + e.getMessage());
        }
    }
}


