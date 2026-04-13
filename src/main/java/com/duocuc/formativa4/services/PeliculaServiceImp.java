package com.duocuc.formativa4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocuc.formativa4.models.Pelicula;
import com.duocuc.formativa4.repository.PeliculaRepository;


/* se construyen las funciones al incorporar la interfaz  */

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
    return peliculaRepositorio.save(pelicula);
}

@Override
public void deletePelicula(Long id) {

    peliculaRepositorio.deleteById(id);
    
}
    

@Override
public Pelicula updatePelicula(Long id, Pelicula pelicula) {
     if(peliculaRepositorio.existsById(id)){

        pelicula.setId(id);

        return peliculaRepositorio.save(pelicula);

     }else{

        return null;
     }

     
}

}
