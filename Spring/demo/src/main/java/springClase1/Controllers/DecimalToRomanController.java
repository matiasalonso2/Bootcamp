package springClase1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springClase1.Entities.RomanNumber;

@RestController
public class DecimalToRomanController {

    @GetMapping(path="DecimalToRoman/{number}")
    public RomanNumber Convert(@PathVariable String number){
        return RomanNumber.convertir(number);

    }

}
