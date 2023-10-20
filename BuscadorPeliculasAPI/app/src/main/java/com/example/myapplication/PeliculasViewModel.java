package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.api.PeliculasModel;
import com.example.myapplication.datos.Peliculas;

import java.util.List;

public class PeliculasViewModel extends AndroidViewModel {

    private PeliculasModel peliculasModel;

    private LiveData<List<Peliculas>> peliculasLiveData;

    public PeliculasViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        peliculasModel = PeliculasModel.getInstance();
        peliculasLiveData = peliculasModel.getPeliculasMutableLiveData();
    }

    public void mostrarTodo(){
        peliculasModel.mostrarTodo();
    }

    public LiveData<List<Peliculas>> getPeliculasLiveData(){return peliculasLiveData;}
}
