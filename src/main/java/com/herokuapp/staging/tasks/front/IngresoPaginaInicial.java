package com.herokuapp.staging.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.herokuapp.staging.userinterfaces.HomePage.BTN_SELECCIONAR_PAISES;

public class IngresoPaginaInicial implements Task {

    private final String pais;

    public IngresoPaginaInicial(String pais) {
        this.pais = pais;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_SELECCIONAR_PAISES.of(pais)));
    }

    public static IngresoPaginaInicial laHaus(String pais) {
        return Tasks.instrumented(IngresoPaginaInicial.class, pais);
    }


}
