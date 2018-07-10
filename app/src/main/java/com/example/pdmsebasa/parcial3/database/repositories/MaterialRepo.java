package com.example.pdmsebasa.parcial3.database.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.pdmsebasa.parcial3.database.Database;
import com.example.pdmsebasa.parcial3.database.daos.MaterialDAO;
import com.example.pdmsebasa.parcial3.database.entities.Material;

import java.util.List;

/**
 * Repositiorio de manejo de la base de datos para materiales
 */
public class MaterialRepo {
    private MaterialDAO mMaterialDao;

    /**
     * Constructor del objeto
     *
     * @param application Referencia a la aplicacion que se esta corriendo
     */
    public MaterialRepo(Application application) {
        Database db = Database.getDatabase(application);
        mMaterialDao = db.materialDAO();
    }

    /**
     * Inserta un material en la bd
     */
    public void insert(Material m) {
        mMaterialDao.insert(m);
    }

    /**
     * Actualiza un material en la bd
     */
    public void update(Material m) {
        mMaterialDao.update(m);
    }

    /**
     * Elimina un material en la bd
     */
    public void delete(Material m) {
        mMaterialDao.deleteById(m.getId());
    }

    /**
     * Elimina todos los materiales de la db
     */
    public void deleteAll() {
        mMaterialDao.deleteAll();
    }

    /**
     * Obtiene la lista de todos los materiales
     */
    public LiveData<List<Material>> getAll() {
        return mMaterialDao.getAll();
    }
}
