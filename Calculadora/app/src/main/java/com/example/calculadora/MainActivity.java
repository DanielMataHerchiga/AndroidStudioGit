package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultado;
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button bsuma;
    Button bresta;
    Button bdivision;
    Button bmulti;
    Button bigual;
    Button breset;
    Button bcoma;
    Button bquitar;
    Button bporcent;

    float num1;
    float num2;

    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        resultado.setOnClickListener(this);

        b0 = findViewById(R.id.numero0);
        b0.setOnClickListener(this);

        b1 = findViewById(R.id.numero1);
        b1.setOnClickListener(this);

        b2 = findViewById(R.id.numero2);
        b2.setOnClickListener(this);

        b3 = findViewById(R.id.numero3);
        b3.setOnClickListener(this);

        b4 = findViewById(R.id.numero4);
        b4.setOnClickListener(this);

        b5 = findViewById(R.id.numero5);
        b5.setOnClickListener(this);

        b6 = findViewById(R.id.numero6);
        b6.setOnClickListener(this);

        b7 = findViewById(R.id.numero7);
        b7.setOnClickListener(this);

        b8 = findViewById(R.id.numero8);
        b8.setOnClickListener(this);

        b9 = findViewById(R.id.numero9);
        b9.setOnClickListener(this);

        bsuma = findViewById(R.id.suma);
        bsuma.setOnClickListener(this);

        bresta= findViewById(R.id.resta);
        bresta.setOnClickListener(this);

        bmulti= findViewById(R.id.multi);
        bmulti.setOnClickListener(this);

        bdivision = findViewById(R.id.division);
        bdivision.setOnClickListener(this);

        bigual= findViewById(R.id.igual);
        bigual.setOnClickListener(this);

        breset= findViewById(R.id.bAC);
        breset.setOnClickListener(this);

        bcoma= findViewById(R.id.coma);
        bcoma.setOnClickListener(this);

        bquitar= findViewById(R.id.quitarNumero);
        bquitar.setOnClickListener(this);

        bporcent = findViewById(R.id.porcentaje);
        bporcent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        if (view.getId()==b0.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("0");
            }else {
                resultado.setText(texto + "0");
            }
        }

        if (view.getId()==b1.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("1");
            }else {
                resultado.setText(texto + "1");
            }
        }
        if (view.getId()==b2.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("2");
            }else {
                resultado.setText(texto + "2");
            }
        }
        if (view.getId()==b3.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("3");
            }else {
                resultado.setText(texto + "3");
            }
        }

        if (view.getId()==b4.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("4");
            }else {
                resultado.setText(texto + "4");
            }
        }

        if (view.getId()==b5.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("5");
            }else {
                resultado.setText(texto + "5");
            }
        }

        if (view.getId()==b6.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("6");
            }else {
                resultado.setText(texto + "6");
            }
        }

        if (view.getId()==b7.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("7");
            }else {
                resultado.setText(texto + "7");
            }
        }

        if (view.getId()==b8.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("8");
            }else {
                resultado.setText(texto + "8");
            }
        }

        if (view.getId()==b9.getId()){
            CharSequence texto = resultado.getText().toString();
            if(texto.equals("0")){
                resultado.setText("9");
            }else {
                resultado.setText(texto + "9");
            }
        }

        if (view.getId() == bsuma.getId()){
            CharSequence texto = resultado.getText();
            num1 = Float.parseFloat(texto.toString());
            resultado.setText("0");
            operacion = "+";
        }

        if (view.getId() == bresta.getId()){
            CharSequence texto = resultado.getText();
            num1 = Float.parseFloat(texto.toString());
            resultado.setText("0");
            operacion="-";
        }

        if (view.getId() == bmulti.getId()){
            CharSequence texto = resultado.getText();
            num1 = Float.parseFloat(texto.toString());
            resultado.setText("0");
            operacion="*";
        }

        if (view.getId() == bdivision.getId()){
            CharSequence texto = resultado.getText();
            num1 = Float.parseFloat(texto.toString());
            resultado.setText("0");
            operacion="/";
        }

        if (view.getId() == breset.getId()){
            resultado.setText("0");
            operacion = "ac";
        }

        if (view.getId() == bquitar.getId()){
            CharSequence texto = resultado.getText();
            if(texto.equals("0")){
                resultado.setText("0");
            }else if (texto.length()==1){
                resultado.setText("0");
            }else resultado.setText(texto.subSequence(0, texto.length()-1));
        }

        if (view.getId() == bcoma.getId()) {
            CharSequence texto = resultado.getText();
            if (!texto.toString().contains(".")) {
                if (texto.equals("0")) {
                    resultado.setText("0.");
                } else {
                    resultado.setText(resultado.getText() + ".");
                }
            }
        }

        if(view.getId()== bporcent.getId()){
            CharSequence texto = resultado.getText();
            num1 = Float.parseFloat(texto.toString());
            resultado.setText("0");
            operacion="%";
        }

        if(view.getId() == bigual.getId()){
            CharSequence texto = resultado.getText();
            num2 = Float.parseFloat(texto.toString());
            if (operacion.equals("+")) {
                float suma = num1 + num2;
                CharSequence resultado1 = String.valueOf(suma);
                resultado.setText(resultado1);
            }
            if (operacion.equals("-")){
                float resta = num1 - num2;
                CharSequence resultado1 = String.valueOf(resta);
                resultado.setText(resultado1);
            }
            if (operacion.equals("*")){
                float multi = num1 * num2;
                CharSequence resultado1 = String.valueOf(multi);
                resultado.setText(resultado1);
            }
            if (operacion.equals("/")){
                if(num2 == 0){
                    resultado.setText("ERROR");
                }else {
                    float div = num1 / num2;
                    CharSequence resultado1 = String.valueOf(div);
                    resultado.setText(resultado1);
                }
            }
            if (operacion.equals("ac")){
                resultado.setText("0");
            }
            if (operacion.equals("%")){
                float porcent = (num1*num2)/100;
                CharSequence resultado1 = String.valueOf(porcent);
                resultado.setText(resultado1);
            }
        }
    }
}

