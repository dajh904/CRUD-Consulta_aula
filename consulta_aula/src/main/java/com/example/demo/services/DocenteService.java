package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Docente;

@Repository
public interface DocenteService extends JpaRepository<Docente, Integer>{

}
