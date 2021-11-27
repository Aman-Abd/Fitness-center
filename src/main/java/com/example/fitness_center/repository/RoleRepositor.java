package com.example.fitness_center.repository;

import com.example.fitness_center.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositor extends MongoRepository<Role, Long> {
}
