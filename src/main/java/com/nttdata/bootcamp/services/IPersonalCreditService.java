package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.PersonalCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonalCreditService {
	public Flux<PersonalCredit> findAll();
	public Mono<PersonalCredit> findById(String id);
	public Mono<PersonalCredit> save(PersonalCredit personalCredit);
	public Mono<Void> delete(PersonalCredit personalCredit);
}
