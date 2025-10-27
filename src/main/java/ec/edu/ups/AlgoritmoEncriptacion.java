package ec.edu.ups;

public interface AlgoritmoEncriptacion <T, L>{
    T encriptar(T texto, L llave);
}
