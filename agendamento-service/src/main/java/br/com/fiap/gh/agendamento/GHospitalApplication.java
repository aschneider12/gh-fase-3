package br.com.fiap.gh.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.gh"})
@EntityScan(basePackages = {"br.com.fiap.gh.jpa.entities"})
@EnableJpaRepositories(basePackages = {"br.com.fiap.gh.jpa.repositories"})
public class GHospitalApplication {

	public static void main(String[] args) {
		System.out.println("Starting GHospital Application...");
		SpringApplication.run(GHospitalApplication.class, args);
	}
}