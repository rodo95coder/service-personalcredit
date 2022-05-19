package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.PersonalCredit;

public interface IPersonalCreditRepo extends ReactiveMongoRepository<PersonalCredit, String> {

}
