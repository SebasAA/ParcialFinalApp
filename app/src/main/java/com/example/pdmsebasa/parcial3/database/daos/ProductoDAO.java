package com.example.pdmsebasa.parcial3.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pdmsebasa.parcial3.database.entities.Producto;

import java.util.List;

@Dao
/**
 * Interface para el DAO de Producto
 */
public interface ProductoDAO {
    /**
     * Inserta un producto en la base de datos
     *
     * @param producto Objeto producto a insertar
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Producto producto);

    /**
     * Actualiza la informacion de un producto en la base de datos
     * @param producto Objeto producto a actualizar
     */
    @Update
    void update(Producto producto);

    /**
     * Elimina todos los productos de la base de datos
     */
    @Query("DELETE FROM producto")
    void deleteAll();

    /**
     * Elimina un producto de la base de datos
     * @param id id del producto a eliminar
     */
    @Query("DELETE FROM producto WHERE id=:id")
    void deleteById(String id);

    /**
     * Obtiene la lista de todos los producots ordenado por nombre en orden ascendente
     * @return Live data de productos
     */
    @Query("SELECT * FROM producto ORDER BY name ASC")
    LiveData<List<Producto>> getAll();

}
