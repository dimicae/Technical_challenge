package com.herokuapp.staging.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static com.herokuapp.staging.utils.Constantes.URL_LA_HAUS;

@DefaultUrl(URL_LA_HAUS)
public class HomePage extends PageObject {
    public static final Target BTN_SELECCIONAR_PAISES = Target.the("Selecciona el pais").locatedBy("//div[text()='{0}']");
    public static final Target OPT_RECURSOS = Target.the("Opciòn recursos").located(By.id("dropdown-2"));
    public static final Target OPT_CALCULADORA_PAGO_VIVIENDA = Target.the("Opciòn calculadora de pago de viivenda").locatedBy("//div[@class='credit-guide col-span-4']/a");
}
