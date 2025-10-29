package ec.edu.ups;

import java.util.ArrayList;
import java.util.List;

public class EncriptarBit<T> implements AlgoritmoEncriptacion<List<T>, String> {

    private List<String> listaTexto = new ArrayList<>();
    private List<String> listaLlave = new ArrayList<>();
    private List<Integer> textoAscii = new ArrayList<>();
    private List<Integer> llaveAscii = new ArrayList<>();
    private List<String> binarioTexto = new ArrayList<>();
    private List<String> binarioLlave = new ArrayList<>();
    private List<String> compararXorBit = new ArrayList<>();
    private List<String> xorMostrar = new ArrayList<>();
    private List<String> numeroXor = new ArrayList<>();

    @Override
    public List<T> encriptar(List<T> texto, String llave) {

        // Limpiar listas en caso de múltiples ejecuciones
        listaTexto.clear();
        listaLlave.clear();
        textoAscii.clear();
        llaveAscii.clear();
        binarioTexto.clear();
        binarioLlave.clear();
        compararXorBit.clear();
        xorMostrar.clear();
        numeroXor.clear();

        List<T> resultado = new ArrayList<>();

        // Lista que guarda letra por letra del texto original
        for (int i = 0; i < texto.size(); i++) {
            listaTexto.add(String.valueOf(texto.get(i)));
        }

        // Lista que guarda letra por letra de la llave original
        for (int i = 0; i < texto.size(); i++) {
            listaLlave.add(String.valueOf(llave.charAt(i % llave.length())));
        }

        // Lista que guarda el ascii de texto
        for (int i = 0; i < texto.size(); i++) {
            textoAscii.add((int) listaTexto.get(i).charAt(0));
        }

        // Lista que guarda el ascii de la llave
        for (int i = 0; i < texto.size(); i++) {
            llaveAscii.add((int) listaLlave.get(i).charAt(0));
        }

        // Lista que guarda el binario de un texto
        for (int valor : textoAscii) {
            binarioTexto.add(Integer.toBinaryString(valor));
        }

        // Lista que guarda el binario de la llave
        for (int valor : llaveAscii) {
            binarioLlave.add(Integer.toBinaryString(valor));
        }

        // XOR bit a bit
        for (int i = 0; i < texto.size(); i++) {
            int t = textoAscii.get(i);
            int k = llaveAscii.get(i);
            int xor = t ^ k;

            String binario = String.format("%8s", Integer.toBinaryString(xor)).replace(' ', '0');
            xorMostrar.add(binario);
            compararXorBit.add(String.valueOf(xor));

            // Guardamos el XOR como tipo genérico
            resultado.add((T) (Integer) xor);
        }

        mostrarResultados(String.join("", listaTexto), llave);

        return resultado;
    }

    public void mostrarResultados(String texto, String llave) {
        System.out.println("=".repeat(33));
        System.out.println("ALGORITMO POR BIT");
        System.out.println("=".repeat(33));
        System.out.println("\n1- Datos de entrada");
        System.out.println("Texto original -> " + texto);
        System.out.println("Llave -> " + llave + " " + listaLlave);

        System.out.println("\n2- PROCESO");
        System.out.println("-".repeat(33));
        System.out.println(" Caracter     ASCII     Binario");

        for (int i = 0; i < listaTexto.size(); i++) {
            System.out.println("| " + listaTexto.get(i) + " ".repeat(10) + textoAscii.get(i) +
                    " ".repeat(6) + binarioTexto.get(i) + " |");
        }

        System.out.println("-".repeat(33));
        System.out.println(" Caracter     ASCII     Binario");

        for (int i = 0; i < listaLlave.size(); i++) {
            System.out.println("| " + listaLlave.get(i) + " ".repeat(10) + llaveAscii.get(i) +
                    " ".repeat(6) + binarioLlave.get(i) + " |");
        }

        System.out.println("-".repeat(33));
        System.out.println("       Proceso     Resultado");

        for (int i = 0; i < compararXorBit.size(); i++) {
            System.out.println(" ".repeat(7) + xorMostrar.get(i) + " ".repeat(6) + compararXorBit.get(i));
        }

        System.out.println("-".repeat(33));
        System.out.println("3. Salida.");
    }
}
