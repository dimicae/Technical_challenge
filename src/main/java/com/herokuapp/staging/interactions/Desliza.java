package com.herokuapp.staging.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ARROW_UP;

public class Desliza implements Interaction {

    private WebDriver driver;
    private Target slide;
    private Target porcentajeActual;
    private int porcentaje;

    public Desliza(WebDriver driver, Target slide, Target porcentajeActual, String porcentaje) {
        this.driver = driver;
        this.slide = slide;
        this.porcentajeActual = porcentajeActual;
        this.porcentaje = Integer.parseInt(porcentaje);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int valor;
        Actions accion = new Actions(driver);

        actor.attemptsTo(Click.on(slide));
        int valorActualSlide = Integer.parseInt(porcentajeActual.resolveFor(actor).getText().replace("%", ""));

        if (porcentaje > valorActualSlide) {
            valor = porcentaje - valorActualSlide;
            for (int i = 0; i < valor; i++) {
                accion.sendKeys(ARROW_UP).perform();
            }
        } else if (porcentaje < valorActualSlide) {
            valor = valorActualSlide - porcentaje;
            for (int i = 0; i < valor; i++) {
                accion.sendKeys(ARROW_DOWN).perform();
            }
        }
    }

    public static Desliza elemento(WebDriver driver, Target slide, Target porcentajeActual, String porcentaje) {
        return Tasks.instrumented(Desliza.class, driver, slide, porcentajeActual, porcentaje);
    }
}
