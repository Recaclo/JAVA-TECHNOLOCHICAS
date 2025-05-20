package Sesion2.Reto1;

import java.util.Scanner;

public class SimuladorFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Nombre del medicamento: ");
        var nombreMedicamento = scanner.nextLine();

        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        System.out.print("Cantidad de piezas: ");
        int cantidad = scanner.nextInt();

        // Calcular total sin descuento
        double totalSinDescuento = precioUnitario * cantidad;

        // Aplicar descuento si corresponde (usando operador ternario)
        boolean aplicaDescuento = totalSinDescuento > 500;
        double descuento = aplicaDescuento ? totalSinDescuento * 0.15 : 0;
        double totalPagar = totalSinDescuento - descuento;

        // Mostrar resumen
        System.out.println("\nMedicamento: " + nombreMedicamento);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + totalPagar);

        scanner.close();
    }
}
