package RadixSort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        int arr[]={2,3,106,2,2,12,1,12313,23,45,673};
        radixSort(arr);

        System.out.println();
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }


    public static void radixSort(int[] arr)
    {
        String[] arrStr = StringUtil.toStringArray(arr);
        int maxLength = StringUtil.maxLength(arrStr);

        for (int i=0; i< arr.length; i++)
            arrStr[i] = String.format("%0"+maxLength+"d", arr[i]);

        ArrayList<ArrayList<String>> listas = new ArrayList<>();

        ArrayList<String> L0 = new ArrayList<>(); listas.add(L0);
        ArrayList<String> L1 = new ArrayList<>(); listas.add(L1);
        ArrayList<String> L2 = new ArrayList<>(); listas.add(L2);
        ArrayList<String> L3 = new ArrayList<>(); listas.add(L3);
        ArrayList<String> L4 = new ArrayList<>(); listas.add(L4);
        ArrayList<String> L5 = new ArrayList<>(); listas.add(L5);
        ArrayList<String> L6 = new ArrayList<>(); listas.add(L6);
        ArrayList<String> L7 = new ArrayList<>(); listas.add(L7);
        ArrayList<String> L8 = new ArrayList<>(); listas.add(L8);
        ArrayList<String> L9 = new ArrayList<>(); listas.add(L9);

        for (int i= maxLength-1; i>=0; i--){
            for (int j= 0; j< arrStr.length ; j++){
                switch(arrStr[j].charAt(i)) {
                    case '0': L0.add(arrStr[j]);
                        break;
                    case '1': L1.add(arrStr[j]);
                        break;
                    case '2': L2.add(arrStr[j]);
                        break;
                    case '3': L3.add(arrStr[j]);
                        break;
                    case '4': L4.add(arrStr[j]);
                        break;
                    case '5': L5.add(arrStr[j]);
                        break;
                    case '6': L6.add(arrStr[j]);
                        break;
                    case '7': L7.add(arrStr[j]);
                        break;
                    case '8': L8.add(arrStr[j]);
                        break;
                    case '9': L9.add(arrStr[j]);
                        break;
                }
            }
            int count= 0;
            //Recorro las 10 listas y paso los elementos al array de strings
            for (ArrayList<String> lista: listas) {
                for (String palabra: lista) {
                    arrStr[count] = palabra;
                    count++;
                }
            }
            //Vacío las listas
            for (ArrayList<String> lista: listas) {
                lista.clear();
            }

        }
        var arrInt = StringUtil.toIntArray(arrStr);
        for (int i = 0; i<arrInt.length; i++)
            arr[i]= arrInt[i];

    }
}
