package com.example.demo.repository;

import com.example.demo.entity.Passing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassingRepository extends JpaRepository<Passing, Long> {
}
