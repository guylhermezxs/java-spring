package com.example.usermanagerAPI.service;

import com.example.usermanagerAPI.dto.UsuarioRequestDTO;
import com.example.usermanagerAPI.dto.UsuarioResponseDTO;
import com.example.usermanagerAPI.model.UsuarioModel;
import com.example.usermanagerAPI.repository.UsuarioRepository;
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
                .map(usuarioModel -> new UsuarioResponseDTO(usuarioModel.getNome(), usuarioModel.getEmail(), usuarioModel.getRole()))
                .toList();
    }

    public UsuarioResponseDTO buscarUsuario(Long id){
        UsuarioModel buscarUsuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
          return new UsuarioResponseDTO(
                  buscarUsuario.getNome(),
                  buscarUsuario.getEmail(),
                  buscarUsuario.getRole()
          );
    }

    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuario){
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuário já cadastrado.");
        }
        UsuarioModel salvarUsuario = new UsuarioModel();
        salvarUsuario.setNome(usuario.getNome());
        salvarUsuario.setEmail(usuario.getEmail());
        salvarUsuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        salvarUsuario.setRole(usuario.getRole());
        usuarioRepository.save(salvarUsuario);
        return salvarUsuario;
    }

    public UsuarioModel atualizarUsuario(Long id , UsuarioRequestDTO usuario){
        if (usuarioRepository.existsById(id)){
            UsuarioModel atualizarUsuario = new UsuarioModel();
            atualizarUsuario.setId(id);
            atualizarUsuario.setNome(usuario.getNome());
            atualizarUsuario.setEmail(usuario.getEmail());
            atualizarUsuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
            atualizarUsuario.setRole(usuario.getRole());
            usuarioRepository.save(atualizarUsuario);
            return atualizarUsuario;
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    public void deletarUsuario(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        } else{
            throw new RuntimeException("Usuário não encontrado.");
        }
    }
}
