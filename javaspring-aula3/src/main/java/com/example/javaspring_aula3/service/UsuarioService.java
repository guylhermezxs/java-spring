package com.example.javaspring_aula3.service;


import com.example.javaspring_aula3.model.Usuario;
import com.example.javaspring_aula3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> lista(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar (Usuario usuario){
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new RuntimeException("Usuario já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public void deletar(UUID id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }

    public Usuario atualizar(UUID id , Usuario usuario){
        if (usuarioRepository.existsById(id)){
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }
}
