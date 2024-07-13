package com.example.crudlibro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button btnListar, btnBuscar, btnRegistrar, btnListar2, btntutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        context = getApplicationContext();
        btnRegistrar = findViewById(R.id.btnregistrar);
        btnBuscar = findViewById(R.id.btnbuscar);
        btnListar = findViewById(R.id.btnlistar);
        btnListar2 = findViewById(R.id.btnlistar2);
        btntutorial = findViewById(R.id.btntutorial);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnregistrar) {
            Intent intent = new Intent(context, GestionarLibroActivity.class);
            Toast.makeText(context, "Registrar", Toast.LENGTH_SHORT).show();
            Bundle bolsa = new Bundle();
            bolsa.putInt("id", 0);
            intent.putExtras(bolsa);

            startActivity(intent);
        } else if (view.getId() == R.id.btnbuscar) {
            Intent intent = new Intent(context, BuscarLibroActivity.class);
            startActivity(intent);
            Toast.makeText(context, "Buscar", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnlistar) {
            Intent intent = new Intent(context, ListadoLibrosActivity.class);
            startActivity(intent);
            Toast.makeText(context, "Listar", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btnlistar2) {
            Intent intent = new Intent(context, ListadoLibros2Activity.class);
            startActivity(intent);
            Toast.makeText(context, "Listar2", Toast.LENGTH_SHORT).show();
        }else if (view.getId() == R.id.btntutorial) {
            Intent intent = new Intent(context, EmbedVideoYoutube.class);
            startActivity(intent);
            Toast.makeText(context, "Listar2", Toast.LENGTH_SHORT).show();
        }
    }
}