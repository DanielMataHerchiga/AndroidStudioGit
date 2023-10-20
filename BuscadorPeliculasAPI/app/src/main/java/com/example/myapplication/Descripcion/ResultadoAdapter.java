package com.example.myapplication.Descripcion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.datos.Actores;
import com.example.myapplication.datos.Descripcion;
import java.util.ArrayList;
import java.util.List;

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadoHolder> {
    private List<Actores> resultados = new ArrayList<>();

    public interface ItemClickListener {
        void onClick(View v, Descripcion descripcion);
    }

    @NonNull
    @Override
    public ResultadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actores_row, parent, false);

        return new ResultadoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoHolder holder, int position) {
        Actores actor = resultados.get(position);

        holder.nombre.setText(actor.getNombre());
    }


    @Override
    public int getItemCount() {
        return resultados.size();
    }

    //notificar al recycler view de que hay nueva info
    public void setResults(List<Actores> results) {
        this.resultados.clear();
        this.resultados.addAll(results);
        notifyDataSetChanged();
    }
    class ResultadoHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView pelicula;

        public ResultadoHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.idActorNombre);
            pelicula = itemView.findViewById(R.id.idActorPelicula);
        }

    }
}
