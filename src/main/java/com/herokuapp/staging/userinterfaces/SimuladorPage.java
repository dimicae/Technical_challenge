package com.herokuapp.staging.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SimuladorPage {

    public static final Target TXT_VALOR_PROPIEDAD = Target.the("Campo ingresar el valor de la propiedad").located(By.id("propertyValue"));
    public static final Target TXT_VALOR_PRESTAMO = Target.the("Campo ingresar ¿Cuánto necesitas que te presten?").located(By.id("loan"));
    public static final Target BTN_PLAZO = Target.the("Seleccionar el plazo del crèdito").locatedBy("//button[contains(text(),' {0}')]");
    public static final Target SLIDE_TASA = Target.the("Selecciona la tasa del crèdito").locatedBy("//section[@class='mt-lh-48']//div//input");
    public static final Target LBL_TASA_ACTUAL = Target.the("Captura el valor actual de la tasa").locatedBy("//section[@class='mt-lh-48']//div//span[@class='range-value absolute rounded-sm py-lh-8 px-lh-12 text-lh-sky-blue text-14']");
    public static final Target BTN_SIMULAR = Target.the("Bòton simular").locatedBy("//Section//a[contains(text(),'Simular')]");

}
