package com.herokuapp.staging.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static com.herokuapp.staging.utils.Constantes.NOMBRE_ACTOR;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class Hooks {

    @Managed(driver = "chrome")
    public static WebDriver driver;

    @Before
    public void configurarEscenario() {
        setTheStage(new OnlineCast());
        theActor(NOMBRE_ACTOR);
    }
}
