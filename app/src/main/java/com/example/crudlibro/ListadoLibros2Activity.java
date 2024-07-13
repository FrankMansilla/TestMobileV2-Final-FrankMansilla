package com.example.crudlibro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.crudlibro.controladores.LibroBD;
import com.example.crudlibro.controladores.SelectListener;
import com.example.crudlibro.modelos.Libro;

import java.util.List;

public class ListadoLibros2Activity extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    List<Libro> listaLibros;
    LibroBD libroBD;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_libros2);
        init();
    }

    private void init(){
        context = this.getApplicationContext();
        libroBD = new LibroBD(context, "LibrosBD.db", null, 1);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        llenarRecyclerView();
    }

    private void llenarRecyclerView(){
        //Crear el objeto para los nombres de libros
        listaLibros = libroBD.lista();

        //Array para los datos de los libros
        AdapterRecyclerViewLibros adapter = new AdapterRecyclerViewLibros(
                context, listaLibros, this);

        //Se añade el Adaptador al RecyclerView
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String titulo) {

    }

    @Override
    public void onItemClick(int id) {
        Libro libro = libroBD.elemento( id );

        Bundle bolsa = new Bundle();
        bolsa.putInt("id", libro.getId() );
        bolsa.putString("titulo", libro.getTitulo() );
        bolsa.putString("subtitulo", libro.getSubtitlo() );
        bolsa.putString("autor", libro.getAutor() );
        bolsa.putInt("anio_publicacion", libro.getAnioPublicacion() );
        bolsa.putDouble("precio", libro.getPrecio() );

        Intent i = new Intent(context, GestionarLibroActivity.class);
        i.putExtras(bolsa);
        startActivity(i);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        init();
    }
}
