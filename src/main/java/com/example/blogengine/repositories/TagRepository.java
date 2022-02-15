package com.example.blogengine.repositories;

import com.example.blogengine.entities.Combination;
import com.example.blogengine.entities.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Query("SELECT t FROM Tag t WHERE t.catID=?1")
    List<Tag> SearchByCatID(Integer catID);
}
