package com.herokuapp.staging.utils.pojos;

import com.herokuapp.staging.models.builders.UsuarioBuilder;

public class Usuario {
    private String name;
    private String job;

    public Usuario(UsuarioBuilder usuarioBuilder) {
        this.name = usuarioBuilder.getName();
        this.job = usuarioBuilder.getJob();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
