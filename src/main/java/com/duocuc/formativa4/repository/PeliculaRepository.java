package com.duocuc.formativa4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duocuc.formativa4.models.Pelicula;


/*  interfaz que hereda de jpa */

public interface PeliculaRepository  extends JpaRepository <Pelicula , Long>{

}
