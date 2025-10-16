package com.example.javaspring_aula8.service;

import com.example.javaspring_aula8.dto.UsuarioRequestDTO;
import com.example.javaspring_aula8.dto.UsuarioResponseDTO;
import com.example.javaspring_aula8.model.UsuarioModel;
import com.example.javaspring_aula8.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    // Salvar
    public UsuarioModel salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        if (usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuario já cadastrado.");
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        // Criptografia a senha de salvar banco de dados.
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha()));

        usuarioRepository.save(usuario);
        return usuario;
    }

    // Consultar tabela no banco de dados
    public List<UsuarioResponseDTO> listarUsuario(){
        return usuarioRepository
                // Retorna com os dados de todos os usuários na tabela.
                .findAll()
                // Envia os dados obtidos para as próximas funções abaixo.
                .stream()
                // Envia somente os dados necessarios para resposta.
                .map(usuarioModel -> new UsuarioResponseDTO(usuarioModel.getNome(), usuarioModel.getEmail()))
                // Transfoma todos os dados em uma lista.
                .toList();
    }







}
