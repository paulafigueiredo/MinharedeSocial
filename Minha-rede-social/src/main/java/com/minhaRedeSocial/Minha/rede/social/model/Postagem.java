package com.minhaRedeSocial.Minha.rede.social.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name= "tb_postagem") //criando a tabela Postagem n banco de dados
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // chave primaria
	private long id;
	
	@NotNull
	@Size(min= 5 , max=100) // o numero de caracteres que tera a descricao
	private String descricao;
	
	private int likes;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem") //relacionando tabelas, varias postagens para um tema.
	public Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem") //relacionando tabelas, varias postagens para um usuario.
	public Usuario usuario;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
