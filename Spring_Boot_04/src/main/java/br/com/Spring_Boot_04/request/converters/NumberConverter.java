package br.com.Spring_Boot_04.request.converters;

public class NumberConverter {
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
}
