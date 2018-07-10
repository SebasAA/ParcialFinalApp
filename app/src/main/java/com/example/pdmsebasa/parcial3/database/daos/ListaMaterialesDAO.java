package com.example.pdmsebasa.parcial3.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pdmsebasa.parcial3.database.entities.ListaMateriales;

import java.util.List;

@Dao
/**
 * Interface para el DAO de Lista de Materiales
 */
public interface ListaMaterialesDAO {
    /**
     * Inserta una entrada de listadematerial  en la base de datos
     *
     * @param listaMateriales Objeto ListaMateriales a insertar
     */
    @Insert
    void insert(ListaMateriales listaMateriales);

    /**
     * Actualiza la informacion de entrada de listadematerial en la base de datos
     * @param listaMateriales Objeto ListaMateriales a actualizar
     */
    @Update
    void update(ListaMateriales listaMateriales);

    /**
     * Elimina todos los elementos de la base de datos
     */
    @Query("DELETE FROM listaMateriales")
    void deleteAll();

    /**
     * Elimina un elemento de la base de datos
     * @param id id del elemento a eliminar
     */
    @Query("DELETE FROM ListaMateriales WHERE id=:id")
    void deleteById(int id);

    /**
     * Obtiene la lista de todos los listamateriales ordenado por id
     * @return Live data de listademateriales
     */
    @Query("SELECT * FROM ListaMateriales ORDER BY id")
    LiveData<List<ListaMateriales>> getAllDose();

    /**
     * Obtiene la lista de todos los materiales que usa un producto
     * @param id id el producto
     * @return Live data de listademateriales
     */
    @Query("SELECT * FROM ListaMateriales where id_producto=:id")
    LiveData<List<ListaMateriales>> getByIdProducto(int id);
}
