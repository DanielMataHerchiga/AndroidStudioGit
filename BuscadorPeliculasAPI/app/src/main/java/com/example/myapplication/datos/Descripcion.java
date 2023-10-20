package com.example.myapplication.datos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Descripcion {

        @SerializedName("url")
        @Expose
        private String url;

        @SerializedName("nombre")
        @Expose
        private String nombre;

        @SerializedName("descripcion")
        @Expose
        private String descripcion;

        @SerializedName("estrellas")
        @Expose
        private int estrellas;


        @SerializedName("actores")
        @Expose
        private List<Actores> actores;

        public String getUrl() {
            return url;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getEstrellas() {
            return estrellas;
        }

        public List<Actores> getActores() {
                return actores;
        }
}
