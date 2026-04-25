package com.duocuc.formativa4.controllers;


import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.duocuc.formativa4.models.Pelicula;
import com.duocuc.formativa4.services.PeliculaService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(ControllerPelicula.class)
public class ControllerPeliculaTest {

    @Autowired
    private MockMvc mockMvc;

    
    @MockBean
    private PeliculaService service;

    @Autowired
    private ObjectMapper mapper;

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
    void testObtenerPelicula()throws Exception{

        when(service.getAllPeliculas()).thenReturn(Arrays.asList(pelicula));
        mockMvc.perform(get("/peliculas"))
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(Arrays.asList(pelicula))));
    }


    @Test 
    void testObtenerPorId()throws Exception{
        when(service.getPeliculaById(1L)).thenReturn(Optional.of(pelicula));
        mockMvc.perform(get("/peliculas/1"))
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(pelicula)));

    }

    @Test
    void testInsertarPelicula() throws Exception{

    when(service.createPelicula(any(Pelicula.class))).thenReturn(pelicula);

    mockMvc.perform(post("/peliculas")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(pelicula)))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(pelicula)));
    }

    @Test
    void eliminarPelicula()throws Exception{
        mockMvc.perform(delete("/peliculas/1"))
        .andExpect(status().isOk());
        verify(service).deletePelicula(1L);
    }

    @Test
    void actualizarPelicula()throws Exception{
        when(service.updatePelicula(eq(1L),any(Pelicula.class))).thenReturn(pelicula);

        mockMvc.perform(put("/peliculas/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(pelicula)))
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(pelicula)));

    
    }





}
