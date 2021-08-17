package com.herokuapp.staging.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.herokuapp.staging.userinterfaces.ResultadoSimulacionPage.LBL_VALOR_CREDITO;
import static com.herokuapp.staging.utils.Constantes.FOMATO_REMOVER_CARACTERES;

public class ValorCuota implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
       return LBL_VALOR_CREDITO.resolveFor(actor).getText().replaceAll(FOMATO_REMOVER_CARACTERES, "");
    }

    public static ValorCuota vivienda() {
        return new ValorCuota();
    }
}
