package br.com.marcoscalicy.operacoes;

import br.com.marcoscalicy.util.MetodosUteis;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperacoesMatematicas {

    private MetodosUteis util;

    public double somar(String numberOne, String numberTwo) {
        return util.converToDouble(numberOne) + util.converToDouble(numberTwo);
    }

    public double subtrair(String numberOne, String numberTwo) {
        return util.converToDouble(numberOne) - util.converToDouble(numberTwo);
    }

    public double dividir(String numberOne, String numberTwo) {
        return util.converToDouble(numberOne) / util.converToDouble(numberTwo);
    }

    public double multiplicar(String numberOne, String numberTwo) {
        return util.converToDouble(numberOne) * util.converToDouble(numberTwo);
    }

    public double media(String numberOne, String numberTwo) {
        return (somar(numberOne, numberTwo)) / 2;
    }

    public Double raizQuadrada(String numberOne) {
        int i = (int)(Double.parseDouble(numberOne));
        return Math.sqrt(i);
    }

}
