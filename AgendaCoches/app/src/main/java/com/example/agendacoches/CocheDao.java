package com.example.agendacoches;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CocheDao {

    @Query("SELECT * FROM coches")
    List<Coche> getAll();

    /*@Query("UPDATE coches set marca :=marca, modelo :=modelo, descrip :=descrip WHERE ")
    void update(String marca, String modelo, String descrip)*/

    @Insert
    void insertAll(Coche... datos);

    @Delete
    void delete(Coche coches);
}

