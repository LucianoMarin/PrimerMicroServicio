package com.duocuc.formativa4.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.formativa4.models.Pelicula;
import com.duocuc.formativa4.services.PeliculaService;


@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")

public class ControllerPelicula {

    @Autowired 
    private PeliculaService peliculaService;


        @GetMapping
        public List <Pelicula> mostrarPeliculas(){
            return peliculaService.getAllPeliculas();
        }


        @GetMapping("/{id}")
        public Optional <Pelicula> mostrarPelicula(@PathVariable Long id){

            return peliculaService.getPeliculaById(id);

        }


        @PostMapping
        public Pelicula crearPelicula(@RequestBody Pelicula pelicula){

            return peliculaService.createPelicula(pelicula);

        }

        @PutMapping("/{id}")
        public Pelicula actPelicula(@RequestBody Pelicula pelicula,@PathVariable Long id){

            return peliculaService.updatePelicula(id, pelicula);
        }


        @DeleteMapping("/{id}")
        public void EliminarPelicula(@PathVariable Long id){

            peliculaService.deletePelicula(id);

        }

}
