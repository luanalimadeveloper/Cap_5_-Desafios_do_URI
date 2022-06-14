package com.devsuperior.uri2603;


import com.devsuperior.uri2603.dto.CustomerDTO;
import com.devsuperior.uri2603.projections.CustomerMinProjection;
import com.devsuperior.uri2603.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2603Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2603Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n ___________  SQL  ___________");
		List<CustomerMinProjection> list = repository.search1("Porto Alegre");
		List<CustomerDTO> result = list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
		
		for(CustomerDTO obj : result){
			System.out.println(obj);
		}

		System.out.println("\n ___________  JPQL  ___________");
		List<CustomerDTO> result2 = repository.search2("Porto Alegre");

		for(CustomerDTO obj : result2){
			System.out.println(obj);
		}

	}

}
