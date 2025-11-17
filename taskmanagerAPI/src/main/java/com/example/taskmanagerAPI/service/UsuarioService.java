package com.example.taskmanagerAPI.service;

import com.example.taskmanagerAPI.dto.UsuarioRequestDTO;
import com.example.taskmanagerAPI.dto.UsuarioResponseDTO;
import com.example.taskmanagerAPI.model.UsuarioModel;
import com.example.taskmanagerAPI.repository.UsuarioRepository;
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
                .map(usuarioModel -> new UsuarioResponseDTO(usuarioModel.getNome(), usuarioModel.getEmail(), usuarioModel.isAtivo()))
                .toList();
    }

    public UsuarioResponseDTO buscarId(Long id){
        UsuarioModel buscarUsuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UsuarioResponseDTO(
                buscarUsuario.getNome(),
                buscarUsuario.getEmail(),
                buscarUsuario.isAtivo()
        );
    }

    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuario){
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuário já cadastro");
        }
        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        novoUsuario.setAtivo(usuario.isAtivo());
        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }

    public UsuarioModel atualizarUsuario(Long id , UsuarioRequestDTO usuario){
        if (usuarioRepository.existsById(id)){
            UsuarioModel atualizarUsuario = new UsuarioModel();
            atualizarUsuario.setId(id);
            atualizarUsuario.setNome(usuario.getNome());
            atualizarUsuario.setEmail(usuario.getEmail());
            atualizarUsuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
            atualizarUsuario.setAtivo(usuario.isAtivo());
            usuarioRepository.save(atualizarUsuario);
            return atualizarUsuario;
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    public void deletarUsuario(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
