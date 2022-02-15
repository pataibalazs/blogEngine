package com.example.blogengine.blogEngine;

import com.example.blogengine.entities.Category;
import com.example.blogengine.entities.Combination;
import com.example.blogengine.entities.Tag;
import com.example.blogengine.entities.blogPost;
import com.example.blogengine.repositories.BlogpostRepository;
import com.example.blogengine.repositories.CategoryRepository;
import com.example.blogengine.repositories.CombinationRepository;
import com.example.blogengine.repositories.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DatabaseConfig {

    @Bean
    CommandLineRunner commandLineRunner(BlogpostRepository blogrep, CategoryRepository catrep, TagRepository tagrep, CombinationRepository comrep){
        return args -> {

            blogPost blog1=new blogPost(1,"reddit","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog2=new blogPost(2,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog3=new blogPost(3,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog4=new blogPost(4,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog5=new blogPost(5,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog6=new blogPost(6,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog7=new blogPost(7,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog8=new blogPost(8,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog9=new blogPost(9,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog10=new blogPost(10,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());
            blogPost blog11=new blogPost(11,"facebook","temp_value",java.time.LocalDateTime.now(),java.time.LocalDateTime.now());



            Category cat1=new Category(1);
            Category cat2=new Category(2);
            Category cat3=new Category(3);

            Tag tag1=new Tag(1,1,"reddit");
            Tag tag2=new Tag(2,1,"facebook");
            Tag tag3=new Tag(3,2,"facebook");
            Tag tag4=new Tag(4,2,"instagram");


            Combination com1=new Combination(1,1,1,1,"reddit");
            Combination com2=new Combination(2,2,2,2,"facebook");
            Combination com3=new Combination(3,3,3,2,"facebook");
            Combination com4=new Combination(4,3,4,2,"facebook");
            Combination com5=new Combination(5,3,5,2,"facebook");
            Combination com6=new Combination(6,3,6,2,"facebook");
            Combination com7=new Combination(7,3,7,2,"facebook");
            Combination com8=new Combination(8,3,8,2,"facebook");
            Combination com9=new Combination(9,3,9,2,"facebook");
            Combination com10=new Combination(10,3,10,2,"facebook");
            Combination com11=new Combination(11,3,11,2,"facebook");


            blogrep.saveAll(
                    List.of(blog1,blog2,blog3,blog4,blog5,blog6,blog7,blog8,blog9,blog10,blog11)
            );

            catrep.saveAll(
                    List.of(cat1,cat2,cat3)

            );
            tagrep.saveAll(
                    List.of(tag1,tag2,tag3,tag4)
            );

            comrep.saveAll(
                    List.of(com1,com2,com3,com4,com5,com6,com7,com8,com9,com10,com11)
            );


        };
    }
}

