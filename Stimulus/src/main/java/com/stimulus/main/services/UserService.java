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

public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(int page, int size) {
        Pageable p = PageRequest.of(page, size);
        return userRepository.findAll(p).toList();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isEmpty()) {
            //throw new NotFoundException("Usuário não encontrado.");
            throw new RuntimeException("Usuário não encontrado.");
        }
        return result.get();
    }

    public User save(User u, MultipartFile file) {
        //arquivo
        if(file != null) {
            if(!file.isEmpty()) {
                //salvarArquivo(file, u.getEmail() + ".pdf");
                //u.setDocumentos(c.getEmail() + ".pdf");
            } else {
                //u.setDocumentos(null);
            }
        }
        //Verifica se email já está cadastrado
        verificaEmailCadastrado(u.getEmail());
        try {
            return userRepository.save(u);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao salvar o usuário.");
        }
    }

    public User update(User u, MultipartFile file) {
        //Cliente já existe
    	User obj = findById(u.getId());
        //arquivo
        //u.setDocumentos(obj.getDocumentos());
        if (file != null) {
            if(!file.isEmpty()) {
                //salvarArquivo(file, u.getEmail() + ".pdf");
                //u.setDocumentos(u.getEmail() + ".pdf");
            }
        }
        try {
            u.setEmail(obj.getEmail());
            return userRepository.save(u);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao atualizar o cliente.");
        }
    }

    public void delete(Long id) {
        User obj = findById(id);

        try {
        	userRepository.delete(obj);
//            if(obj.getDocumentos() != null) {
//                Path caminho = Paths.get("uploads", obj.getDocumentos());
//                Files.deleteIfExists(caminho);
//            }
        } catch (Exception e) {
            throw new RuntimeException("Falha ao excluir o cliente.");
        }
    }

//    private void salvarArquivo(MultipartFile file, String novoNome) {
//        if (file.getContentType().equals(MediaType.APPLICATION_PDF_VALUE)) {
//            Path dest = Paths.get("uploads", novoNome);
//            try {
//                file.transferTo(dest);
//            } catch (IOException ex) {
//                throw new RuntimeException("Falha ao salvar o arquivo.");
//            }
//        } else {
//            throw new RuntimeException("Arquivo deve ser do tipo PDF.");
//        }
//    }

    private void verificaEmailCadastrado(String email) {
        List<User> result = userRepository.findByEmail(email);
        if (!result.isEmpty()) {
            throw new RuntimeException("CPF ou EMAIL já cadastrados.");
        }
    }
}