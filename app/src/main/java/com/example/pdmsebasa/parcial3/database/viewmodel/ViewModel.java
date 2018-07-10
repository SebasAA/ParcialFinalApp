package com.example.pdmsebasa.parcial3.database.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.pdmsebasa.parcial3.database.daos.ProductoDAO;
import com.example.pdmsebasa.parcial3.database.entities.ListaMateriales;
import com.example.pdmsebasa.parcial3.database.entities.Material;
import com.example.pdmsebasa.parcial3.database.entities.Producto;
import com.example.pdmsebasa.parcial3.database.repositories.ListaMaterialesRepo;
import com.example.pdmsebasa.parcial3.database.repositories.MaterialRepo;
import com.example.pdmsebasa.parcial3.database.repositories.ProductoRepo;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private MaterialRepo materialRepo;
    private ProductoRepo productoRepo;
    private ListaMaterialesRepo listaMaterialesRepo;

    public ViewModel(Application application) {
        super(application);
        materialRepo = new MaterialRepo(application);
        productoRepo = new ProductoRepo(application);
        listaMaterialesRepo = new ListaMaterialesRepo(application);
    }

    /**
     * Inserta un ListaMateriales en la bd
     */
    public void insert(ListaMateriales m) {
        listaMaterialesRepo.insert(m);
    }

    /**
     * Actualiza un ListaMateriales en la bd
     */
    public void update(ListaMateriales m) {
        listaMaterialesRepo.update(m);
    }

    /**
     * Elimina un ListaMateriales en la bd
     */
    public void delete(ListaMateriales m) {
        listaMaterialesRepo.deleteById(m);
    }

    /**
     * Elimina todas las Lista de Materiales de la db
     */
    public void deleteAll() {
        listaMaterialesRepo.deleteAll();
    }


    /**
     * Obtiene la lista de todos los ide de materiales que pertenecen a un producto
     *
     * @param id id del producto
     */
    public LiveData<List<ListaMateriales>> getAllByProducto(int id) {
        return listaMaterialesRepo.getAllByProducto(id);
    }

    /**
     * Inserta un material en la bd
     */
    public void insert(Material m) {
        materialRepo.insert(m);
    }

    /**
     * Actualiza un material en la bd
     */
    public void update(Material m) {
        materialRepo.update(m);
    }

    /**
     * Elimina un material en la bd
     */
    public void delete(Material m) {
        materialRepo.delete(m);
    }

    /**
     * Elimina todos los materiales de la db
     */
    public void deleteAllMaterials() {
        materialRepo.deleteAll();
    }

    /**
     * Obtiene la lista de todos los materiales
     */
    public LiveData<List<Material>> getAll() {
        return materialRepo.getAll();
    }

    /**
     * Inserta un Producto en la bd
     */
    public void insert(Producto m) {
        new InsertProductAsyncTask(productoRepo).execute(m);
    }

    /**
     * Actualiza un Producto en la bd
     */
    public void update(Producto m) {
        productoRepo.update(m);
    }

    /**
     * Elimina un Producto en la bd
     */
    public void delete(Producto m) {
        productoRepo.delete(m);
    }

    /**
     * Elimina todos los Productos de la db
     */
    public void deleteAllProducto() {
        productoRepo.deleteAll();
    }

    /**
     * Obtiene la lista de todos los productos
     */
    public LiveData<List<Producto>> getAllProducto() {
        return productoRepo.getAll();
    }


    public static class InsertProductAsyncTask extends AsyncTask<Producto, Void, Void>{

        private ProductoRepo productoDAO;

        public InsertProductAsyncTask(ProductoRepo productoDAO) {
            this.productoDAO = productoDAO;
        }

        @Override
        protected Void doInBackground(Producto... productos) {
            productoDAO.insert(productos[0]);
            return null;
        }
    }
}
