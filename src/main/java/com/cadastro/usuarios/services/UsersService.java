package com.cadastro.usuarios.services;

import com.cadastro.usuarios.entities.Users;
import com.cadastro.usuarios.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository repository;
    
    public List<Users> findAll(){
        return repository.findAll();
    }

    public Users findById(Long id){
        Optional<Users> obj = repository.findById(id);
        return obj.orElseThrow();
    }

    public Users insert(Users user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Users update(Long id, Users obj){
        Users entity = repository.getReferenceById(id);
        updateDate(entity, obj);
        return repository.save(entity);
    }

    public void updateDate(Users entity, Users obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

