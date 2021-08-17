package com.herokuapp.staging.utils;

import static com.herokuapp.staging.utils.Constantes.FORMATO_REMOVER_DECIMALES;

public class Utilidades {

    private Utilidades() { }

    public static String cuotaCredito(String credito, String plazo, String tasa) {

        double valorCredito = Double.parseDouble(credito);
        double plazoMeses = Double.parseDouble(plazo) * 12;
        double tasaMensual = (Double.parseDouble(tasa) / 12) / 100;

        double cuota = valorCredito * (((Math.pow((1 + tasaMensual), plazoMeses)) * tasaMensual)
                / ((Math.pow((1 + tasaMensual), plazoMeses)) - 1));

        return String.format(FORMATO_REMOVER_DECIMALES, cuota);
    }
}
