package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Dia;

@Repository
public interface DiaService extends JpaRepository<Dia, Integer> {

}
