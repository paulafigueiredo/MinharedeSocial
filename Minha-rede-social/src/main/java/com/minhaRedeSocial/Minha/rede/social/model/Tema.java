package com.minhaRedeSocial.Minha.rede.social.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_tema") // criando a tabela tema no banco de dados
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // chave primaria
	private long id;
	
	@NotNull
	@Size(min= 5 , max = 100) // o numero de caracteres que tera a descricao
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;   //relacionando as tabelas, um pra muitos, um tema para muitas postagens

	
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

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
}
