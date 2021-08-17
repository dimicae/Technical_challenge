package com.herokuapp.staging.models.builders;

import com.herokuapp.staging.utils.Builder;
import com.herokuapp.staging.utils.pojos.Usuario;

public class UsuarioBuilder implements Builder<Usuario> {

    private String name;
    private String job;

    public UsuarioBuilder() {
        this.name = "";
        this.job = "";
    }

    public static UsuarioBuilder conDatos() {
        return new UsuarioBuilder();
    }

    public UsuarioBuilder nombre(String name) {
        this.name = name;
        return this;
    }

    public UsuarioBuilder rol(String job) {
        this.job = job;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    @Override
    public Usuario build() {
        return new Usuario(this);
    }
}
