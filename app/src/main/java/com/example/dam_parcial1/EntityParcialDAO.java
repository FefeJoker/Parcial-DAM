package com.example.dam_parcial1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface EntityParcialDAO {
    @Insert
    void insertEntityParcial(EntityParcial ep);

    @Query("SELECT * FROM EntityParcial")
    EntityParcial[] getAllEntityParcial();
}
