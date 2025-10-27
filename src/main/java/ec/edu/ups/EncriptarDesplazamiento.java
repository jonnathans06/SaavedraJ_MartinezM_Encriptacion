package ec.edu.ups;

import java.util.ArrayList;
import java.util.List;

public class EncriptarDesplazamiento implements AlgoritmoEncriptacion<String, Integer>{
    private List<String> listaEncriptada = new ArrayList<>();
    private List<String> listaPorEncriptar = new ArrayList<>();
    @Override
    public String encriptar(String texto, Integer llave) {


        String resultado;

        String[] abecedario = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " "
        };


        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            listaPorEncriptar.add(String.valueOf(c));
        }

        for (int j = 0; j < listaPorEncriptar.size(); j++) {
            for (int i = 0; i < abecedario.length; i++) {
                if (listaPorEncriptar.get(j).equalsIgnoreCase(abecedario[i])) {
                    int nuevaPos = (i + llave) % abecedario.length;
                    listaEncriptada.add(abecedario[nuevaPos]);
                }
            }
        }


        resultado = String.join("", listaEncriptada);
        mostrarResultados(texto, llave);
        return resultado;
    }

    public void mostrarResultados(String texto, int llave) {
        System.out.println("=".repeat(28));
        System.out.println("ALGORITMO POR DESPLAZAMIENTO");
        System.out.println("=".repeat(28));
        System.out.println("\n1- Datos de entrada");
        System.out.println("Texto original-> " + texto);
        System.out.println("Desplazamiento-> " + llave);

        System.out.println("\n2- PROCESO");
        System.out.println("Letra original   Desplazamiento");
        System.out.println("-".repeat(32));

        for (int i = 0; i < listaPorEncriptar.size(); i++) {
            System.out.println("|" + " ".repeat(6) +listaPorEncriptar.get(i) +
                    " ".repeat(16) + listaEncriptada.get(i) + " ".repeat(6) + "|");
        }

        System.out.println("-".repeat(32));

        System.out.println("\n3- Salida");
    }
}
