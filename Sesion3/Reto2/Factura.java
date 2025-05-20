package Sesion3.Reto2;

import java.util.Optional;

public class Factura {
    // 🔐 Atributos privados
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    // 🛠️ Constructor público
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc); // Manejo seguro de null
    }

    // 🛠️ Método público
    public String getResumen() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("📄 Factura generada:\n");
        resumen.append("Descripción: ").append(descripcion).append("\n");
        resumen.append("Monto: $").append(monto).append("\n");
        resumen.append("RFC: ").append(rfc.orElse("[No proporcionado]"));
        return resumen.toString();
    }
}
