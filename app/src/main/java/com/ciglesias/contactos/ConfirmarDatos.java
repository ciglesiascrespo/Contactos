package com.ciglesias.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    TextView txtNombre, txtFecha, txtCorreo, txtDescripcion, txtTelefono;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        txtNombre = (TextView) findViewById(R.id.id_txt_nombre);
        txtTelefono = (TextView) findViewById(R.id.id_txt_telefono);
        txtFecha = (TextView) findViewById(R.id.id_txt_fecha_nacimiento);
        txtCorreo = (TextView) findViewById(R.id.id_txt_mail);
        txtDescripcion = (TextView) findViewById(R.id.id_txt_descripcion);

        txtNombre.setText(getIntent().getExtras().getString(MainActivity.KEY_NOMBRE));
        txtTelefono.setText(getIntent().getExtras().getString(MainActivity.KEY_TELEFONO));
        txtFecha.setText(getIntent().getExtras().getString(MainActivity.KEY_FECHA));
        txtCorreo.setText(getIntent().getExtras().getString(MainActivity.KEY_CORREO));
        txtDescripcion.setText(getIntent().getExtras().getString(MainActivity.KEY_DESCRIPCION));

        btnEditar = (Button) findViewById(R.id.id_btn_editar_datos);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConfirmarDatos.this, MainActivity.class);

                i.putExtra(MainActivity.KEY_NOMBRE, getIntent().getExtras().getString(MainActivity.KEY_NOMBRE));
                i.putExtra(MainActivity.KEY_TELEFONO, getIntent().getExtras().getString(MainActivity.KEY_TELEFONO));
                i.putExtra(MainActivity.KEY_FECHA, getIntent().getExtras().getString(MainActivity.KEY_FECHA));
                i.putExtra(MainActivity.KEY_CORREO, getIntent().getExtras().getString(MainActivity.KEY_CORREO));
                i.putExtra(MainActivity.KEY_DESCRIPCION, getIntent().getExtras().getString(MainActivity.KEY_DESCRIPCION));
                startActivity(i);
                finish();
            }
        });

    }
}
