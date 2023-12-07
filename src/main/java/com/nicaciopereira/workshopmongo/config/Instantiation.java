package com.nicaciopereira.workshopmongo.config;

import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User maria = new User(null, "Maria ", "maria@gmail.com");
        User nala = new User(null, "nala", "alex@gmail.com");
        User nicacio = new User(null, "nicacio", "nicacio@gmail.com");

         userRepository.saveAll(Arrays.asList(maria,nala,nicacio));
    }
}
