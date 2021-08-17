package com.herokuapp.staging.tasks.front;

import com.herokuapp.staging.interactions.Desliza;
import com.herokuapp.staging.interactions.Espera;
import com.herokuapp.staging.interactions.Limpiar;
import com.herokuapp.staging.models.Simulador;
import com.herokuapp.staging.models.builders.SimuladorBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.WebDriver;

import static com.herokuapp.staging.userinterfaces.SimuladorPage.*;
import static com.herokuapp.staging.utils.Constantes.CUOTA_MENSUAL;
import static com.herokuapp.staging.utils.Constantes.ESPERA_2000;
import static com.herokuapp.staging.utils.Utilidades.cuotaCredito;

public class SimularCredito implements Task {

    private final WebDriver driver;
    private final String valorPropiedad;
    private final String valorCredito;
    private final String plazo;
    private final String tasa;

    public SimularCredito(Simulador simulador, WebDriver driver) {
        this.valorPropiedad = simulador.getValorPropiedad();
        this.valorCredito = simulador.getValorCredito();
        this.plazo = simulador.getPlazo();
        this.tasa = simulador.getTasa();
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Limpiar.campo(TXT_VALOR_PROPIEDAD),
                Enter.theValue(valorPropiedad).into(TXT_VALOR_PROPIEDAD),
                Limpiar.campo(TXT_VALOR_PRESTAMO),
                Enter.theValue(valorCredito).into(TXT_VALOR_PRESTAMO),
                Espera.tiempo(ESPERA_2000),
                Click.on(BTN_PLAZO.of(plazo)),
                Desliza.elemento(driver, SLIDE_TASA, LBL_TASA_ACTUAL, tasa),
                Click.on(BTN_SIMULAR));

        actor.remember(CUOTA_MENSUAL, cuotaCredito(valorCredito, plazo, tasa));
    }

    public static SimularCredito hipotecario(SimuladorBuilder simulador, WebDriver driver) {
        return Tasks.instrumented(SimularCredito.class, simulador.build(), driver);
    }
}
