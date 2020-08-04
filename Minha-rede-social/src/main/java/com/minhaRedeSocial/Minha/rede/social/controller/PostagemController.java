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

import com.minhaRedeSocial.Minha.rede.social.model.Postagem;

import com.minhaRedeSocial.Minha.rede.social.repository.PostagemRepository;

@RestController // avisando que e uma classe controller
@RequestMapping("/postagem")// avisando que as alteraçoes seram feitas nesse nome
@CrossOrigin("*") // Qnd vier do front nao importa de onde venha ele aceita a requisicao
public class PostagemController {

	@Autowired
	public PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>>GetAll(){
		return ResponseEntity.ok(repository.findAll());    //trazendo todos as postagens dentro d banco de dados.
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){  //trazendo uma postagem com ID
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){    //criando uma nova postagem no banco de dados
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem)); 
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){ //atualizando os dados da postagem
		return ResponseEntity.ok(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id){   //deletando uma postagem do banco de dados
		repository.deleteById(id);
	}
	
	
}
