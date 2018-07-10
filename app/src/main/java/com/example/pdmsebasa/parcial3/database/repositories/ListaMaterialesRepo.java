package com.example.pdmsebasa.parcial3.database.repositories;

import android.app.Application;

import com.example.pdmsebasa.parcial3.database.Database;
import com.example.pdmsebasa.parcial3.database.daos.ListaMaterialesDAO;
import com.example.pdmsebasa.parcial3.database.entities.ListaMateriales;

/**
 * Repositiorio de manejo de la base de datos para ListaMateriales
 */
public class ListaMaterialesRepo {
    private ListaMaterialesDAO mListaMaterialesDao;

    /**
     * Constructor del objeto
     *
     * @param application Referencia a la aplicacion que se esta corriendo
     */
    public ListaMaterialesRepo(Application application) {
        Database db = Database.getDatabase(application);
        mListaMaterialesDao = db.listaMaterialesDAO();
    }

    /**
     * Inserta un ListaMateriales en la bd
     */
    public void insert(ListaMateriales m) {
        mListaMaterialesDao.insert(m);
    }

    /**
     * Actualiza un ListaMateriales en la bd
     */
    public void update(ListaMateriales m) {
        mListaMaterialesDao.update(m);
    }

    /**
     * Elimina un ListaMateriales en la bd
     */
    public void delete(ListaMateriales m) {
        mListaMaterialesDao.deleteById(m.getId());
    }

    /**
     * Elimina todas las Lista de Materiales de la db
     */
    public void deleteAll() {
        mListaMaterialesDao.deleteAll();
    }
}
