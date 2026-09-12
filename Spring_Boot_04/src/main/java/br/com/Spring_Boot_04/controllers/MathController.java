package br.com.Spring_Boot_04.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sun
    (       @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo  ) throws Exception {


        if(isNumeber(numberOne) || isNumeber(numberTwo)) throw new IllegalArgumentException();
        return convertToDouble(numberOne)+convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber==null || strNumber.isEmpty()) throw new IllegalArgumentException();
        String number = strNumber.replace(",", ".");
        return  Double.parseDouble(number);
    }

    private boolean isNumeber(String strNumber) {
        boolean valida;
        String number;

        if(strNumber==null || strNumber.isEmpty()){
            return false;
        }else {
            number = strNumber.replace(",", ".");
            //String number = strnumber.replace(",", "."); add automaticamnete o target
            //return number.matches("[-+]?[0-9]*\\.[0-9]+");
            return valida = number.matches("[-+]?[0-9]*\\.[0-9]+");
        }




    }


    //http://localhost:8080/math/division/3/5
    //http://localhost:8080/math/sub/3/5
    //http://localhost:8080/math/mult/3/5
}
