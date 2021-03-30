package JavaClase4Repaso.Ejercicio1;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> dic;

    public GuardaRopa() {
        dic = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        boolean agregado= false;
        int salida = 1;
        if (dic.get(1)== null) {
            dic.put(1, listaDePrenda);
            agregado = true;
        }
        int i= 1;
        while(!agregado && i <= dic.size()){
            if (dic.get(i) == null){
                dic.put(i, listaDePrenda);
                salida = i;
                agregado = true;
            }
            i++;
        }
        if (!agregado) {
            dic.put(dic.size()+1,listaDePrenda);
            salida = dic.size();
        }
        return salida;

    }

    public void nostrarPrendas(){
        for (int i=1; i<= dic.size(); i++){
            if (dic.get(i)!=null){
                for (Prenda p: dic.get(i))
                    System.out.print (i + " - " + p.getModelo());
                System.out.println();
            }

        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        var salida = dic.get(numero);
        dic.put(numero, null);
        return salida;
    }









}
