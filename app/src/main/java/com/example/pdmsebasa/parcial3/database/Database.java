package com.example.pdmsebasa.parcial3.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pdmsebasa.parcial3.database.daos.ListaMaterialesDAO;
import com.example.pdmsebasa.parcial3.database.daos.MaterialDAO;
import com.example.pdmsebasa.parcial3.database.daos.ProductoDAO;
import com.example.pdmsebasa.parcial3.database.entities.ListaMateriales;
import com.example.pdmsebasa.parcial3.database.entities.Material;
import com.example.pdmsebasa.parcial3.database.entities.Producto;

@android.arch.persistence.room.Database(entities = {Producto.class, Material.class, ListaMateriales.class}, version = 1, exportSchema = false)
/**
 *Clase para la creacion de la base de datos
 */
public abstract class Database extends RoomDatabase {

    private static Database INSTANCE;

    /**
     * Obtiene una instancia de la base de datos
     *
     * @param context Contexto
     */
    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "parcial_final_database")
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     *Referencia al dao de materiales
     */
    public abstract MaterialDAO materialDAO();

    /**
     *Referencia al dao de productos
     */
    public abstract ProductoDAO productoDAO();

    /**
     *Referencia al dao de listamateriales
     */
    public abstract ListaMaterialesDAO listaMaterialesDAO();
}