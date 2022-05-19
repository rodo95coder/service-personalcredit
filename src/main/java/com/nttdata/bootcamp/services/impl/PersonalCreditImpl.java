package com.nttdata.bootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.models.PersonalCredit;
import com.nttdata.bootcamp.repositories.IPersonalCreditRepo;
import com.nttdata.bootcamp.services.IPersonalCreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonalCreditImpl implements IPersonalCreditService {
	
	@Autowired
	IPersonalCreditRepo pcrepo;

	@Override
	public Flux<PersonalCredit> findAll() {
		return pcrepo.findAll();
	}

	@Override
	public Mono<PersonalCredit> findById(String id) {
		return pcrepo.findById(id);
	}

	@Override
	public Mono<PersonalCredit> save(PersonalCredit personalCredit) {
		return pcrepo.save(personalCredit);
	}

	@Override
	public Mono<Void> delete(PersonalCredit personalCredit) {
		return pcrepo.delete(personalCredit);
	}

}
