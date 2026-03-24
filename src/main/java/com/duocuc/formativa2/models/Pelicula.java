package com.duocuc.formativa2.models;


public class Pelicula {
    

    private int id;
    private String nombre;
    private int anno;
    private String director;
    private String genero;
    private String sinopsi;

    public Pelicula(int id,String nombre,int anno,String director,String genero,String sinopsi){

        this.id=id;
        this.nombre=nombre;
        this.anno=anno;
        this.director=director;
        this.genero=genero;
        this.sinopsi=sinopsi;

    }


    public void setId(int id){ this.id=id;}

    public int getId(){return this.id;}

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
