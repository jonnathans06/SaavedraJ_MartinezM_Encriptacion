package ec.edu.ups;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Encriptar Desplazamiento -> 1");
        System.out.println("Encriptar Bit -> 2");
        System.out.print("Ingresar opción: ");
        String opcion = sc.next();
        System.out.println();

        switch (opcion) {
            case "1":
                testDesplazamiento();
                break;
            case "2":
                testBit();
                break;
            default:
                System.out.println("Elección incorrecta");
        }
    }

    public static void testDesplazamiento() {
        Encriptar<String, Integer> encriptarDesplazamiento =
                new Encriptar<>(new EncriptarDesplazamiento());
        String texto = "HELLO";
        int llave = 3;

        String textoEncriptado = encriptarDesplazamiento.encriptar(texto, llave);
        System.out.println(textoEncriptado);
    }

    public static void testBit() {
        // Creamos el encriptador de bits
        Encriptar<List<String>, String> encriptarBit =
                new Encriptar<>(new EncriptarBit<>());

        // Convertimos el texto en lista
        List<String> texto = Arrays.asList("H", "E", "L", "L", "O");
        String llave = "KEY";

        List<String> resultado = (List<String>) encriptarBit.encriptar(texto, llave);

        System.out.println(resultado);
    }
}
