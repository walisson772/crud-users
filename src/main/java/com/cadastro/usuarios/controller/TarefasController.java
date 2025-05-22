package com.cadastro.usuarios.controller;

import com.cadastro.usuarios.entities.Tarefas;
import com.cadastro.usuarios.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @GetMapping
    public ResponseEntity<List<Tarefas>> findAll(){
        List<Tarefas> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tarefas> findById(@PathVariable Long id){
        Tarefas tarefas = service.findById(id);
        return ResponseEntity.ok().body(tarefas);
    }

    @PostMapping
    public ResponseEntity<Tarefas> insert(@RequestBody Tarefas tarefas){
        tarefas = service.insert(tarefas);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tarefas.getId()).toUri();
        return ResponseEntity.created(uri).body(tarefas);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefas> update(@PathVariable Long id,@RequestBody Tarefas tarefas){
        tarefas = service.update(id, tarefas);
        return ResponseEntity.ok().body(tarefas);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
