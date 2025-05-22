package com.cadastro.usuarios.services;

import com.cadastro.usuarios.entities.Tarefas;
import com.cadastro.usuarios.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {

    @Autowired
    private TarefaRepository repository;

    public List<Tarefas> findAll(){
        return repository.findAll();
    }

    public Tarefas findById(Long id){
        Optional<Tarefas> obj = repository.findById(id);
        return obj.orElseThrow();
    }

    public Tarefas insert(Tarefas tarefa){
        return repository.save(tarefa);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Tarefas update(Long id, Tarefas obj){
        Tarefas entity = repository.getReferenceById(id);
        updateDate(entity, obj);
        return repository.save(entity);
    }

    public void updateDate(Tarefas entity, Tarefas obj){
        entity.setTarefa(obj.getTarefa());
        entity.setDescricao(obj.getDescricao());
        entity.setStatus(obj.getStatus());
    }
}
