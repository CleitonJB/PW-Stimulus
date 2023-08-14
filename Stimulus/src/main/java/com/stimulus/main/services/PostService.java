package com.stimulus.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.stimulus.main.entities.Post;
import com.stimulus.main.repository.PostRepository;

public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(int page, int size) {
        Pageable p = PageRequest.of(page, size);
        return postRepository.findAll(p).toList();
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        Optional<Post> result = postRepository.findById(id);
        if(result.isEmpty()) {
            throw new RuntimeException("Post não encontrado.");
        }
        
        return result.get();
    }

    public Post save(Post post) {
        // Verificar se já existe ou não
    	// Post obj = findById(post.getId());
    	
        try {
            return postRepository.save(post);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao salvar o Post.");
        }
    }

    public Post update(Post post) {
    	// Verificar se já existe ou não
    	//Post obj = findById(post.getId());

        try {
            return postRepository.save(post);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao atualizar o Post.");
        }
    }

    public void deleteById(Long id) {
    	// Verificar se já existe ou não
    	Post obj = findById(id);

        try {
        	postRepository.delete(obj);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao excluir o Post.");
        }
    }
}