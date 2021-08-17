package com.herokuapp.staging.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Espera implements Task {

    private int tiempoMilisegundos;

    public Espera(int tiempoMilisegundos) {
        this.tiempoMilisegundos = tiempoMilisegundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        new InternalSystemClock().pauseFor(tiempoMilisegundos);
    }

    public static Espera tiempo(int tiempoMilisegundos) {
        return Tasks.instrumented(Espera.class, tiempoMilisegundos);
    }
}
