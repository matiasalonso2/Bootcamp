package JavaClase4TM;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T>{

    private void quickSort(T[] arr, int izq, int der, Comparator<T> c){
        T pivote=arr[(izq + der) / 2];
        int i=izq;
        int j=der;
        T aux;
        while(i < j){
            while(c.compare(arr[i], pivote) < 0&& i < j) i++;
            while(c.compare(arr[j], pivote) > 0) j--;
            if (i < j) {
                aux = arr[i];
                arr[i]=arr[j];
                arr[j]=aux;
            }
        }
        arr[izq]=arr[j];
        arr[j]=pivote;
        if(izq < j-1)
            quickSort(arr,izq,j-1, c);
        if(j+1 < der)
            quickSort(arr,j+1,der, c);
    }

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int izq = 0;
        int der = arr.length - 1;
        System.out.println("Obvio que me esta llamando");
        quickSort(arr, izq, der, c);
    }
    public void prueba(){System.out.println("Funciona");}
}

