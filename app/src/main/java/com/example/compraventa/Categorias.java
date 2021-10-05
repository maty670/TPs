package com.example.compraventa;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Categorias extends AppCompatActivity {

    ArrayList<Item> listDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);


        listDatos=new ArrayList<>();

        recycler=findViewById(R.id.RecyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        llenarDatos();

        AdapterItem adapter = new AdapterItem(listDatos);

        recycler.setAdapter(adapter);

    }

    private void llenarDatos() {
        listDatos.add(new Item(getString(R.string.Accesorios_para_Vehículos),R.drawable.accesorios_vehiculos,"#90948751"));
        listDatos.add(new Item(getString(R.string.Agro),R.drawable.agro,"#90589631"));
        listDatos.add(new Item(getString(R.string.Alimentos_y_Bebidas),R.drawable.alimentos_bebidas,"#90124856"));
        listDatos.add(new Item(getString(R.string.Animales_y_Mascotas),R.drawable.animales_mascotas,"#90974156"));
        listDatos.add(new Item(getString(R.string.Autos_Motos_y_Otros),R.drawable.autos_motos_otros,"#90746829"));
        listDatos.add(new Item(getString(R.string.Bebés),R.drawable.bebes,"#90386851"));
        listDatos.add(new Item(getString(R.string.Belleza_y_Cuidado_Personal),R.drawable.belleza_cuidado,"#90647853"));
        listDatos.add(new Item(getString(R.string.Cámaras_y_Accesorios),R.drawable.camaras_accesorios,"#90124789"));
        listDatos.add(new Item(getString(R.string.Celulares_y_Teléfonos),R.drawable.celulares_telefonos,"#90969853"));
        listDatos.add(new Item(getString(R.string.Computación),R.drawable.computacion,"#90195736"));
        listDatos.add(new Item(getString(R.string.Consolas_y_Videojuegos),R.drawable.consolas_videojuegos,"#90948751"));
        listDatos.add(new Item(getString(R.string.Construcción),R.drawable.construccion,"#90742896"));
        listDatos.add(new Item(getString(R.string.Deportes_y_Fitness),R.drawable.deportes_fitness,"#90174852"));
        listDatos.add(new Item(getString(R.string.Electrodomésticos_y_Aires_Ac),R.drawable.electrodomesticos_aires,"#90571714"));
        listDatos.add(new Item(getString(R.string.Entradas_para_Eventos),R.drawable.entradas_eventos,"#90289385"));
        listDatos.add(new Item(getString(R.string.Herramientas),R.drawable.herramientas,"#90518294"));
        listDatos.add(new Item(getString(R.string.Hogar_Muebles_y_Jardín),R.drawable.hogar_muebles_jardin,"#90856893"));
        listDatos.add(new Item(getString(R.string.Inmuebles),R.drawable.inmuebles,"#90175823"));
        listDatos.add(new Item(getString(R.string.Instrumentos_Musicales),R.drawable.instrumentos_musicales,"#90748963"));
        listDatos.add(new Item(getString(R.string.Joyas_y_Relojes),R.drawable.joyas_relojes,"#90852639"));
        listDatos.add(new Item(getString(R.string.Juegos_y_Juguetes),R.drawable.juegos_juguetes,"#90159357"));
        listDatos.add(new Item(getString(R.string.Libros_Revistas_y_Comics),R.drawable.libros_revistas_comics,"#90719363"));
        listDatos.add(new Item(getString(R.string.Música_Películas_y_Series),R.drawable.musica_peliculas_series,"#90951247"));
        listDatos.add(new Item(getString(R.string.Ropa_y_Accesorios),R.drawable.ropa_accesorios,"#90147852"));
        listDatos.add(new Item(getString(R.string.Salud_y_Equipamiento_Médico),R.drawable.salud_equipamiento_medico,"#90825395"));
        listDatos.add(new Item(getString(R.string.Servicios),R.drawable.servicios,"#90555869"));
        listDatos.add(new Item(getString(R.string.Souvenirs_Cotillón_Fiestas),R.drawable.souvenirs_cotillon_y_fiestas,"#90226937"));
        listDatos.add(new Item(getString(R.string.Otras_categorías),R.drawable.otras_categorias,"#90374185"));


    }

    public void seleccion(View view){
        String nombre = listDatos.get(recycler.getChildAdapterPosition(view)).getNombre();
        int Foto = listDatos.get(recycler.getChildAdapterPosition(view)).getFoto();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("nombre", nombre);
                resultIntent.putExtra("Foto",Foto);
                setResult(RESULT_OK, resultIntent);
                finish();


    }
}