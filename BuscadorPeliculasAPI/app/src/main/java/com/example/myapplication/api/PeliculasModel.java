package com.example.myapplication.api;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.datos.Descripcion;
import com.example.myapplication.datos.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculasModel {

    private static final String PELICULA_URL = "http://51.77.156.235:3322/";

    private BusquedaPeliculas busquedaPeliculas;

    private static  PeliculasModel instancia;

    private MutableLiveData<List<Peliculas>> peliculasMutableLiveData;

    private MutableLiveData<Descripcion> descripcionMutableLiveData;

    private PeliculasModel(){
        peliculasMutableLiveData = new MutableLiveData<>();
        descripcionMutableLiveData = new MutableLiveData<>();
        busquedaPeliculas = new Retrofit.Builder().
                baseUrl(PELICULA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BusquedaPeliculas.class);
    }

    public  static PeliculasModel getInstance(){
        if(instancia==null){
            instancia = new PeliculasModel();
        }
        return instancia;
    }

    public void mostrarTodo(){
        busquedaPeliculas.mostrarTodo()
                .enqueue(new Callback<List<Peliculas>>() {
                    @Override
                    public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
                        List<Peliculas> listadoPeliculas = response.body();
                        peliculasMutableLiveData.postValue(listadoPeliculas);
                    }

                    @Override
                    public void onFailure(Call<List<Peliculas>> call, Throwable t) {

                    }
                });
    }

    public void mostrarDescripcion(int id){
        busquedaPeliculas.mostrarDescripcion(id)
                .enqueue(new Callback<Descripcion>() {
                    @Override
                    public void onResponse(Call<Descripcion> call, Response<Descripcion> response) {
                        descripcionMutableLiveData.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Descripcion> call, Throwable t) {

                    }
                });
    }

    public LiveData<List<Peliculas>> getPeliculasMutableLiveData(){return peliculasMutableLiveData;}

    public LiveData<Descripcion> getDescripcionMutableLiveData(){return descripcionMutableLiveData;}
}
