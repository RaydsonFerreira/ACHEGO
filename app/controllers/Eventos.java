package controllers;

//import org.json.JSONObject;
import java.util.List;

import com.google.gson.Gson;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Eventos extends Controller {

    public static void getAllEventos() {
        List<Evento> eventos = JPA.em().createNativeQuery("SELECT * from Evento e", Evento.class).getResultList();
        renderJSON(eventos);
    }

    public static void postEvento(String body){
        String parts[] = body.split("%");

        Organizacao organizacao = (Organizacao) JPA.em().createNativeQuery("SELECT * from Organizacao o WHERE o.id = " + parts[0], Organizacao.class).getSingleResult();

        Evento e = new Evento(organizacao, parts[1], parts[2], parts[3], parts[4]);

        e.save();

        Mensagem m = new Mensagem("EVENTO CADASTRADO COM SUCESSO");
        renderJSON(m);
    }

    public static void getEvento(int id_evento) {
        Evento e = (Evento)JPA.em().createNativeQuery("SELECT * from Evento e WHERE e.id = " + id_evento , Evento.class).getSingleResult();
        renderJSON(e);
    }

    public static void getEventosOrg(int id_org){
        List<Evento> eventos = JPA.em().createNativeQuery("SELECT * from Evento e WHERE e.fk_id_org = " + id_org, Evento.class).getResultList();
        renderJSON(eventos);
    }

}
