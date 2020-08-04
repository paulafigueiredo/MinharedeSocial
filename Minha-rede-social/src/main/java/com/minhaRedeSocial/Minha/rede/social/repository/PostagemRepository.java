package com.minhaRedeSocial.Minha.rede.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaRedeSocial.Minha.rede.social.model.Postagem;


public interface PostagemRepository extends JpaRepository<Postagem,Long> {

	public List<Postagem> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	
}
