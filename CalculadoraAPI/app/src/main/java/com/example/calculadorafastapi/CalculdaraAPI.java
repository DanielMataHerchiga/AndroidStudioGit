package com.example.calculadorafastapi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalculdaraAPI {

    private  static CalculdaraAPI instancia = null;

    CalculadoraService servicio;

    private CalculdaraAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.20.207:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio = retrofit.create(CalculadoraService.class);
    }

    public static CalculdaraAPI getInstance(){
        if(instancia==null){
            instancia = new CalculdaraAPI();
        }
        return instancia;
    }

    public Call<Resultado> suma(int n1, int n2){
        return servicio.suma(n1,n2);
    }

    public Call<Resultado> resta(int n1, int n2){
        return servicio.resta(n1,n2);
    }

    public Call<Resultado> multiplicacion(int n1, int n2){
        return servicio.multiplicacion(n1,n2);
    }

    public Call<Resultado> division(int n1, int n2){
        return servicio.division(n1,n2);
    }
}
