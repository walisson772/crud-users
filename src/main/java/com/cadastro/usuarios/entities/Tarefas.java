package com.cadastro.usuarios.entities;

import com.cadastro.usuarios.entities.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tarefas_db")
public class Tarefas implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarefa;
    private String descricao;
    private Integer status;

    @JoinColumn(name = "client_id")
    @ManyToOne
    private Users user;

    public Tarefas(){
    }

    public Tarefas(Long id, Users user, String tarefa, String descricao, Status status){
        this.id = id;
        this.tarefa = tarefa;
        this.descricao = descricao;
        setStatus(status);
        this.user = user;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefas tarefas = (Tarefas) o;
        return Objects.equals(id, tarefas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
