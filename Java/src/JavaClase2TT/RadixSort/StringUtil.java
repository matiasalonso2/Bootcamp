package RadixSort;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        return "";
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"

    public static String lpad(String s, int n, char c)
    {
        return "";
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres

    public static String[] toStringArray(int arr[])
    {
        String [] output = new String[arr.length];
        for (int i=0; i<arr.length; i++)
            output[i] = Integer.toString(arr[i]);
        return output;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres

    public static int[] toIntArray(String arr[])
    {
        int [] output = new int[arr.length];
        for (int i=0; i<arr.length; i++)
            output[i] = Integer.parseInt(arr[i]);
        return output;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr


    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
    }

    public static int maxLength(String arr[])
    {
        int max = 0;
        for (String i:
                arr) {
            max = (i.length() > max) ? i.length() : max;
        }
        return max;
    }

}


