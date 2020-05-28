package br.com.marcoscalicy.controller;

import br.com.marcoscalicy.operacoes.OperacoesMatematicas;
import br.com.marcoscalicy.util.MetodosUteis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private OperacoesMatematicas operacoes;
    private MetodosUteis uteis;

    @Autowired
    public MathController(OperacoesMatematicas operacoes, MetodosUteis uteis) {
        this.operacoes = operacoes;
        this.uteis = uteis;
    }

    @RequestMapping(value="/soma/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double soma(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        uteis.validateIsNumeric(numberOne, numberTwo);
        return operacoes.somar(numberOne, numberTwo);
    }

    @RequestMapping(value="/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        uteis.validateIsNumeric(numberOne, numberTwo);
        return operacoes.subtrair(numberOne, numberTwo);
    }

    @RequestMapping(value="/divisao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divisao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)  {
        uteis.validateIsNumeric(numberOne, numberTwo);
        return operacoes.dividir(numberOne, numberTwo);
    }

    @RequestMapping(value="/multiplicacao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplicacao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        uteis.validateIsNumeric(numberOne, numberTwo);
        return operacoes.multiplicar(numberOne, numberTwo);
    }

    @RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        uteis.validateIsNumeric(numberOne, numberTwo);
        return operacoes.media(numberOne, numberTwo);
    }

    @RequestMapping(value="/raizquadrada/{numberOne}", method = RequestMethod.GET)
    public Double raizquadrada(@PathVariable("numberOne") String numberOne) {
        uteis.validateIsNumeric(numberOne);
        return operacoes.raizQuadrada(numberOne);
    }

}
