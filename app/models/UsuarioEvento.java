package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class UsuarioEvento extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_usuario",nullable=false)
    public Usuario usuario;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_evento",nullable=false)
    public Evento evento;

    public UsuarioEvento(Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
    }
}
