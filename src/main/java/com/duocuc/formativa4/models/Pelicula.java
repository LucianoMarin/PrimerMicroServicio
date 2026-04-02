package com.duocuc.formativa4.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Pelicula")

public class Pelicula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank(message="No puede dejar el campo nombre vacio")
    @Column (name="nombre")
    private String nombre;

    @NotBlank(message="No puede dejar el campo año vacio")
    @Column (name="anno")
    private int anno;


    @NotBlank(message="No puede dejar el campo director vacio")
    @Column (name="director")
    private String director;


    @NotBlank(message="No puede dejar el campo genero vacio")
    @Column (name="genero")
    private String genero;

    @Column (name="sinopsi")
    private String sinopsi;

    public Pelicula(Long id,String nombre,int anno,String director,String genero,String sinopsi){

        this.id=id;
        this.nombre=nombre;
        this.anno=anno;
        this.director=director;
        this.genero=genero;
        this.sinopsi=sinopsi;

    }


    public void setId(Long id){ this.id=id;}

    public Long getId(){return this.id;}

    public void setNombre(String nombre){this.nombre=nombre;}

    public String getNombre(){return this.nombre;}

    public void setaAnno(int anno){this.anno=anno;}

    public int getAnno(int anno){return this.anno;}

    public void setDirector(String director){this.director=director;}
    
    public String getDirector(){return this.director;} 

    public void setGenero(String genero){this.genero=genero;}

    public String getGenero(){return this.genero;}

    public void setSinopsi(String sinopsi){this.sinopsi=sinopsi;}

    public String getSinopsi(){return this.sinopsi;}


}
