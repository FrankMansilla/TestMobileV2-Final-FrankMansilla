package com.example.crudlibro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudlibro.controladores.LibroBD;
import com.example.crudlibro.modelos.Libro;

public class GestionarLibroActivity extends AppCompatActivity implements View.OnClickListener {


    Context context;
    EditText txttitulo, txtsubtitulo, txtautor, txtaniopublicacion, txtprecio;
    int id;

    LibroBD libroBD;

    Button btnguardar,btnactualizar,btnborrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_libro);

        init();
    }

    private void init(){
        context = getApplicationContext();
        txttitulo = findViewById(R.id.ges_txttitulo);
        txtsubtitulo = findViewById(R.id.ges_txtsubtitulo);
        txtautor = findViewById(R.id.ges_txtautor);
        txtaniopublicacion = findViewById(R.id.ges_txtaniopublicacion);
        txtprecio = findViewById(R.id.ges_txtprecio);

        btnguardar = findViewById(R.id.ges_btnGuardar);
        btnactualizar = findViewById(R.id.ges_btnModificar);
        btnborrar = findViewById(R.id.ges_btnEliminar);

        txtaniopublicacion.setInputType(InputType.TYPE_CLASS_NUMBER);
        txtprecio.setInputType(InputType.TYPE_CLASS_NUMBER);
        txttitulo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No se necesita implementar
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validarTitulo();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No se necesita implementar
            }
        });

        txtaniopublicacion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No se necesita implementar
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validarAnioPublicacion();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No se necesita implementar
            }
        });

        txtprecio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No se necesita implementar
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validarPrecio();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No se necesita implementar
            }
        });

        Intent i = getIntent();
        Bundle bolsa = i.getExtras();
        id = bolsa.getInt("id");
        if (id != 0){
            txttitulo.setText( bolsa.getString("titulo") );
            txtsubtitulo.setText( bolsa.getString("subtitulo") );
            txtautor.setText( bolsa.getString("autor") );
            txtaniopublicacion.setText( bolsa.getInt("anio_publicacion") + "" );
            txtprecio.setText( bolsa.getDouble("precio") + "" );

            btnguardar.setEnabled(false);
        }else{
            btnactualizar.setEnabled(false);
            btnborrar.setEnabled(false);
        }
    }

    private void limpiarCampos(){
        id = 0;
        txttitulo.setText( "" );
        txtsubtitulo.setText( "" );
        txtautor.setText( "" );
        txtaniopublicacion.setText( "" );
        txtprecio.setText( "" );
    }


    private Libro llenarDatosLibro(){
        Libro libro = new Libro();
        String t = txttitulo.getText().toString();
        String s = txtsubtitulo.getText().toString();
        String a = txtautor.getText().toString();
        String anio = txtaniopublicacion.getText().toString();
        String precio = txtprecio.getText().toString();

        libro.setId(id);
        libro.setTitulo( t );
        libro.setSubtitlo( s );
        libro.setAutor( a );
        libro.setAnioPublicacion( Integer.parseInt( anio ) );
        libro.setPrecio( Double.parseDouble( precio ) );

        return libro;
    }

   private void guardar(){
        libroBD = new LibroBD(context, "LibrosBD.db", null, 1);//sospechoso
        Libro libro = llenarDatosLibro();
        if(id == 0 ){
            libroBD.agregar(libro);
            Toast.makeText(context, "Guardardado Nuevo OK", Toast.LENGTH_LONG).show();

        } else{
            libroBD.actualizar(id, libro);
            btnactualizar.setEnabled(false);
            btnborrar.setEnabled(false);
            Toast.makeText(context, "Actualizado Existente OK", Toast.LENGTH_LONG).show();
        }
   }

   private void borrar(){
       libroBD = new LibroBD(context, "LibrosBD.db", null, 1);//sospechoso
       Libro libro = llenarDatosLibro();
       if(id == 0 ){
           Toast.makeText(context, "No es posible borrar", Toast.LENGTH_LONG).show();
       } else{
           libroBD.borrar(id);
           limpiarCampos();
           btnguardar.setEnabled(true);
           btnactualizar.setEnabled(false);
           btnborrar.setEnabled(false);
           Toast.makeText(context, "Se borrro el registro", Toast.LENGTH_LONG).show();
       }
   }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ges_btnGuardar ){
            guardar();
        } else if (view.getId() == R.id.ges_btnModificar) {
            guardar();
        } else if (view.getId() == R.id.ges_btnEliminar) {
            borrar();
        }
    }

    private void validarTitulo() {
        String titulo = txttitulo.getText().toString();
        if (!titulo.matches("[a-zA-Z0-9\\s]+")) {
            txttitulo.setError("Solo se permiten letras y números");
            btnguardar.setEnabled(false);
        } else {
            btnguardar.setEnabled(true);
        }

    }

private void validarAnioPublicacion() {
    String anio = txtaniopublicacion.getText().toString();
    if (!anio.matches("\\d+")) {
        txtaniopublicacion.setError("Solo se permiten números");
        btnguardar.setEnabled(false);
    } else {
        btnguardar.setEnabled(true);
    }
}
private void validarPrecio() {
    String precio = txtprecio.getText().toString();
    if (!precio.matches("\\d*\\.?\\d+")) {
        txtprecio.setError("Solo se permiten números y un punto decimal");
        btnguardar.setEnabled(false);
    } else {
        btnguardar.setEnabled(true);
    }
}

}//Gestionar Libro