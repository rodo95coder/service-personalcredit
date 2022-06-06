package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.PersonalCredit;

import reactor.core.publisher.Mono;

public interface IPersonalCreditRepo extends ReactiveMongoRepository<PersonalCredit, String> {

	public Mono<PersonalCredit> findByIdCustomerPerson(String idCustomerPerson);

}