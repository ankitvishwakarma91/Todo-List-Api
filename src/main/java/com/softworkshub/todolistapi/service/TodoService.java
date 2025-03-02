package com.softworkshub.todolistapi.service;

import com.softworkshub.todolistapi.model.Todo;
import com.softworkshub.todolistapi.model.Users;
import com.softworkshub.todolistapi.repository.TodoRepository;
import com.softworkshub.todolistapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private UsersRepository usersRepository;

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated");
        }

        String username = authentication.getName();
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return todoRepository.findByUser(user);
    }

    public Todo createTodo(Todo todo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated");
        }

        String username = authentication.getName();
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));


        todo.setUser(user);

        return todoRepository.save(todo);
    }

    @Transactional
    public Todo updateTodo(Long id, Todo todo) {
        Todo existing = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        existing.setTitle(todo.getTitle());
        existing.setDescription(todo.getDescription());
        return todoRepository.save(existing);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}