package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Organizacao extends GenericModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String nome;
	public String email;
	public String local;
	public String sobre;
	public String cnpj;
	public String senha;

	public Organizacao(String nome, String email, String local, String sobre, String cnpj, String senha) {
		this.nome = nome;
		this.email = email;
		this.local = local;
		this.sobre = sobre;
		this.cnpj = cnpj;
		this.senha = senha;
	}
}
