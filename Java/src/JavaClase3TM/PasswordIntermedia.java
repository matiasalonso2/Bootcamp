package JavaClase3TM;

public class PasswordIntermedia extends Password {

    public PasswordIntermedia() {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}
