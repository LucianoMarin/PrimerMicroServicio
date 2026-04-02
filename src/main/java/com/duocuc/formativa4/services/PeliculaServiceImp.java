package com.duocuc.formativa4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocuc.formativa4.models.Pelicula;
import com.duocuc.formativa4.repository.PeliculaRepository;

@Service
public class PeliculaServiceImp implements PeliculaService{


@Autowired
private PeliculaRepository peliculaRepositorio;

 @Override
 public Optional<Pelicula> getPeliculaById(Long id) {

     return peliculaRepositorio.findById(id);
 }

 @Override
 public List<Pelicula> getAllPeliculas() {

    return peliculaRepositorio.findAll();
 }


@Override
public Pelicula createPelicula(Pelicula pelicula) {
    return null;
}

@Override
public void deletePelicula(Long id) {
    
}
    

@Override
public Pelicula updatePelicula(Long id, Pelicula pelicula) {
     return null;
}

}
