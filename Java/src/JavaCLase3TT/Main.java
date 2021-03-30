package JavaCLase3TT;

public class Main {
    public static void main(String[] args)
    {
        Persona[] arr = {new Persona("Matias", "2800"),
                new Persona("Juan", "150"),
                new Persona("Pablo", "34"),
                new Persona("Pedro", "1000")};

        for (Persona p: arr
             ) {
            System.out.print(p.getDni() + ", ");
        }

        System.out.println();
        SortUtil.ordenar(arr);
        for (Persona p: arr
        ) {
            System.out.print(p.getDni() + ", ");
        }
        System.out.println();
        //Probando con celulares

        Celular[] arr2 = {new Celular("12", "Matias"),
                new Celular("12", "Juan"),
                new Celular("12", "Sebastian"),
                new Celular("12", "Agustin")};

        for (Celular cel: arr2
        ) {
            System.out.print(cel.getTitular() + ", ");
        }

        System.out.println();
        SortUtil.ordenar(arr2);
        for (Celular cel: arr2
        ) {
            System.out.print(cel.getTitular() + ", ");
        }

    }
}
