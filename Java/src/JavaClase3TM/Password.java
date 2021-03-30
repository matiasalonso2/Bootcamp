package JavaClase3TM;

import java.util.regex.Pattern;

public class Password {

    protected String regex;
    protected String value;

    public Password(String regex) {
        this.regex = regex;
    }

    public void setValue(String pwd) throws Exception {
        if (Pattern.matches(regex,pwd))
                value = pwd;
        else
            throw new Exception();

    }
}
