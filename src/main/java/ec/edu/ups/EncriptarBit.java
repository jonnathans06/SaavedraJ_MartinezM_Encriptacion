package ec.edu.ups;

import java.util.ArrayList;
import java.util.List;

public class EncriptarBit <T> implements AlgoritmoEncriptacion <List<T> , String>{

    private List<String> listaTexto = new ArrayList<>();
    private List<String> listaLlave = new ArrayList<>();
    private List<Integer> textoAscii = new ArrayList<>();
    private List<Integer> llaveAscii = new ArrayList<>();
    private List<String> binarioTexto = new ArrayList<>();
    private List<String> binarioLlave = new ArrayList<>();
    private List<String> compararXorBit = new ArrayList<>();
    private List<String> xorMostrar = new ArrayList<>();
    private List<String> numeroXor = new ArrayList<>();
    private String resultado;

    @Override
    public String encriptar(String texto, String llave) {

        // Lista que guarda letra por letra del texto original
        for (int i = 0; i < texto.length(); i++) {
            listaTexto.add(String.valueOf(texto.charAt(i)));
        }

        // Lista que guarda letra por letra de la llave original
        for (int i = 0; i < texto.length(); i++) {
            listaLlave.add(String.valueOf(llave.charAt(i % llave.length())));
        }

        // Lista que guarda el ascii de texto
        for (int i = 0; i < texto.length(); i++) {
            textoAscii.add((int) texto.charAt(i));
        }

        // Lista que guarda el ascii de la llave
        for (int i = 0; i < texto.length(); i++) {
            llaveAscii.add((int) listaLlave.get(i).charAt(0));
        }

        // Lista que guarda el binario de un texto
        for (int i = 0; i < textoAscii.size(); i++) {
            String binario = Integer.toBinaryString(textoAscii.get(i));
            binarioTexto.add(binario);
        }

        // Lista que guarda el binario de la llave
        for (int i = 0; i < llaveAscii.size(); i++) {
            String binario = Integer.toBinaryString(llaveAscii.get(i));
            binarioLlave.add(binario);
        }

        // Lista que guarda la comparacion bit x bit de ascii del texto
        for (int i = 0; i < texto.length(); i++) {
            int t = textoAscii.get(i);
            int k = llaveAscii.get(i);
            int xor = t ^ k;

            String binario = String.format("%8s", Integer.toBinaryString(xor)).replace(' ', '0');

            xorMostrar.add(binario);
            compararXorBit.add(String.valueOf(xor));
        }

        // Lista que guarda el número normal del XOR
        for (int i = 0; i < compararXorBit.size(); i++) {
            String binario = Integer.toBinaryString(Integer.parseInt(compararXorBit.get(i)));
            numeroXor.add(binario);
        }

        resultado = String.join("",String.valueOf(compararXorBit));

        mostrarResultados(texto, llave);
        return resultado;
    }

    public void mostrarResultados(String texto, String llave) {

        System.out.println("=".repeat(33));
        System.out.println("ALGORITMO POR BIT");
        System.out.println("=".repeat(33));
        System.out.println("\n1- Datos de entrada");
        System.out.println("Texto original-> " + texto);
        System.out.println("Llave-> " + llave + listaLlave);

        System.out.println("\n2- PROCESO");
        System.out.println("-".repeat(33));
        System.out.println(" Caracter     ASCII     Binario");

        for (int i = 0; i < texto.length(); i++) {
            System.out.println("|" + " ".repeat(2) + listaTexto.get(i) + " ".repeat(11) + textoAscii.get(i) +
                    " ".repeat(6) + binarioTexto.get(i) + " ".repeat(2) + "|");
        }

        System.out.println("-".repeat(33));

        System.out.println(" Caracter     ASCII     Binario");
        for (int i = 0; i < listaLlave.size(); i++) {
            System.out.println("|" + " ".repeat(2) + listaLlave.get(i) + " ".repeat(11) + llaveAscii.get(i) +
                    " ".repeat(6) + binarioLlave.get(i) + " ".repeat(2) + "|");
        }
        System.out.println("-".repeat(33));

        System.out.println("       Proceso     Resultado");
        for (int i = 0; i < numeroXor.size(); i++) {
            System.out.println(" ".repeat(7) + xorMostrar.get(i) + " ".repeat(6) + compararXorBit.get(i));
        }
        System.out.println("-".repeat(33));

        System.out.println("3. Salida");
    }
}
