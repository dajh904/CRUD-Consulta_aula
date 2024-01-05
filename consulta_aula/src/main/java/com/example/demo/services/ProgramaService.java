package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Programa;

@Repository
public interface ProgramaService extends JpaRepository<Programa, Integer>{

}
