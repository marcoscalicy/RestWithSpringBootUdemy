package br.com.marcoscalicy.util;

import br.com.marcoscalicy.exception.ExceptionOperadorNaoSuportado;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetodosUteis {

    public Double converToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public void validateIsNumeric(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ExceptionOperadorNaoSuportado("Por favor defina um valor numérico!");
        }
    }

    public void validateIsNumeric(String numberOne) {
        if (!isNumeric(numberOne)) {
            throw new ExceptionOperadorNaoSuportado("Por favor defina um valor numérico!");
        }
    }

}
