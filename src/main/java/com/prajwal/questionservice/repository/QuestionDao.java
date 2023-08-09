package com.prajwal.questionservice.repository;


import com.prajwal.questionservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {


    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM questions q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> getQuestionsByCategory(String category, Long numQ);

}
