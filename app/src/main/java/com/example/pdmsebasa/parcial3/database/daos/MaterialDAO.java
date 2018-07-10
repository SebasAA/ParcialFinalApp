package com.example.pdmsebasa.parcial3.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pdmsebasa.parcial3.database.entities.Material;

import java.util.List;

@Dao
public interface MaterialDAO {

    @Insert
    void insert(Material material);

    @Update
    void update(Material material);

    @Query("DELETE FROM material")
    void deleteAll();

    @Query("DELETE FROM material WHERE id=:id")
    void deleteById(int id);

    @Query("SELECT * FROM material ORDER BY name ASC")
    LiveData<List<Material>> getAllDose();


}
