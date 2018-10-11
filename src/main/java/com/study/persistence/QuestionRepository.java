package com.study.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
