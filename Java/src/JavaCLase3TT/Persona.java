package JavaCLase3TT;

public class Persona implements Precedable<Persona> {
    private String name;
    private String dni;

    public Persona(String name, String dni) {
        this.name = name;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //Devuelve true si la persona instanciada precede a la persona pasada por parámetro
    //Compara números de dni
    @Override
    public boolean precedeA(Persona persona) {
        return (Integer.parseInt(dni)<Integer.parseInt(persona.getDni()));
    }
}
