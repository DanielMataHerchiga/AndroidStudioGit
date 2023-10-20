package com.example.myapplication;


import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Descripcion.MainDescripcion;
import com.example.myapplication.api.PeliculasModel;
import com.example.myapplication.datos.Descripcion;
import com.example.myapplication.datos.Peliculas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadoHolder> {
    private List<Peliculas> resultados = new ArrayList<>();
    public interface ItemClickListener {
        void onClick(View v, Peliculas peliculas);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ResultadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pelicula_row, parent, false);

        return new ResultadoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoHolder holder, int position) {
        Peliculas peliculas = resultados.get(position);

        holder.nombre.setText(peliculas.getNombre());

       /* String texto = peliculas.getDescripcion();
        String[] palabras = texto.split(" ");
        String primerasCincoPalabras = "";
        for (int i = 0; i < Math.min(palabras.length, 5); i++) {

            primerasCincoPalabras += palabras[i] + " ";
        }*/

        String texto = peliculas.getDescripcion();
        String[] palabras = texto.split("\\s+");
        String primerasCincoPalabras = "";
        int numPalabras = 5;
        if (palabras.length < 5) {
            numPalabras = palabras.length;
        }
        for (int i = 0; i < numPalabras; i++) {
            primerasCincoPalabras += palabras[i] + " ";
        }

        holder.descripcion.setText(primerasCincoPalabras);
        holder.estrellas.setText(String.valueOf(peliculas.getEstrellas()));
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public void setResults(List<Peliculas> results) {
        this.resultados.clear();
        this.resultados.addAll(results);
        notifyDataSetChanged();
    }
    class ResultadoHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private TextView nombre;
        private TextView descripcion;
        private TextView estrellas;

        @Override
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onClick(v, resultados.get(getAdapterPosition()));
            }
            Peliculas peliculas = resultados.get(getAdapterPosition());
            Intent intent = new Intent(v.getContext(), MainDescripcion.class);
            intent.putExtra("datos", peliculas);
            v.getContext().startActivity(intent);
        }
        public ResultadoHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            estrellas = itemView.findViewById(R.id.idEstrellas);

            itemView.setOnClickListener(this);
        }

    }
}

