package com.ciglesias.contactos;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtNombre, edtTelefono, edtDescripcion, edtCorreo;
    DatePicker dtpFechaNacimiento;
    Button btnSiguiente;

    public static String KEY_NOMBRE = "", KEY_FECHA = "", KEY_TELEFONO = "", KEY_CORREO = "", KEY_DESCRIPCION = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        KEY_CORREO = getResources().getString(R.string.key_correo);
        KEY_NOMBRE = getResources().getString(R.string.key_nombre);
        KEY_FECHA = getResources().getString(R.string.key_fecha);
        KEY_TELEFONO = getResources().getString(R.string.key_telefono);
        KEY_DESCRIPCION = getResources().getString(R.string.key_descripcion);

        edtNombre = (TextInputEditText) findViewById(R.id.id_edt_nombre);
        edtTelefono = (TextInputEditText) findViewById(R.id.id_edt_telefono);
        edtCorreo = (TextInputEditText) findViewById(R.id.id_edt_correo);
        edtDescripcion = (TextInputEditText) findViewById(R.id.id_edt_descripcion);

        dtpFechaNacimiento = (DatePicker) findViewById(R.id.id_date);

        btnSiguiente = (Button) findViewById(R.id.id_btn_siguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos(v);
            }
        });

        if(getIntent().getExtras() != null){

            edtNombre.setText(getIntent().getExtras().getString(MainActivity.KEY_NOMBRE));
            edtTelefono.setText(getIntent().getExtras().getString(MainActivity.KEY_TELEFONO));

            edtCorreo.setText(getIntent().getExtras().getString(MainActivity.KEY_CORREO));
            edtDescripcion.setText(getIntent().getExtras().getString(MainActivity.KEY_DESCRIPCION));

            Snackbar.make(edtCorreo, getResources().getString(R.string.str_snack_cargado), Snackbar.LENGTH_LONG).show();
        }

    }

    private void guardarDatos(View v) {
        String nombre = edtNombre.getText().toString();
        String telefono = edtTelefono.getText().toString();
        String correo = edtCorreo.getText().toString();
        String descripcion = edtDescripcion.getText().toString();

        String fecha = dtpFechaNacimiento.getDayOfMonth() + "/" + dtpFechaNacimiento.getMonth() + "/" + dtpFechaNacimiento.getYear();

        Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);

        i.putExtra(KEY_NOMBRE, nombre);
        i.putExtra(KEY_TELEFONO,telefono);
        i.putExtra(KEY_FECHA, fecha);
        i.putExtra(KEY_CORREO,correo);
        i.putExtra(KEY_DESCRIPCION, descripcion);
        startActivity(i);
        finish();
    }
}
