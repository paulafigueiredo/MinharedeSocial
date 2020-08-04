package com.minhaRedeSocial.Minha.rede.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.minhaRedeSocial.Minha.rede.social.model.Usuario;
import com.minhaRedeSocial.Minha.rede.social.repository.UsuarioRepository;

@RestController //avisando que e um controler
@RequestMapping("/usuario")
@CrossOrigin("*") //aceitando do front end de qlq origem

public class UsuarioController {

	
	@Autowired
	public UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>>GetAll(){
		return ResponseEntity.ok(repository.findAll());    //trazendo todos usuarios
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){  //trazendo um unico usuario por id
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){    //criando um novo usuario no banco de dados
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario)); 
	}
	
	@PutMapping
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){ //atualizando os dados de usuario
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id){   //deletando um usuario do banco de dados
		repository.deleteById(id);
	}
	
	
}
