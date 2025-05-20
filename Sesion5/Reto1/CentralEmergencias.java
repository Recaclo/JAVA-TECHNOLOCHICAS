package Sesion5.Reto1;

public class CentralEmergencias {
    public static void main(String[] args) {
        // Instancias de operadores
        Operador operador1 = new Operador("Juan");
        Operador operador2 = new Operador("Laura");
        Operador operador3 = new Operador("Marco");

        // Crear unidades
        Ambulancia ambulancia = new Ambulancia("Ambulancia", operador1);
        Patrulla patrulla = new Patrulla("Patrulla", operador2);
        UnidadBomberos bomberos = new UnidadBomberos("UnidadBomberos", operador3);

        // Ejecutar operaciones
        ambulancia.iniciarOperacion();
        System.out.println();
        patrulla.iniciarOperacion();
        System.out.println();
        bomberos.iniciarOperacion();
    }
}
