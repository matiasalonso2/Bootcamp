package JavaCLase3TT;

import java.util.Arrays;

public class Celular implements Precedable<Celular>{

    private String numero;
    private String titular;

    public Celular(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    //Retorna true si el titular del celular instanciado precede alfabeticamente
    //al titular del celular pasado por parámetro
    @Override
    public boolean precedeA(Celular celular) {
        String[] arr = new String[]{titular,celular.getTitular()};
        Arrays.sort(arr);
        return arr[0].equals(titular);
    }
}
