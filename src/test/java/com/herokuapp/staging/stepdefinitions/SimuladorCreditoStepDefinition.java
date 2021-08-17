package com.herokuapp.staging.stepdefinitions;

import com.herokuapp.staging.models.Simulador;
import com.herokuapp.staging.questions.ValorCuota;
import com.herokuapp.staging.tasks.front.IngresoCalculadora;
import com.herokuapp.staging.tasks.front.IngresoPaginaInicial;
import com.herokuapp.staging.tasks.front.SimularCredito;
import com.herokuapp.staging.userinterfaces.HomePage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static com.herokuapp.staging.models.builders.SimuladorBuilder.conDatos;
import static com.herokuapp.staging.stepdefinitions.Hooks.driver;
import static com.herokuapp.staging.utils.Constantes.CUOTA_MENSUAL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class SimuladorCreditoStepDefinition {

    @Dado("que el usuario ingresó al simulador de pago de vivienda de la haus {string}")
    public void que_el_usuario_ingresó_al_simulador_de_pago_de_vivienda_de_la_haus(String pais) {
        theActorInTheSpotlight().can(BrowseTheWeb.with(driver)).wasAbleTo(
                Open.browserOn(new HomePage()),
                IngresoPaginaInicial.laHaus(pais),
                IngresoCalculadora.creditoHipotecario());
    }

    @Cuando("el simula el valor de un crédito, con los datos:")
    public void el_simula_el_valor_de_un_crédito_con_los_datos(List<Simulador> datos) {

        theActorInTheSpotlight().wasAbleTo(SimularCredito.hipotecario(
                conDatos()
                        .valorPropiedad(datos.get(0).getValorPropiedad())
                        .valorCredito(datos.get(0).getValorCredito())
                        .plazo(datos.get(0).getPlazo())
                        .tasa(datos.get(0).getTasa()), driver));
    }

    @Entonces("el debería ver el valor de su cuota")
    public void el_debería_ver_el_valor_de_su_cuota() {
        String valorEsperado = theActorInTheSpotlight().recall(CUOTA_MENSUAL);
        theActorInTheSpotlight().should(seeThat(ValorCuota.vivienda(), equalTo(valorEsperado)));

    }
}
