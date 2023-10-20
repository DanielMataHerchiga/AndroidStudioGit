package com.example.myapplication.api;

import com.example.myapplication.datos.Descripcion;
import com.example.myapplication.datos.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BusquedaPeliculas {

    @GET("pmdm/api/peliculas")
    Call<List<Peliculas>> mostrarTodo();

    @GET("pmdm/api/peliculas/{id}")
    Call<Descripcion> mostrarDescripcion(@Path("id") int id);
}
