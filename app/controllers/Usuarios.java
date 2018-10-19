package controllers;

import java.util.List;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

public class Usuarios extends Controller {

    public static void getUsuario(int id_usuario){
        Usuario user = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id = " + id_usuario, Usuario.class).getSingleResult();
        renderJSON(user);
    }

    public static void postUsuario(String body){
        String parts[] = body.split("%");

        Usuario user = new Usuario(parts[0],parts[1],parts[2], parts[3]);
        user.save();

        Mensagem m = new Mensagem("USUARIO CADASTRADO COM SUCESSO");
        renderJSON(m);
    }

}
