package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Aula;

@Repository
public interface AulaService extends JpaRepository<Aula, String>{

}
