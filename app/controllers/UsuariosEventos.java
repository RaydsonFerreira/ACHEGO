package controllers;

import java.util.List;

import models.*;
import play.db.jpa.JPA;
import play.mvc.*;

public class UsuariosEventos extends Controller {

    public static void getEventosbyUsuario(int id) {

        List<UsuarioEvento> ues = JPA.em().createNativeQuery("SELECT * from UsuarioEvento u WHERE u.fk_id_usuario = " + id, UsuarioEvento.class).getResultList();
        renderJSON(ues);
    }

    public static void inscreverEmEvento(int id_user, int id_evento){
        try {
            Usuario user = (Usuario) JPA.em().createNativeQuery("SELECT * from Usuario u WHERE u.id = " + id_user, Usuario.class).getSingleResult();

            Evento event = (Evento) JPA.em().createNativeQuery("SELECT * from Evento e WHERE e.id = " + id_evento, Evento.class).getSingleResult();

            UsuarioEvento ue = new UsuarioEvento(user, event);
            ue.save();

            Mensagem mensagem = new Mensagem("USUÁRIO INSCRITO COM SUCESSO");
            renderJSON(mensagem);
        }
        catch (Exception e){
            Mensagem mensagem = new Mensagem("USUÁRIO NÃO PODE SER INSCRITO NO EVENTO");
            renderJSON(mensagem);
        }
    }

}
