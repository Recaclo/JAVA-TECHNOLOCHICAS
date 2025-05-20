package Sesion8.Reto2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Excepción personalizada (checked)
class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}

public class MonitorCPU {

    private Set<Double> consumosRegistrados = new HashSet<>();

    public void iniciarMonitoreo() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese consumos de CPU de servidores (porcentaje). Escriba 'salir' para terminar.");

            while (true) {
                System.out.print("Consumo CPU: ");
                String entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("salir")) {
                    System.out.println("Monitoreo finalizado.");
                    break;
                }

                try {
                    double consumo = validarEntrada(entrada);

                    if (consumosRegistrados.contains(consumo)) {
                        System.out.println("Error: Registro duplicado detectado (" + consumo + "%). Ignorado.");
                        continue;
                    }

                    consumosRegistrados.add(consumo);

                    if (consumo > 95.0) {
                        throw new ConsumoCriticoException("Consumo crítico detectado: " + consumo + "%");
                    }

                    System.out.println("Consumo registrado correctamente: " + consumo + "%");

                } catch (NumberFormatException e) {
                    System.out.println("Error: Entrada no numérica válida. Intente de nuevo.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (ConsumoCriticoException e) {
                    System.out.println("ALERTA: " + e.getMessage());
                    // Aquí podrías añadir lógica para notificar, detener proceso, etc.
                }
            }

        } finally {
            // Cierre del recurso Scanner
            scanner.close();
            System.out.println("Recurso Scanner cerrado correctamente.");
        }
    }

    private double validarEntrada(String entrada) throws NumberFormatException, IllegalArgumentException {
        double valor = Double.parseDouble(entrada);

        if (valor < 0 || valor > 100) {
            throw new IllegalArgumentException("Valor fuera del rango permitido (0-100%).");
        }

        return valor;
    }

    // Método main para iniciar la aplicación
    public static void main(String[] args) {
        MonitorCPU monitor = new MonitorCPU();
        monitor.iniciarMonitoreo();
    }
}
