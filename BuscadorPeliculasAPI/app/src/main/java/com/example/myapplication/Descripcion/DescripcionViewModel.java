package com.example.myapplication.Descripcion;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.api.PeliculasModel;
import com.example.myapplication.datos.Descripcion;

public class DescripcionViewModel extends AndroidViewModel {

    private PeliculasModel peliculasModel;

    private LiveData<Descripcion> descripcionLiveData;

    public DescripcionViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        peliculasModel = PeliculasModel.getInstance();
        descripcionLiveData = peliculasModel.getDescripcionMutableLiveData();
    }

    public void mostrarComentarios(int id){
        peliculasModel.mostrarDescripcion(id);
    }

    public LiveData<Descripcion> getDescripcionLiveData(){return descripcionLiveData;}

}
