package com.example.SpringDataJPA;

import com.example.SpringDataJPA.models.User;
import com.example.SpringDataJPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("daniel");
        user.setUserName("Nascimento Tomaz");
        user.setPassword("quengo500");

        //Salvando um usuario
        userRepository.save(user);

        // restona uma lista do banco de dado
        for (User u :userRepository.findAll()){
            System.out.println(u);
        }




    }
}
