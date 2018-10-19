package controllers;

import java.util.List;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

public class Organizacoes extends Controller {

    public static void getOrganizacao(int id_organizacao){
        try {
            Organizacao organizacao = (Organizacao) JPA.em().createNativeQuery("SELECT * from Organizacao o WHERE o.id = " + id_organizacao, Organizacao.class).getSingleResult();
            renderJSON(organizacao);
        }catch (Exception e){
            Mensagem m = new Mensagem("NÃO FOI POSSÍVEL ENCONTRAR ESSA ORGANIZAÇÃO");
            renderJSON(m);
        }
    }

    public static void postOrganizacao(String body){
        String parts[] = body.split("%");

        Organizacao org = new Organizacao(parts[0], parts[1], parts[2], parts[3],parts[4],parts[5]);
        org.save();

        Mensagem m = new Mensagem("ORGANIZACAO CADASTRADO COM SUCESSO");
        renderJSON(m);
    }

}
