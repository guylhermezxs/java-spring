package com.example.taskmanagerAPI.controller;

import com.example.taskmanagerAPI.dto.TarefaRequestDTO;
import com.example.taskmanagerAPI.dto.TarefaResponseDTO;
import com.example.taskmanagerAPI.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {


    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas(){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.listarTarefas());
    }

    @GetMapping("/buscar")
    public ResponseEntity<TarefaResponseDTO> buscarTarefa(@RequestParam ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.buscarId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String , Object>> salvarTarefa(@Valid @RequestBody TarefaRequestDTO tarefa){
        tarefaService.salvarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Tarefa salva." , "sucesso" , true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String , Object>> atualizarTarefa(@PathVariable ("id") Long id , @Valid @RequestBody TarefaRequestDTO tarefa){
        tarefaService.atualizarTarefa(id,tarefa);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Tarefa atualizada." , "sucesso" , true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String , Object>> deletarTarefa(Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Tarefa deletada.","sucesso" , true));
    }
}
