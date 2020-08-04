package com.minhaRedeSocial.Minha.rede.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaRedeSocial.Minha.rede.social.model.Tema;
import com.minhaRedeSocial.Minha.rede.social.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	public List<Tema> findAllByNomeContainingIgnoreCase(String nome);
	
}
