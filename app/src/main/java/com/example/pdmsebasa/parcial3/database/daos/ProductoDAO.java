package com.example.pdmsebasa.parcial3.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pdmsebasa.parcial3.database.entities.Producto;

import java.util.List;

@Dao
public interface ProductoDAO {

    @Insert
    void insert(Producto producto);

    @Update
    void update(Producto producto);

    @Query("DELETE FROM producto")
    void deleteAll();

    @Query("DELETE FROM producto WHERE id=:id")
    void deleteById(int id);

    @Query("SELECT * FROM producto ORDER BY name ASC")
    LiveData<List<Producto>> getAllDose();

}
