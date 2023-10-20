package com.example.agendacoches;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Descripcion extends AppCompatActivity {

    TextView marca1, modelo1, descripcion;
    Button borrar1, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        marca1 = findViewById(R.id.marca1);
        modelo1 = findViewById(R.id.modelo1);
        descripcion = findViewById(R.id.descripcion);
        borrar1 = findViewById(R.id.borrar1);
        volver = findViewById(R.id.volverMain);

        Coche coche = (Coche) getIntent().getSerializableExtra("datos");

        marca1.setText(coche.getMarca());
        modelo1.setText(coche.getModelo());
        descripcion.setText(coche.getDescrip());


        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "production")
                .allowMainThreadQueries()
                .build();

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()== Activity.RESULT_OK){
                            Intent data = result.getData();
                            finish();
                        }
                    }
                }
        );

        borrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Coche coche = (Coche) getIntent().getSerializableExtra("datos");
                db.cocheDao().delete(coche);
                Intent intent = new Intent(Descripcion.this, MainActivity.class);
                someActivityResultLauncher.launch(intent);
                finish();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Descripcion.this, MainActivity.class);
                someActivityResultLauncher.launch(intent);
                finish();
            }
        });

       /* ANTIGUO INTENT
       borrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coche coche = (Coche) getIntent().getSerializableExtra("datos");
                db.cocheDao().delete(coche);
                startActivity(new Intent(Descripcion.this, MainActivity.class));
            }
        });*/
    }
}