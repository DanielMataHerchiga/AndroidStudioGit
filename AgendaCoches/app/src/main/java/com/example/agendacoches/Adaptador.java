package com.example.agendacoches;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> implements View.OnClickListener{

    List<Coche> datos;
    private View.OnClickListener listener;
    public Adaptador(List<Coche> datos){
        this.datos=datos;
    }

    @Override
    public Adaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptador, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adaptador.ViewHolder holder, int position) {
        Coche c = datos.get(position);
        holder.marca.setText(c.getMarca());
        holder.modelo.setText(c.getModelo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.itemView.getContext(), Descripcion.class);
                i.putExtra("datos", c);
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView marca;
        public TextView modelo;

        public ViewHolder(View view) {
            super(view);
            marca = view.findViewById(R.id.t1);
            modelo = view.findViewById(R.id.t2);
        }
    }
}
