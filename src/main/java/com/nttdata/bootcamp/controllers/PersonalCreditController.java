package com.nttdata.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.models.PersonalCredit;
import com.nttdata.bootcamp.services.IPersonalCreditService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/personalCredit")
public class PersonalCreditController {
	
	@Autowired
	private IPersonalCreditService pcrepo;
	
	@GetMapping("/findAll")
	public Flux<PersonalCredit> findAll(){
		log.info("all PersonalCredit were consulted");
		return pcrepo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Mono<PersonalCredit> findById(@PathVariable String id){
		log.info("a PersonalCredit was consulted by id");
		return pcrepo.findById(id);
	}
	
	@PutMapping("/update")
	public Mono<PersonalCredit> update(@RequestBody PersonalCredit personalCredit){
		return pcrepo.findById(personalCredit.getId()).flatMap(c->{
			c.setAccountingBalance(personalCredit.getAccountingBalance());
			log.info("a PersonalCredit was updated");
			return Mono.just(c);
		});
	}
	
	@PostMapping("/save")
	public Mono<PersonalCredit> save(@RequestBody PersonalCredit personalCredit){
		log.info("a PersonalCredit was created");
		return pcrepo.save(personalCredit);
	}
	
	@DeleteMapping("/delete")
	public Mono<Void> delete(@RequestBody PersonalCredit personalCredit){
		log.info("a PersonalCredit was deleted");
		return pcrepo.delete(personalCredit);
	}

}
