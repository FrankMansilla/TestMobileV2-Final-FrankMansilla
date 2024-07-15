package com.example.crudlibro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button btnListar, btnBuscar, btnRegistrar, btnListar2, btntutorial;

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    FourthFragment fourthFragment = new FourthFragment();
    FifthFragment fifthFragment = new FifthFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.btn_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        init();
    }


    //Bottom Navigation
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int itemId = item.getItemId();

            if (itemId == R.id.firstFragment) {
                loadFragment(firstFragment);
                Intent intent = new Intent(context, GestionarLibroActivity.class);
                Toast.makeText(context, "Registrar", Toast.LENGTH_SHORT).show();
                Bundle bolsa = new Bundle();
                bolsa.putInt("id", 0);
                intent.putExtras(bolsa);

                startActivity(intent);
                return true;
            } else if (itemId == R.id.secondFragment) {
                loadFragment(secondFragment);
                Intent intent = new Intent(context, BuscarLibroActivity.class);
                startActivity(intent);
                Toast.makeText(context, "Buscar", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.thirdFragment) {
                loadFragment(thirdFragment);
                Intent intent = new Intent(context, ListadoLibrosActivity.class);
                startActivity(intent);
                Toast.makeText(context, "Listar", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.fourthFragment) {
                loadFragment(fourthFragment);
                Intent intent = new Intent(context, ListadoLibros2Activity.class);
                startActivity(intent);
                Toast.makeText(context, "Listar 2 (ReciclerView)", Toast.LENGTH_SHORT).show();
                return true;
            }
            else if (itemId == R.id.fifthFragment) {
                loadFragment(fifthFragment);
                Intent intent = new Intent(context, EmbedVideoYoutube.class);
                startActivity(intent);
                Toast.makeText(context, "Turorial", Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        }
    };



    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


    //Init View Objects
    private void init() {
        context = getApplicationContext();
        btnRegistrar = findViewById(R.id.btnregistrar);
        btnBuscar = findViewById(R.id.btnbuscar);
        btnListar = findViewById(R.id.btnlistar);
        btnListar2 = findViewById(R.id.btnlistar2);
        btntutorial = findViewById(R.id.btntutorial);
    }


    //Buttom OnClick
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
            Toast.makeText(context, "Tutorial", Toast.LENGTH_SHORT).show();
        }
    }
}