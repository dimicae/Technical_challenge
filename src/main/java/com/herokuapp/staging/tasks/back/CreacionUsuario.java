package com.herokuapp.staging.tasks.back;

import com.herokuapp.staging.models.builders.UsuarioBuilder;
import com.herokuapp.staging.utils.pojos.Usuario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.herokuapp.staging.utils.Constantes.*;

public class CreacionUsuario implements Task {

    private final Usuario usuario;

    public CreacionUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(RECURSO_CREAR_USUARIO)
                .with(resquest -> resquest.contentType(APLICACION)
                        .body(usuario)
                        .relaxedHTTPSValidation()
                        .urlEncodingEnabled(false)));

        actor.remember(NOMBRE, usuario.getName());
    }

    public static CreacionUsuario nuevo(UsuarioBuilder usuarioBuilder) {
        return Tasks.instrumented(CreacionUsuario.class, usuarioBuilder.build());
    }
}
