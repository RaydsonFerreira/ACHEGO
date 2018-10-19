package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;;

@Entity
public class Evento extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_id_org",nullable=false)
    public Organizacao organizacao;

    public String data;
    public String local;
    public String descricao;
    public String hora;

    public Evento(Organizacao organizacao, String data, String local, String descricao, String hora) {
        this.organizacao = organizacao;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
        this.hora = hora;
    }
}
