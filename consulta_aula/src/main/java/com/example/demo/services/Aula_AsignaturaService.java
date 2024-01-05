package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Aula_Asignatura;


@Repository
public interface Aula_AsignaturaService extends JpaRepository<Aula_Asignatura, Integer>{
}
