package com.example.agendacoches;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName = "coches")
public class Coche implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "marca")
    public String marca;

    @ColumnInfo(name = "modelo")
    public String modelo;

    @ColumnInfo(name = "descrip")
    public String descrip;

    public Coche(String marca, String modelo, String descrip){
        this.marca = marca;
        this.modelo=modelo;
        this.descrip=descrip;
    }

    @NotNull
    public int getUid() {
        return uid;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescrip() {return descrip;}
}