package com.cadastro.usuarios.repositories;

import com.cadastro.usuarios.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
