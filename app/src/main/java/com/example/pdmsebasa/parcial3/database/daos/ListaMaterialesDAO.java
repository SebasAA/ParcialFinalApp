package com.example.pdmsebasa.parcial3.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pdmsebasa.parcial3.database.entities.ListaMateriales;

import java.util.List;

@Dao
public interface ListaMaterialesDAO {

    @Insert
    void insert(ListaMateriales listaMateriales);

    @Update
    void update(ListaMateriales listaMateriales);

    @Query("DELETE FROM listaMateriales")
    void deleteAll();

    @Query("DELETE FROM ListaMateriales WHERE id=:id")
    void deleteById(int id);

    @Query("SELECT * FROM ListaMateriales ORDER BY id")
    LiveData<List<ListaMateriales>> getAllDose();

    @Query("SELECT * FROM ListaMateriales where id_producto=:id")
    LiveData<List<ListaMateriales>> getByIdProducto(int id);


}
