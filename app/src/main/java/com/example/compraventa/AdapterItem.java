package com.example.compraventa;

import android.graphics.Color;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder>{

    ArrayList<Item> listaItems;


    public AdapterItem(ArrayList<Item> listaItems) {
        this.listaItems = listaItems;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.txtnombre.setText(listaItems.get(position).getNombre());
        holder.Imagefoto.setImageResource(listaItems.get(position).getFoto());
        holder.Barra.setBackgroundColor(Color.parseColor( listaItems.get(position).getColor()));
    }

    @Override
    public int getItemCount() {
        return listaItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtnombre;
        ImageView Imagefoto;
        ImageView Barra;



        public ViewHolder(View itemView) {
            super(itemView);
            txtnombre=itemView.findViewById(R.id.idDato);
            Imagefoto=itemView.findViewById(R.id.idImagen);
            Barra=itemView.findViewById(R.id.idBarra);
        }
    }
}
