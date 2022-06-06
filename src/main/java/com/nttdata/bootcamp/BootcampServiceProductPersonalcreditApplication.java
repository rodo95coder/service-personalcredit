package com.nttdata.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.models.PersonalCredit;
import com.nttdata.bootcamp.repositories.IPersonalCreditRepo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@EnableEurekaClient
@Slf4j
@SpringBootApplication
public class BootcampServiceProductPersonalcreditApplication implements CommandLineRunner{

	@Autowired
	IPersonalCreditRepo pcrepo;
	
	@Autowired
	ReactiveMongoTemplate mongoTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BootcampServiceProductPersonalcreditApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("personalcredits").subscribe();
		
		Flux.just(PersonalCredit.builder()
				.idCustomerPerson("b1")
				.accountingBalance("700")
				.availableBalance("100")
				.debt("600")
				.numMovement(0)
				.build()).flatMap(bs->{
						return pcrepo.save(bs);
				}).subscribe(s-> log.info("Se ingreso personalCredit: "+s));
	}

}