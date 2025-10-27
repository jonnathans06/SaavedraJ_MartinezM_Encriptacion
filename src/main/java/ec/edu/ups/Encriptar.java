package ec.edu.ups;

public class Encriptar <T, L>{
    private AlgoritmoEncriptacion <T, L> algoritmo;

    public Encriptar(AlgoritmoEncriptacion<T, L> algoritmoEncriptacion) {
        this.algoritmo = algoritmoEncriptacion;
    }

    public T encriptar(T texto, L llave) {
        return algoritmo.encriptar(texto, llave);
    }
}
