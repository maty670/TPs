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

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public EditText txtTitulo;
    public EditText txtDescripcion;
    public EditText txtCorreo;
    public EditText txtPrecio;
    public TextView Retiro;
    public EditText txtRetiro;
    public Spinner SpinnerCategorias;
    public TextView txtDescuento;
    public Switch SwitchDescuento;
    public SeekBar SeekBarDescuento;
    public CheckBox CheckBoxRetiro;
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
        SeekBarDescuento = findViewById(R.id.seekBarDescuento);
        txtDescuento = findViewById(R.id.textViewDescuento);
        SwitchDescuento = findViewById(R.id.switchDescuento);
        CheckBoxRetiro = findViewById(R.id.checkBoxRetiro);
        Retiro =findViewById(R.id.txtRetiro);
        txtRetiro = findViewById(R.id.editRetiro);
        CheckBoxTerminos = findViewById(R.id.checkBoxTerminos);
        BarraDescuentos(SeekBarDescuento);
        BtnAceptar = findViewById(R.id.buttonAceptar);


    }

    public void ValidarCampos(View view) {

        String Titulo = txtTitulo.getText().toString();
        String Descripcion= txtDescripcion.getText().toString();
        String Correo = txtCorreo.getText().toString();
        String Precio= txtPrecio.getText().toString();
        String Retiro= txtRetiro.getText().toString();


        Boolean TituloVacio = txtTitulo.getText().toString().equals("");
        Boolean DescripcionVacio = txtDescripcion.getText().toString().equals("");
        Boolean PrecioVacio = txtPrecio.getText().toString().equals("");
        Boolean CorreoVacio = txtCorreo.getText().toString().equals("");
        Boolean RetiroVacio = txtRetiro.getText().toString().equals("");


        Boolean Titulovalido = Pattern.matches("[a-zA-Z0-9,. ]+",Titulo);
        Boolean Descripcionvalido = Pattern.matches("[a-zA-Z0-9,. ]+",Descripcion);
        Boolean RetiroValido = Pattern.matches("[a-zA-Z0-9,. ]+",Retiro);


        Boolean DescuentoCheck = SwitchDescuento.isChecked();
        Boolean DescuentoNoCheck = !SwitchDescuento.isChecked();
        int Descuento = SeekBarDescuento.getProgress();

        Boolean RetiroCheck = CheckBoxRetiro.isChecked();
        Boolean RetiroNoCheck = CheckBoxRetiro.isChecked();

        Boolean TerminosCheck = CheckBoxTerminos.isChecked();
        Boolean TerminosNoCheck = !CheckBoxTerminos.isChecked();




        if (TituloVacio | PrecioVacio | (RetiroCheck & RetiroVacio ))
            Toast.makeText(this,"Titulo, Precio y Direccion de Retiro no pueden estar vacios", Toast.LENGTH_SHORT).show();
        else if(Long.parseLong(Precio)<=0)
            Toast.makeText(this, "El precio debe ser mayor a 0", Toast.LENGTH_SHORT).show();
        else if(!CorreoVacio & (!(Correo.contains("@")) | !(Correo.lastIndexOf("@")<Correo.length()-3)))
            Toast.makeText(this, "Correo debe contener al menos 1 @ seguido de 3 letras", Toast.LENGTH_SHORT).show();
        else if (!Titulovalido | (!DescripcionVacio & !Descripcionvalido) | (RetiroCheck & !RetiroValido & !RetiroVacio))
            Toast.makeText(this, "TEXTO INVALIDO: solo se permiten letras(mayusculas o minusculas), numeros, comas, puntos o saltos de linea", Toast.LENGTH_LONG).show();
        else if(DescuentoCheck & Descuento<=0)
            Toast.makeText(this, "Descuento debe ser mayor a 0%", Toast.LENGTH_SHORT).show();
        else if (TerminosNoCheck)
            Toast.makeText(this, "Debe aceptar los terminos y condiciones", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Formulario guardado con exito", Toast.LENGTH_SHORT).show();


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

    public void ActivarRetiro(View view) {
        if (CheckBoxRetiro.isChecked()) {
            Retiro.setVisibility(View.VISIBLE);
            txtRetiro.setVisibility(View.VISIBLE);
        }
        else{
            Retiro.setVisibility(View.GONE);
            txtRetiro.setVisibility(View.GONE);
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

