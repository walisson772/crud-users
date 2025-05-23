package com.cadastro.usuarios.controller;

import com.cadastro.usuarios.entities.Tarefas;
import com.cadastro.usuarios.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
