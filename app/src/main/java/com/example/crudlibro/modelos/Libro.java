package com.example.crudlibro.modelos;

public class Libro {

    //atributos de la clase Libro

    private int id;
    private String titulo, subtitlo, autor;
    private int anioPublicacion;
    private double precio;


    //Constructor por defecto o vacio

    public Libro(){

    }

    //Constructor con argumentos
    public Libro(int id, String titulo, String subtitlo, String autor, int anioPublicacion, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.subtitlo = subtitlo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.precio = precio;
    }

    //Getters and Setters
    //Metodos que permiten acceder a cada uno de los datos y modificarlos
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitlo() {
        return subtitlo;
    }

    public void setSubtitlo(String subtitlo) {
        this.subtitlo = subtitlo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    //Metodo para mostrar el contenido
    //Metodo toSting()

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", subtitlo='" + subtitlo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", precio=" + precio +
                '}';
    }
}//Libro
