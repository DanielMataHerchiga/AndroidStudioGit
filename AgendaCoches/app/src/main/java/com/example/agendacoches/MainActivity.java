package com.example.agendacoches;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button agregar;
    RecyclerView reyclerViewUser;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reyclerViewUser =  findViewById(R.id.recycled);

        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "production")
                .allowMainThreadQueries()
                .build();

        List<Coche> coches = db.cocheDao().getAll();

        reyclerViewUser.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adaptador(coches);
        reyclerViewUser.setAdapter(adapter);

        agregar = findViewById(R.id.agregar);
        agregar.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, CocheNuevo.class));
            finish();
        });

        /*agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CocheNuevo.class));
                finish();
            }
        });*/

        Adaptador adaptador = new Adaptador(coches);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Descripcion.class));
                finish();
            }
        });

        reyclerViewUser.setAdapter(adaptador);
    }
}