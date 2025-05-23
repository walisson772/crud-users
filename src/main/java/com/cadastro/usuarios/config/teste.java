package com.cadastro.usuarios.config;


import com.cadastro.usuarios.entities.Tarefas;
import com.cadastro.usuarios.entities.Users;
import com.cadastro.usuarios.entities.enums.Status;
import com.cadastro.usuarios.repositories.TarefaRepository;
import com.cadastro.usuarios.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class teste implements CommandLineRunner {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private TarefaRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        Users u1 = new Users(null, "Eu", "9999", "wadwadada");
        Users u2 = new Users(null, "Eu2", "988888", "eu2.gmail.com");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Tarefas o1 = new Tarefas(null, u1, "Limpar a casa", "Limpar a casa e deixar bem arrumada", Status.PENDENTE);
        Tarefas o2 = new Tarefas(null, u2, "Lavar a roupa", "lavar todas as roupas", Status.PENDENTE);
        Tarefas o3 = new Tarefas(null, u1, "Fazer o almoço", "Fazer um frango frito bem temperado", Status.PENDENTE);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
