package com.example.myapplication.Descripcion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.datos.Descripcion;
import com.example.myapplication.datos.Peliculas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainDescripcion extends AppCompatActivity {

    RecyclerView listado;
    DescripcionViewModel vm;
    LiveData<Descripcion> data;
    TextView nombre, descripcion, estrellas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_descripcion);

        nombre = findViewById(R.id.idDescNombre);
        descripcion = findViewById(R.id.idDescDescripcion);
        estrellas = findViewById(R.id.idDescestrellas);
        listado = findViewById(R.id.idDescRecycler);

        ResultadoAdapter adapter = new ResultadoAdapter();
        listado.setLayoutManager(new LinearLayoutManager(this));
        listado.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(DescripcionViewModel.class);
        vm.init();
        data = vm.getDescripcionLiveData();
        data.observe(this, data -> {
            adapter.setResults(data.getActores());
        });
        Peliculas peliculas = new Peliculas();
        peliculas = (Peliculas) getIntent().getSerializableExtra("datos");

        nombre.setText(peliculas.getNombre());
        descripcion.setText(peliculas.getDescripcion());
        estrellas.setText(String.valueOf(peliculas.getEstrellas()));
        
        String url = peliculas.getUrl();
        Pattern pattern = Pattern.compile("/(\\d+)/$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String id = matcher.group(1);
            vm.mostrarComentarios(Integer.parseInt(id));
        }
    }
}