package com.duocuc.formativa4.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PeliculaTest {


    @Test
    void testConstructorAndGetter(){
        Pelicula pelicula=new Pelicula(20L,"Enter de void",2001,
        "Gaspar Noe",
        "DramaExperimental",
        "Narra una experiencia extracorporal en primera persona de un traficante de drogas en Tokio tras su muerte");

        assertEquals(20L, pelicula.getId());
        assertEquals("Enter de void", pelicula.getNombre());
        assertEquals(2001, pelicula.getAnno());
        assertEquals("Gaspar Noe", pelicula.getDirector());
        assertEquals("DramaExperimental", pelicula.getGenero());
        assertEquals("Narra una experiencia extracorporal en primera persona de un traficante de drogas en Tokio tras su muerte", pelicula.getSinopsi());

    }


      @Test
    void testGetterAndSetter(){
        Pelicula pelicula=new Pelicula();

        pelicula.setId(20L);
        pelicula.setNombre("Enter de void");
        pelicula.setaAnno(2001);
        pelicula.setDirector("Gaspar Noe");
        pelicula.setGenero("DramaExperimental");
        pelicula.setSinopsi("Narra una experiencia extracorporal en primera persona de un traficante de drogas en Tokio tras su muerte");

        assertEquals(20L, pelicula.getId());
        assertEquals("Enter de void", pelicula.getNombre());
        assertEquals(2001, pelicula.getAnno());
        assertEquals("Gaspar Noe", pelicula.getDirector());
        assertEquals("DramaExperimental", pelicula.getGenero());
        assertEquals("Narra una experiencia extracorporal en primera persona de un traficante de drogas en Tokio tras su muerte", pelicula.getSinopsi());

    }
    
}
