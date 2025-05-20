package Sesion2.Reto2;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saldo inicial con inferencia de tipo
        var saldo = 1000.0;
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\nBienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            // Control de flujo con switch
            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + saldo);
                    break;

                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    if (deposito <= 0) {
                        System.out.println(" El monto debe ser mayor que cero.");
                        continue;
                    }
                    saldo += deposito;
                    System.out.println(" Depósito exitoso. Nuevo saldo: $" + saldo);
                    break;

                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro <= 0) {
                        System.out.println(" El monto debe ser mayor que cero.");
                        continue;
                    }
                    if (retiro > saldo) {
                        System.out.println(" Saldo insuficiente.");
                        continue;
                    }
                    saldo -= retiro;
                    System.out.println(" Retiro exitoso. Nuevo saldo: $" + saldo);
                    break;

                case 4:
                    System.out.println(" Gracias por usar el cajero automático. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println(" Opción inválida. Intente nuevamente.");
                    continue;
            }
        } while (opcion != 4);

        scanner.close();
    }
}
