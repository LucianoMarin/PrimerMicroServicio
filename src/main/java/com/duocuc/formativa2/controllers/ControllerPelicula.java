package com.duocuc.formativa2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.formativa2.models.Pelicula;


@RestController
public class ControllerPelicula {

    public List <Pelicula> peliculas=new ArrayList<>();


 
    public ControllerPelicula(){
        peliculas.add(new Pelicula(1,"El Señor De Los Anillos",2001,"Peter Jackson","Ciencia Ficcion","Historia loca de hobbits y cosas raras"));
        peliculas.add(new Pelicula(2,"Jojo Rabbit",2019,"Taika Waititi","Comedia Dramatica","Historia satira de jojo y el feurer"));
        peliculas.add(new Pelicula(3,"The Truman Show",1998,"Peter Weir","Sátira, ciencia ficción y comedia dramática","Truman vive en un mundo perfecto hasta que un dia se da cuenta que algo anda mal."));
        peliculas.add(new Pelicula(4,"Titanic",1997,"James Cameron","Novela ","Un barco se hunde con un iceberg"));
        peliculas.add(new Pelicula(5,"Anaconda",2025,"Tom Gormican","Comedia,Terror","Una serpiente grande anda suelta en el amazonas"));


    }

        @GetMapping("/peliculas")
        public List <Pelicula> mostrarPeliculas(){
            return peliculas;
        }


        @GetMapping("/peliculas/{id}")
        public Pelicula mostrarPelicula(@PathVariable int id){

            for(Pelicula p: peliculas){

                if(p.getId()==id){

                    return p;
                }

            }

            return null;

        }


}
