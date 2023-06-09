package com.example.demo;


import com.example.demo.entities.Post;
import com.example.demo.entities.Tag;
import com.example.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Post post = new Post("Hibernate Many to Many Mapping Example with Spring Boot",
                "Hibernate Many to Many Mapping Example with Spring Boot",
                "Hibernate Many to Many Mapping Example with Spring Boot");

        Post post1 = new Post("Hibernate One to Many Mapping Example with Spring Boot",
                "Hibernate One to Many Mapping Example with Spring Boot",
                "Hibernate One to Many Mapping Example with Spring Boot");
        Tag springBoot = new Tag("Spring Boot");
        Tag hibernate = new Tag("Hibernate");
        post.getTags().add(springBoot);
        post.getTags().add(hibernate);

        // add post references tag

        springBoot.getPosts().add(post);
        hibernate.getPosts().add(post);

        springBoot.getPosts().add(post1);
        post1.getTags().add(springBoot);


        this.postRepository.save(post);
        this.postRepository.save(post1);

    }
};




