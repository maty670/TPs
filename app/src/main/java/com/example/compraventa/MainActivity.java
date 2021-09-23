package com.example.compraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    public Spinner SpinnerCategorias;
    public TextView txtDescuento;
    public Switch SwitchDescuento;
    public SeekBar SeekBarDescuento;
    public CheckBox CheckBoxTerminos;
    public Button BtnAceptar;

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
        txtDescuento = findViewById(R.id.textViewDescuento);
        SwitchDescuento = findViewById(R.id.switchDescuento);
        CheckBoxTerminos = findViewById(R.id.checkBoxTerminos);
        BarraDescuentos(SeekBarDescuento);


    }

    public void ValidarCampos(View view) {
        String Titulo = txtTitulo.getText().toString();
        String Precio = txtPrecio.getText().toString();
        String Correo = txtCorreo.getText().toString();
        Boolean DescuentoCheck = SwitchDescuento.isChecked();
        Boolean DescuentoNoCheck = !SwitchDescuento.isChecked();
        int Descuento = SeekBarDescuento.getProgress();
        Boolean TerminosCheck = CheckBoxTerminos.isChecked();
        Boolean TerminosNoCheck = !CheckBoxTerminos.isChecked();


        if (Titulo.equals("") | Precio.equals(""))
            Toast.makeText(this,"Campos Titulo y Precio no pueden estar vacios", Toast.LENGTH_SHORT).show();
        else if(Integer.parseInt(Precio)<=0)
            Toast.makeText(this, "El precio debe ser mayor a 0", Toast.LENGTH_SHORT).show();
        else if(Correo.length()>0 & (!(Correo.contains("@")) | !(Correo.lastIndexOf("@")<Correo.length()-3))) {
            Toast.makeText(this, "Correo debe contener al menos 1 @ seguido de 3 letras", Toast.LENGTH_SHORT).show();
        }
        else if(DescuentoCheck & Descuento==0){
            Toast.makeText(this, "Descuento debe ser mayor a 0%", Toast.LENGTH_SHORT).show();
        }else if (TerminosNoCheck)
            Toast.makeText(this, "Debe aceptar los terminos y condiciones", Toast.LENGTH_SHORT).show();

    }

    public void ActivarDescuento(View view) {
        if (SwitchDescuento.isChecked()) {
            SeekBarDescuento.setVisibility(View.VISIBLE);
            txtDescuento.setVisibility(View.VISIBLE);
        }
        else{
            SeekBarDescuento.setVisibility(View.GONE);
            txtDescuento.setVisibility(View.GONE);
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
                        txtDescuento.setText(String.valueOf(progress) + "%");
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

