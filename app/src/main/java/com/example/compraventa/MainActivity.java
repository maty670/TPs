package com.example.compraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText txtTitulo;
    public EditText txtDescripcion;
    public EditText txtCorreo;
    public EditText txtPrecio;
    public Button BtnAceptar;
    public Spinner SpinnerCategorias;
    public TextView textoDescuento;
    public Switch SwitchDescuento;
    public SeekBar SeekBarDescuento;


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
        SeekBarDescuento = findViewById(R.id.seekBarDescuento);
        textoDescuento = findViewById(R.id.textViewDescuento);
        SwitchDescuento = findViewById(R.id.switchDescuento);

        BarraDescuentos(SeekBarDescuento);


    }

    public void ValidarCampos(View view) {
        if (txtTitulo.getText().toString().equals("") || txtCorreo.getText().toString().equals("") || txtPrecio.getText().toString().equals(""))
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();


    }
    public void ActivarDescuento(View view) {
        if (SwitchDescuento.isChecked()) {
            SeekBarDescuento.setVisibility(View.VISIBLE);
            textoDescuento.setVisibility(View.VISIBLE);
        }
        else{
            SeekBarDescuento.setVisibility(View.INVISIBLE);
            textoDescuento.setVisibility(View.INVISIBLE);
        }
    }

    public void BarraDescuentos(View view) {
            {

                // Valor Inicial
                SeekBarDescuento.setProgress(0);
                // Valot Final
                SeekBarDescuento.setMax(100);

                SeekBarDescuento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        textoDescuento.setText(String.valueOf(progress) + "%");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                });
            }
    }




}

