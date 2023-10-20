package com.example.calculadorafastapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    RadioButton suma, resta, mult, div;
    RadioGroup grupo;
    Button enviar;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        grupo = findViewById(R.id.grupo);
        enviar = findViewById(R.id.enviar);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        mult = findViewById(R.id.mult);
        res = findViewById(R.id.result);
        div = findViewById(R.id.div);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numero1 = Integer.parseInt(num1.getText().toString());
                int numero2 = Integer.parseInt(num2.getText().toString());
                if(grupo.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "Seleccione una operacion", Toast.LENGTH_SHORT).show();
                }else{
                    if (suma.isChecked()){
                        Call<Resultado> llamada = CalculdaraAPI.getInstance().suma(numero1, numero2);

                        llamada.enqueue(new Callback<Resultado>() {
                            @Override
                            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                                Resultado resFinal = response.body();
                                res.setText(resFinal.resultado);
                            }

                            @Override
                            public void onFailure(Call<Resultado> call, Throwable t) {

                            }
                        });

                    }else if (resta.isChecked()){
                        Call<Resultado> llamada = CalculdaraAPI.getInstance().resta(numero1, numero2);

                        llamada.enqueue(new Callback<Resultado>() {
                            @Override
                            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                                Resultado resFinal = response.body();
                                res.setText(resFinal.resultado);
                            }

                            @Override
                            public void onFailure(Call<Resultado> call, Throwable t) {

                            }
                        });
                    }else if (mult.isChecked()){
                        Call<Resultado> llamada = CalculdaraAPI.getInstance().multiplicacion(numero1, numero2);

                        llamada.enqueue(new Callback<Resultado>() {
                            @Override
                            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                                Resultado resFinal = response.body();
                                res.setText(resFinal.resultado);
                            }

                            @Override
                            public void onFailure(Call<Resultado> call, Throwable t) {

                            }
                        });
                    }else if (div.isChecked()){
                        Call<Resultado> llamada = CalculdaraAPI.getInstance().division(numero1, numero2);

                        llamada.enqueue(new Callback<Resultado>() {
                            @Override
                            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                                Resultado resFinal = response.body();
                                res.setText(resFinal.resultado);
                            }

                            @Override
                            public void onFailure(Call<Resultado> call, Throwable t) {

                            }
                        });
                    }
                }
            }
        });

    }
}