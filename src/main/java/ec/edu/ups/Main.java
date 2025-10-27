package ec.edu.ups;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Encriptar Desplazamiento-> 1\nEncriptar Bit-> 2");
        System.out.print("Ingresar opción: ");
        String opcion = sc.next();
        System.out.println();

        switch (opcion) {
            case "1": testDesplazamiento(); break;
            case "2": testBit(); break;
            default:
                System.out.println("Elección incorrecta");
        }
    }

    public static void testDesplazamiento() {
        Encriptar <String, Integer> encriptarDesplazamiento =new Encriptar<>(new EncriptarDesplazamiento());
        String texto = "HELLO";
        int llave = 3;
        String textoEncriptado = (encriptarDesplazamiento.encriptar(texto, llave));
        System.out.println(textoEncriptado);
    }

    public static void testBit() {
        /*
        Encriptar <String, String> encriptarBit= new Encriptar<>(new EncriptarBit());
        String texto = "HELLO";
        String llave = "KEY";
        String textoEncriptado = (encriptarBit.encriptar(texto, llave));
        System.out.println(textoEncriptado);
         */
    }
}
