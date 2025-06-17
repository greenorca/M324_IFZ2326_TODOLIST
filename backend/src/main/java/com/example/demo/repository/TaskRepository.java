package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    void deleteAll();
}
