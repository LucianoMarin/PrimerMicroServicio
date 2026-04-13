package com.duocuc.formativa4.services;

import java.util.List;
import java.util.Optional;

import com.duocuc.formativa4.models.Pelicula;

/* aqui se arma la interfaz */

public interface PeliculaService {

List <Pelicula> getAllPeliculas();
Optional  getPeliculaById(Long id);


Pelicula createPelicula(Pelicula pelicula);
Pelicula updatePelicula(Long id, Pelicula pelicula);
void deletePelicula(Long id);

}
