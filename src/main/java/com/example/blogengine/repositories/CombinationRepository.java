package com.example.blogengine.repositories;

import com.example.blogengine.entities.Combination;
import com.example.blogengine.entities.Tag;
import com.example.blogengine.entities.blogPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;



@Repository
public interface CombinationRepository extends JpaRepository<Combination, Integer>, PagingAndSortingRepository<Combination, Integer> {

    @Query("SELECT COUNT(u) FROM Combination u WHERE u.blogID=?1")
    long CountByID(Integer ID);

    @Query("SELECT u FROM Combination u WHERE u.tag=?1")
    List<Combination> SearchByTag(String tag, Pageable pageable);

    @Query("SELECT u FROM Combination u WHERE u.catID=?1")
    List<Combination> SearchByCatID(Integer catID);

}
