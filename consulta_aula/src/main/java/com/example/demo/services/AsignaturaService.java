package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Asignatura;


@Repository
public interface AsignaturaService extends JpaRepository<Asignatura, Integer>{
}
