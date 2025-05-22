package com.cadastro.usuarios.repositories;

import com.cadastro.usuarios.entities.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefas, Long> {
}
