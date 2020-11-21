package com.example.dam_parcial1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = EntityParcial.class, version = 3)
public abstract class EntityParcialDatabase extends RoomDatabase {
    private static final String NOMBRE_DB = "db";
    private static EntityParcialDatabase instancia;

    public abstract EntityParcialDAO entityDao();

    public static synchronized EntityParcialDatabase getInstance(Context context) {
        if (instancia == null) {
            instancia = Room
                    .databaseBuilder(context.getApplicationContext(), EntityParcialDatabase.class, NOMBRE_DB)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instancia;

    }


}
