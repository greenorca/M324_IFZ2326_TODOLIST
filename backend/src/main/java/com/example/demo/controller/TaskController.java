package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Task;
import com.example.demo.dto.TaskDto;
import com.example.demo.repository.TaskRepository;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired TaskRepository taskRepository;

	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks() {

    return ResponseEntity.ok(taskRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<String> addTask(@RequestBody TaskDto taskdescription) {
		System.out.println("API EP '/task': '" + taskdescription + "'");
		Task t = new Task();
    t.setTaskdescription(taskdescription.getTaskdescription());
    taskRepository.save(t);
    return ResponseEntity.ok("OK");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delTask(@PathVariable Long id) {
		System.out.println("API EP '/delete': '" + id + "'");
		taskRepository.deleteById(id);
		return ResponseEntity.ok("OK");
	}

  protected void deleteAll() {
		taskRepository.deleteAll();
  }

}
