package br.com.projetorest.api.config;

import br.com.projetorest.api.domain.User;
import br.com.projetorest.api.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void startDB() {
        User u1 = new User(null, "Valdir", "valdir@mail.com", "123");
        User u2 = new User(null, "Luiz", "luiz@mail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
