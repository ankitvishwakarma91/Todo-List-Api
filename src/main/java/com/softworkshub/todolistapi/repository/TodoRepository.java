package com.softworkshub.todolistapi.repository;

import com.softworkshub.todolistapi.model.Todo;
import com.softworkshub.todolistapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUser(Users user);
}
