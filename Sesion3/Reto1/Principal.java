package Sesion3.Reto1;

public class Principal {
    public static void main(String[] args) {
        // Crear pasajero y vuelo
        Pasajero p1 = new Pasajero("Ana Martínez", "A1234567");
        Vuelo vuelo1 = new Vuelo("UX123", "París", "14:30");

        // Reservar asiento
        if (vuelo1.reservarAsiento(p1)) {
            System.out.println(" Reserva realizada con éxito.");
        }

        // Mostrar itinerario
        System.out.println(vuelo1.obtenerItinerario());

        // Cancelar reserva
        System.out.println("\n Cancelando reserva...");
        vuelo1.cancelarReserva();

        // Mostrar itinerario nuevamente
        System.out.println(vuelo1.obtenerItinerario());

        // Reservar asiento con nombre y pasaporte (sobrecarga)
        vuelo1.reservarAsiento("Mario Gonzalez", "M9876543");

        // Mostrar itinerario final
        System.out.println(vuelo1.obtenerItinerario());
    }
}
