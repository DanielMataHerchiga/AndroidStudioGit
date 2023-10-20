package com.example.agendacoches;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Coche.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract CocheDao cocheDao();
}
