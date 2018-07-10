package com.example.pdmsebasa.parcial3.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pdmsebasa.parcial3.database.entities.Material;

import java.util.List;

@Dao
/**
 * Interface para el DAO de Material
 */
public interface MaterialDAO {
    /**
     * Inserta un material en la base de datos
     *
     * @param material Objeto material a insertar
     */
    @Insert
    void insert(Material material);

    /**
     * Actualiza la informacion de un material en la base de datos
     * @param material Objeto material a actualizar
     */
    @Update
    void update(Material material);

    /**
     * Elimina todos los materiales de la base de datos
     */
    @Query("DELETE FROM material")
    void deleteAll();

    /**
     * Elimina un material de la base de datos
     * @param id id del material a eliminar
     */
    @Query("DELETE FROM material WHERE id=:id")
    void deleteById(int id);

    /**
     * Obtiene la lista de todos los materiales ordenado por nombre en orden ascendente
     * @return Live data de materiales
     */
    @Query("SELECT * FROM material ORDER BY name ASC")
    LiveData<List<Material>> getAllDose();


}
