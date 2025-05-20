package Sesion5.Reto2;

public class CajaRegistradora {
    public static void main(String[] args) {
        MetodoPago[] pagos = {
            new PagoEfectivo(150.0),
            new PagoTarjeta(320.0, 500.0),
            new PagoTransferencia(210.0, false) // Simula error bancario
        };

        for (MetodoPago pago : pagos) {
            if (pago instanceof Autenticable) {
                Autenticable metodo = (Autenticable) pago;
                if (metodo.autenticar()) {
                    System.out.println("Autenticación exitosa.");
                    pago.procesarPago();
                    pago.mostrarResumen();
                    System.out.println();
                } else {
                    System.out.println("Fallo de autenticación. Transferencia no válida.");
                    System.out.println();
                }
            }
        }
    }
}
