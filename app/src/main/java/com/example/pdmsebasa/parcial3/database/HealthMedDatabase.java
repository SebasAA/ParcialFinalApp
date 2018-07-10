package com.example.pdmsebasa.parcial3.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pdmsebasa.parcial3.database.daos.ListaMaterialesDAO;
import com.example.pdmsebasa.parcial3.database.daos.MaterialDAO;
import com.example.pdmsebasa.parcial3.database.daos.ProductoDAO;
import com.example.pdmsebasa.parcial3.database.entities.ListaMateriales;
import com.example.pdmsebasa.parcial3.database.entities.Material;
import com.example.pdmsebasa.parcial3.database.entities.Producto;

@Database(entities = {Producto.class, Material.class, ListaMateriales.class}, version = 1)
public abstract class HealthMedDatabase extends RoomDatabase {

    private static HealthMedDatabase INSTANCE;

    public static HealthMedDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HealthMedDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HealthMedDatabase.class, "parcial_final_database")
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract MaterialDAO materialDAO();

    public abstract ProductoDAO productoDAO();

    public abstract ListaMaterialesDAO listaMaterialesDAO();
}