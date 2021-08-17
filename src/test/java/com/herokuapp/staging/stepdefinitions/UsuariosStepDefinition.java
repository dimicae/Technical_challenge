package com.herokuapp.staging.stepdefinitions;

import com.herokuapp.staging.questions.NuevoUsuario;
import com.herokuapp.staging.tasks.back.CreacionUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.herokuapp.staging.models.builders.UsuarioBuilder.conDatos;
import static com.herokuapp.staging.utils.Constantes.USUARIO_END_POINT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class UsuariosStepDefinition {

    @Dado("que el usuario consume el servicio")
    public void llamarApiUsuarios() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(USUARIO_END_POINT));
    }

    @Cuando("se crea un nuevo usuario con nombre {string} y con el rol {string}")
    public void crearUsuario(String nombre, String rol) {
        theActorInTheSpotlight().attemptsTo(CreacionUsuario
                .nuevo(conDatos().nombre(nombre).rol(rol)));
    }
    @Entonces("el usuario quedar· creado exitosamente")
    public void elUsuarioQuedar·CreadoExitosamente() {
        String valorEsperadoNombre = theActorInTheSpotlight().recall("nombre");
        theActorInTheSpotlight().should(
                seeThat(NuevoUsuario.validarCreacion(), equalTo(valorEsperadoNombre)));
    }
}
