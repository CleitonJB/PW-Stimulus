package com.stimulus.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stimulus.main.entities.User;
import com.stimulus.main.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(int page, int size) {
        Pageable p = PageRequest.of(page, size);
        return userRepository.findAll(p).toList();
    }

    public List<User> findAll() {
        try {
        	return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar os Usuários.");
        }
    }

    public Optional<User> findById(Long id) {
        try {
        	return userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao encontrar o Usuário: ", e);
        }
    }

    public User save(User user, MultipartFile file) {
        try {
        	return userRepository.save(user);
        	
//        	Optional<User> result = findById(user.getId());
//        	
//        	if(result.isEmpty()) {
//        		return userRepository.save(user);
//        	} else {
//        		throw new RuntimeException("O Usuário não existe para ser atualizado!");
//        	}
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar o Usuário: ", e);
        }
    }

    public User update(User user, MultipartFile file) {
        try {
        	Optional<User> result = findById(user.getId());
        	
        	if(result.isEmpty()) {
        		throw new RuntimeException("O Usuário não existe para ser atualizado!");
        	} else {
                return userRepository.save(user);
        	}
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o Usuário: ", e);
        }
    }

    public void deleteById(Long id) {
        try {
        	Optional<User> result = findById(id);
        	
        	if(result.isEmpty()) {
        		throw new RuntimeException("O Usuário não existe para ser excluído!");
        	} else {
        		userRepository.deleteById(id);
        		return;
        	}
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o Usuário: ", e);
        }
    }

//    private void verificaEmailCadastrado(String email) {
//        List<User> result = userRepository.findByEmail(email);
//        if (!result.isEmpty()) {
//            throw new RuntimeException("Email já cadastrado.");
//        }
//    }
}