package com.example.javaspring_aula6.service;

import com.example.javaspring_aula6.exception.EmailCadastradoException;
import com.example.javaspring_aula6.model.UsuarioModel;
import com.example.javaspring_aula6.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public UsuarioModel salvarUsuario(UsuarioModel usuario){
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new EmailCadastradoException("Usuário já cadastrado!");
        }
       return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(UUID id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public UsuarioModel atualizarUsuario(UUID id , UsuarioModel usuario){
        if (usuarioRepository.existsById(id)){
            usuario.setId(id);
           return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public List<UsuarioModel> buscarNome(String nome){
       return usuarioRepository.findByNome(nome);
    }
}
