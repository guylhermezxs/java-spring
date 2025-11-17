package com.example.taskmanagerAPI.service;

import com.example.taskmanagerAPI.dto.TarefaRequestDTO;
import com.example.taskmanagerAPI.dto.TarefaResponseDTO;
import com.example.taskmanagerAPI.model.TarefaModel;
import com.example.taskmanagerAPI.repository.TarefaRepository;
import com.example.taskmanagerAPI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefaService {
    private TarefaRepository tarefaRepository;
    private UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<TarefaResponseDTO> listarTarefas(){
        return tarefaRepository
                .findAll()
                .stream()
                .map(tarefaModel -> new TarefaResponseDTO(tarefaModel.getTitulo() , tarefaModel.getDescricao() , tarefaModel.getStatus() , tarefaModel.getDataCriacao()))
                .toList();
    }

    public TarefaResponseDTO buscarId(Long id){
        TarefaModel buscarTarefa = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));
        return new TarefaResponseDTO(
                buscarTarefa.getTitulo(),
                buscarTarefa.getDescricao(),
                buscarTarefa.getStatus(),
                buscarTarefa.getDataCriacao()
        );
    }

    public TarefaModel salvarTarefa(TarefaRequestDTO tarefa){
        if (tarefaRepository.findByTitulo(tarefa.getTitulo()).isPresent()){
            throw new IllegalArgumentException("Tarefa já cadastrada.");
        }

        var usuario = usuarioRepository.findById(tarefa.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        TarefaModel novaTarefa = new TarefaModel();
        novaTarefa.setTitulo(tarefa.getTitulo());
        novaTarefa.setDescricao(tarefa.getDescricao());
        novaTarefa.setStatus(tarefa.getStatus());
        novaTarefa.setDataCriacao(LocalDateTime.now());
        novaTarefa.setUsuario(usuario);
        tarefaRepository.save(novaTarefa);
        return novaTarefa;
    }

    public TarefaModel atualizarTarefa(Long id , TarefaRequestDTO tarefa){
        if(tarefaRepository.existsById(id)){

            TarefaModel atualizarTarefa = new TarefaModel();
            atualizarTarefa.setId(id);
            atualizarTarefa.setTitulo(tarefa.getTitulo());
            atualizarTarefa.setDescricao(tarefa.getDescricao());
            atualizarTarefa.setStatus(tarefa.getStatus());
            atualizarTarefa.setDataCriacao(LocalDateTime.now());

            if (tarefa.getUsuarioId() != null) {
                var usuario = usuarioRepository.findById(tarefa.getUsuarioId())
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
                atualizarTarefa.setUsuario(usuario);
            }

            tarefaRepository.save(atualizarTarefa);
            return atualizarTarefa;
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }

    public void deletarTarefa(Long id){
        if (tarefaRepository.existsById(id)){
            tarefaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada");
        }
    }


}
