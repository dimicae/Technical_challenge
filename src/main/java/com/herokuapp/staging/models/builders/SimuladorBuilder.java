package com.herokuapp.staging.models.builders;

import com.herokuapp.staging.models.Simulador;
import com.herokuapp.staging.utils.Builder;

public class SimuladorBuilder implements Builder<Simulador> {

    private String valorPropiedad;
    private String valorCredito;
    private String plazo;
    private String tasa;

    public SimuladorBuilder() {
        this.valorPropiedad = "";
        this.valorCredito = "";
        this.plazo = "";
        this.tasa = "";
    }

    public static SimuladorBuilder conDatos() {
        return new SimuladorBuilder();
    }

    public SimuladorBuilder valorPropiedad(String valorPropiedad) {
        this.valorPropiedad = valorPropiedad;
        return this;
    }

    public SimuladorBuilder valorCredito(String valorCredito) {
        this.valorCredito = valorCredito;
        return this;
    }

    public SimuladorBuilder plazo(String plazo) {
        this.plazo = plazo;
        return this;
    }

    public SimuladorBuilder tasa(String tasa) {
        this.tasa = tasa;
        return this;
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

    @Override
    public Simulador build() {
        return new Simulador(this);
    }
}
