package com.example.blogengine.repositories;

import com.example.blogengine.entities.blogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// ezek az interfészek közvetlenül elérik az adatbázist


import java.util.Optional;
@Repository
public interface BlogpostRepository extends JpaRepository<blogPost, Integer> {

}
