package com.herokuapp.staging.models;

import com.herokuapp.staging.models.builders.SimuladorBuilder;

public class Simulador {

    private String valorPropiedad;
    private String valorCredito;
    private String plazo;
    private String tasa;

    public Simulador() {
    }

    public Simulador(SimuladorBuilder simuladorBuilder) {
        this.valorPropiedad = simuladorBuilder.getValorPropiedad();
        this.valorCredito = simuladorBuilder.getValorCredito();
        this.plazo = simuladorBuilder.getPlazo();
        this.tasa = simuladorBuilder.getTasa();
    }

    public String getValorPropiedad() {
        return valorPropiedad;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public String getPlazo() {
        return plazo;
    }

    public String getTasa() {
        return tasa;
    }
}
