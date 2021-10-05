package com.example.compraventa;

import android.graphics.Color;

public class Item {
    private String nombre;
    private int foto;
    private String color;

    public Item(String nombre, int foto, String color) {
        this.nombre = nombre;
        this.foto = foto;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}