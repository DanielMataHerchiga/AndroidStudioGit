package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.datos.Peliculas;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView listado;
    PeliculasViewModel vm;
    LiveData<List<Peliculas>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = findViewById(R.id.idRecycler);

        ResultadoAdapter adapter = new ResultadoAdapter();
        listado.setLayoutManager(new LinearLayoutManager(this));
        listado.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(PeliculasViewModel.class);
        vm.init();
        data = vm.getPeliculasLiveData();
        data.observe(this, data -> {
            adapter.setResults(data);
        });

        vm.mostrarTodo();
    }
}