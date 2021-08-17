package com.herokuapp.staging.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.herokuapp.staging.userinterfaces.HomePage.OPT_CALCULADORA_PAGO_VIVIENDA;
import static com.herokuapp.staging.userinterfaces.HomePage.OPT_RECURSOS;

public class IngresoCalculadora implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OPT_RECURSOS),
                Click.on(OPT_CALCULADORA_PAGO_VIVIENDA)
        );
    }

    public static IngresoCalculadora creditoHipotecario() {
        return Tasks.instrumented(IngresoCalculadora.class);
    }
}
