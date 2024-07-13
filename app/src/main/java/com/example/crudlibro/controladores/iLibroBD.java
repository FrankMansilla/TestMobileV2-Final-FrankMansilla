package com.example.crudlibro.controladores;

import com.example.crudlibro.modelos.Libro;

import java.util.List;

public interface iLibroBD {




    Libro elemento (int id);//Devuelve un elemento de la tabla libro a partir de su id
    Libro elemento (String title);//devuelve un elemento dado su titutlo exacto

    List<Libro> lista();//Devuelve una lista de libros

    void agregar(Libro book);
    void actualizar(int id, Libro book);
    void borrar(int id);


}
