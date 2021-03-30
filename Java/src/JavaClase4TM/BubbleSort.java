package JavaClase4TM;

import JavaCLase3TT.Precedable;

public class BubbleSort implements Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int n = arr.length;
        T temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++)
                if (
                        arr[j].precedeA((T) arr[j - 1])) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
        }
    }
}
