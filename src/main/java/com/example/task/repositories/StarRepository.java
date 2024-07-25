package com.example.task.repositories;

import com.example.task.models.star.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StarRepository extends JpaRepository<Star, Long>, JpaSpecificationExecutor<Star> {
}

