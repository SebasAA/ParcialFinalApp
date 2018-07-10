package com.example.pdmsebasa.parcial3.database.repositories;

import android.app.Application;

import com.example.pdmsebasa.parcial3.database.Database;
import com.example.pdmsebasa.parcial3.database.daos.ProductoDAO;
import com.example.pdmsebasa.parcial3.database.entities.Producto;

/**
 * Repositiorio de manejo de la base de datos para Productos
 */
public class ProductoRepo {
    private ProductoDAO mProductoDao;

    /**
     * Constructor del objeto
     *
     * @param application Referencia a la aplicacion que se esta corriendo
     */
    public ProductoRepo(Application application) {
        Database db = Database.getDatabase(application);
        mProductoDao = db.productoDAO();
    }

    /**
     * Inserta un Producto en la bd
     */
    public void insert(Producto m) {
        mProductoDao.insert(m);
    }

    /**
     * Actualiza un Producto en la bd
     */
    public void update(Producto m) {
        mProductoDao.update(m);
    }

    /**
     * Elimina un Producto en la bd
     */
    public void delete(Producto m) {
        mProductoDao.deleteById(m.getId());
    }

    /**
     * Elimina todos los Productos de la db
     */
    public void deleteAll() {
        mProductoDao.deleteAll();
    }
}
