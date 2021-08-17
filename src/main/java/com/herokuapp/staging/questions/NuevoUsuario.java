package com.herokuapp.staging.questions;

import com.herokuapp.staging.utils.pojos.CrearUsuarioResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.herokuapp.staging.utils.Constantes.CODIGO_201;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class NuevoUsuario implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().statusCode() == CODIGO_201
                ? lastResponse().getBody().as(CrearUsuarioResponse.class).getName()
                : null;
    }

    public static NuevoUsuario validarCreacion() {
        return new NuevoUsuario();
    }
}
