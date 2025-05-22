package com.cadastro.usuarios.entities;

import com.cadastro.usuarios.entities.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefas{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarefa;
    private String descricao;
    private Integer status;

    public Tarefas(){
    }

    public Tarefas(Long id, String tarefa, String descricao, Status status){
        this.id = id;
        this.tarefa = tarefa;
        this.descricao = descricao;
        setStatus(status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return Status.valueOff(status);
    }

    public void setStatus(Status status) {
        if (status != null){
            this.status = status.getCode();
        }
    }
}
