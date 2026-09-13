package br.com.Spring_Boot_04.controllers;

import jakarta.websocket.server.PathParam;
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
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedOperationException("Por favor insirar um valor numérico!");
        return convertToDouble(numberOne)+convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber==null || strNumber.isEmpty()) throw new UnsupportedOperationException("please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return  Double.parseDouble(number);
    }

    private boolean isNumber(String strNumber) {
        if(strNumber==null || strNumber.isEmpty()){
            return false;
        }
            String number = strNumber.replace(",", ".");
            //String number = strnumber.replace(",", "."); add automaticamnete o target
            //return number.matches("[-+]?[0-9]*\\.?[0-9]+");
            // Retorna direto a validação do Regex, sem criar variáveis inúteis
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction
    (       @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumber(numberOne) || !isNumber(numberTwo)) throw new UnsupportedOperationException("Por favor inserar um valor numérico!");
        return convertToDouble(numberOne)-convertToDouble(numberTwo);
    }

    //http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOn}/{numberTwo}")
    private double multiplication
    (
            @PathVariable("numberOn") String numberOn,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!isNumber(numberOn) || !isNumber(numberTwo)) throw new UnsupportedOperationException("Por Favor um numero válido!");
        return  convertToDouble(numberOn)*convertToDouble(numberTwo);


    }
    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOn}/{numberTwo}")
    private double division
    (
            @PathVariable("numberOn") String numberOn,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!isNumber(numberOn) || !isNumber(numberTwo)) throw new UnsupportedOperationException("Por Favor um numero válido!");
        return  convertToDouble(numberOn) / convertToDouble(numberTwo);


    }


    //http://localhost:8080/math/media/3/5
    @RequestMapping("/media/{numberOn}/{numberTwo}")
    private double media
    (
            @PathVariable("numberOn") String numberOn,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!isNumber(numberOn) || !isNumber(numberTwo)) throw new UnsupportedOperationException("Por Favor um numero válido!");
        return  (convertToDouble(numberOn) + convertToDouble(numberTwo))/2;


    }


    //http://localhost:8080/math/sqrt/3
    @RequestMapping("/sqrt/{numberOn}")
    private double squareRoot
    (
            @PathVariable("numberOn") String numberOn

    )throws Exception{
        if(!isNumber(numberOn)) throw new UnsupportedOperationException("Por Favor um numero válido!");
        return  Math.sqrt(convertToDouble(numberOn));


    }

}
