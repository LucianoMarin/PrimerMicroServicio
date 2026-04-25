package com.duocuc.formativa4.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.duocuc.formativa4.models.Pelicula;
import com.duocuc.formativa4.repository.PeliculaRepository;

import jakarta.inject.Inject;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceImpTest {
    @Mock
    private PeliculaRepository repository;

    @InjectMocks
    private PeliculaServiceImp service;


    private Pelicula pelicula;

    @BeforeEach
    void setUp(){
        pelicula =new Pelicula();
        pelicula.setId(10L);
        pelicula.setNombre("Up");
        pelicula.setaAnno(2009);
        pelicula.setDirector("Pete Docter");
        pelicula.setSinopsi("Un niño y un abuelito en busca de aventuras");

    }


    @Test
    void testObtenerTodasPeliculas(){

        List <Pelicula> expected=Arrays.asList(pelicula);
            when(repository.findAll()).thenReturn(expected);
            assertEquals(expected, service.getAllPeliculas());
    }

    @Test
    void testObtenerUnaPelicula(){

        when(repository.findById(1L)).thenReturn(Optional.of(pelicula));
        assertEquals(Optional.of(pelicula),service.getPeliculaById(1L));

    }

    @Test
    void testCrearPelicula(){

        when(repository.save(pelicula)).thenReturn(pelicula);
        assertEquals(pelicula, service.createPelicula(pelicula));

    }

    @Test
    void testActualizarPelicula(){
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(pelicula)).thenReturn(pelicula);
        Pelicula resultado=service.updatePelicula(1L, pelicula);
        assertEquals(1L, pelicula.getId());
        assertEquals(resultado, resultado);
        verify(repository).save(pelicula);


    }

    @Test
    void testActualizarPeliculaNoExiste(){
        when(repository.existsById(1L)).thenReturn(false);
        assertNull(service.updatePelicula(1L, pelicula));
        verify(repository, never()).save(any());

    }



    @Test 
    void testEliminarPelicula(){
        service.deletePelicula(1L);
        verify(repository).deleteById(1L);


    }
   
}
