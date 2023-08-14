package com.stimulus.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.stimulus.main.entities.Comment;
import com.stimulus.main.repository.CommentRepository;

public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findAll(int page, int size) {
        Pageable p = PageRequest.of(page, size);
        return commentRepository.findAll(p).toList();
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(Long id) {
        Optional<Comment> result = commentRepository.findById(id);
        if(result.isEmpty()) {
            throw new RuntimeException("Comment não encontrado.");
        }
        
        return result.get();
    }

    public Comment save(Comment comment) {
        // Verificar se já existe ou não
    	// Post obj = findById(comment.getId());
    	
        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao salvar o Comment.");
        }
    }

    public Comment update(Comment comment) {
    	// Verificar se já existe ou não
    	//Post obj = findById(comment.getId());

        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao atualizar o Comment.");
        }
    }

    public void deleteById(Long id) {
    	// Verificar se já existe ou não
    	Comment obj = findById(id);

        try {
        	commentRepository.delete(obj);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao excluir o Comment.");
        }
    }
}