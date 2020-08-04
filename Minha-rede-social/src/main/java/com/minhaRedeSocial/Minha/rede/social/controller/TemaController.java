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

import com.minhaRedeSocial.Minha.rede.social.model.Tema;
import com.minhaRedeSocial.Minha.rede.social.repository.TemaRepository;

@RestController    // informa para o spring que essa classe se trata de um controlador
@RequestMapping("/tema")// avisando que as alteraçoes seram feitas nesse nome
@CrossOrigin("*") //Qundo vier do front end,independente de onde veem ela aceita qlq origem de requisiçao
public class TemaController {
	
	@Autowired
	private TemaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Tema>>GetAll(){
		return ResponseEntity.ok(repository.findAll());    //trazendo todos os temas.
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable long id){  //trazendo um unico tema por id
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema){    //criando um novo tema no banco de dados
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema)); 
	}
	
	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema){ //atualizando os dados do tema
		return ResponseEntity.ok(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id){   //deletando um tema do banco de dados
		repository.deleteById(id);
	}
		
}
