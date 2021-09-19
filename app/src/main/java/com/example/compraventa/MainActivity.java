package com.example.compraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText txtTitulo;
    public EditText txtDescripcion;
    public EditText txtCorreo;
    public EditText txtPrecio;
    public Button   BtnAceptar;
    public Spinner SpinnerCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.editTitulo);
        txtDescripcion = findViewById(R.id.editDescripcion);
        txtCorreo = findViewById(R.id.editCorreo);
        txtPrecio = findViewById(R.id.editPrecio);
        SpinnerCategorias = findViewById(R.id.spinnerCategoria);
        BtnAceptar = findViewById(R.id.buttonAceptar);
    }

    public void ValidarCampos(View view) {
        if (txtTitulo.getText().toString().equals("") || txtCorreo.getText().toString().equals("") || txtPrecio.getText().toString().equals(""))
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();

        String seleccion = SpinnerCategorias.getSelectedItem().toString();
        Toast.makeText(this, seleccion, Toast.LENGTH_SHORT).show();
    }
}