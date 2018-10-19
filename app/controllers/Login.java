package controllers;

import java.util.List;
import java.util.ArrayList;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;


public class Login extends Controller {

    public static void login(String body){

        Mensagem m;

        String[] parts = body.split("%");
        String email = parts[0];
        String senha = parts[1];

        try {
            Object user = JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.email = '" + email + "' AND u.senha = '" + senha + "'", Usuario.class).getSingleResult();
            try{
                Object org = JPA.em().createNativeQuery("SELECT * from Organizacao o WHERE o.email = '" + email + "' AND o.senha = '" + senha + "'", Organizacao.class).getSingleResult();
                m = new Mensagem("DUAS CONTAS ENCONTRADAS");
                renderJSON(m);

            } catch (Exception e){
                renderJSON(user);
            }

        }catch (Exception e){
            try{
                Object org = JPA.em().createNativeQuery("SELECT * from Organizacao o WHERE o.email = '" + email + "' AND o.senha = '" + senha + "'", Organizacao.class).getSingleResult();

                renderJSON(org);
            }catch (Exception e1){
                m = new Mensagem("LOGIN INVÁLIDO");
            }

            m = new Mensagem("LOGIN INVÁLIDO");
            renderJSON(m);
        }


    }

    public static void loginUser(String body) {

        String[] parts = body.split("%");
        String email = parts[0];
        String senha = parts[1];

        Usuario user = (Usuario)JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.email = " + email + "AND u.senha = " + senha, Usuario.class).getSingleResult();
        renderJSON(user);
    }

    public static void loginOrg(String body) {

        String[] parts = body.split("%");
        String email = parts[0];
        String senha = parts[1];

        Organizacao organizacao = (Organizacao)JPA.em().createNativeQuery("SELECT * from Organizacao o WHERE o.email = " + email + "AND o.senha = " + senha, Organizacao.class).getSingleResult();
        renderJSON(organizacao);
    }
}
