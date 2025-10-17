package com.example.javaspring_aula9.service;

import com.example.javaspring_aula9.dto.UsuarioRequestDTO;
import com.example.javaspring_aula9.dto.UsuarioResponseDTO;
import com.example.javaspring_aula9.model.UsuarioModel;
import com.example.javaspring_aula9.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<UsuarioResponseDTO> listarUsuario(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(usuarioModel -> new UsuarioResponseDTO(usuarioModel.getNome(), usuarioModel.getEmail()))
                .toList();
    }


    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuário já cadastrado.");
        }
        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(usuarioRequestDTO.getNome());
        novoUsuario.setEmail(usuarioRequestDTO.getEmail());
        novoUsuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));
        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }

    public UsuarioModel atualizarUsuario(Long id , UsuarioRequestDTO usuarioRequestDTO){
        if(usuarioRepository.existsById(id)){
            UsuarioModel atualizarUsuario = new UsuarioModel();
            atualizarUsuario.setId(id);
            atualizarUsuario.setNome(usuarioRequestDTO.getNome());
            atualizarUsuario.setEmail(usuarioRequestDTO.getEmail());
            atualizarUsuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));
            usuarioRepository.save(atualizarUsuario);
            return atualizarUsuario;
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    public void deletarUsuario(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }


}
