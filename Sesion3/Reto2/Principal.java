package Sesion3.Reto2;

public class Principal {
    public static void main(String[] args) {
        // ✅ Factura con RFC
        Factura factura1 = new Factura(2500.0, "Servicio de consultoría", "ABCC010101XYZ");
        System.out.println(factura1.getResumen());
        System.out.println();

        // ✅ Factura sin RFC (null)
        Factura factura2 = new Factura(1800.0, "Reparación de equipo", null);
        System.out.println(factura2.getResumen());
    }
}
