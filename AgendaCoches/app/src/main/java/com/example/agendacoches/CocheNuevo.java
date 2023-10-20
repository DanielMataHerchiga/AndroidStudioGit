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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CocheNuevo extends AppCompatActivity {

    EditText marca;
    EditText modelo;
    EditText descrip;
    Button agregar, volver;
    //private static final String TAG = "mainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche_nuevo);

        marca = findViewById(R.id.marca);
        modelo = findViewById(R.id.modelo);
        descrip = findViewById(R.id.descrip);
        agregar =findViewById(R.id.enviar);
        volver = findViewById(R.id.volverM);

        final AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "production")
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

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(marca.getText().toString().equals("") || modelo.getText().toString().equals("") || descrip.getText().toString().equals("")){
                    Toast.makeText(CocheNuevo.this, "FALTAN CAMPOS POR COMPLETAR", Toast.LENGTH_LONG).show();
                }else {
                    Coche coche = new Coche(marca.getText().toString(), modelo.getText().toString(), descrip.getText().toString());
                    db.cocheDao().insertAll(coche);
                    Intent intent = new Intent(CocheNuevo.this, MainActivity.class);
                    someActivityResultLauncher.launch(intent);
                    finish();
                }
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CocheNuevo.this, MainActivity.class);
                someActivityResultLauncher.launch(intent);
                finish();
            }
        });
      /* INTENT ANTIGUO
       agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coche coche = new Coche(marca.getText().toString(), modelo.getText().toString());
                db.cocheDao().insertAll(coche);
                startActivity(new Intent(CocheNuevo.this, MainActivity.class));
            }
        });*/
    }
}