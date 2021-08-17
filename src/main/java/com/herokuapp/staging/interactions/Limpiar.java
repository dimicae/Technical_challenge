package com.herokuapp.staging.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;


public class Limpiar implements Interaction {

    private Target target;

    public Limpiar(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(DoubleClick.on(target).then(Hit.the(Keys.BACK_SPACE).into(target)));
    }

    public static Limpiar campo(Target target){
        return Tasks.instrumented(Limpiar.class, target);
    }
}
