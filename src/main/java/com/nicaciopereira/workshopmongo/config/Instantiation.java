package com.nicaciopereira.workshopmongo.config;

import com.nicaciopereira.workshopmongo.domain.Post;
import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.dto.AutorDto;
import com.nicaciopereira.workshopmongo.repositories.PostRepositories;
import com.nicaciopereira.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PostRepositories postRepositories;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepositories.deleteAll();

        User maria = new User(null, "Maria ", "maria@gmail.com");
        User nala = new User(null, "nala", "alex@gmail.com");
        User nicacio = new User(null, "nicacio", "nicacio@gmail.com");


        userRepository.saveAll(Arrays.asList(maria,nala,nicacio));
        Post post1 = new Post(null,sdf.parse("11/12/2023") , "APRENDENDO PROGRAMAR" , "APRENDENDO UM ABRAÇO" ,new AutorDto(maria));
        Post post2 = new Post(null,sdf.parse("11/12/2023") , "BOA NOITE " , "BOA NOITE DE ESTUDOS" , new AutorDto(maria));

         postRepositories.saveAll(Arrays.asList(post1,post2));

         maria.getPosts().addAll(Arrays.asList(post1 , post2));
         userRepository.save(maria);

    }
}
