package br.com.fiap.gh.historico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.fiap.gh"})
@EntityScan(basePackages = {"br.com.fiap.gh.jpa.entities"})
@EnableJpaRepositories(basePackages = {"br.com.fiap.gh.jpa.repositories"})
public class HistoricoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HistoricoServiceApplication.class, args);
    }
}
