package com.example.pdmsebasa.parcial3.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "listamateriales")

/**
 * Entidad de Lista de Materiales
 * esta entidad relaciona la tabla de materiales
 * y el producto que utiliza ese material.
 */
public class ListaMateriales {
    @PrimaryKey(autoGenerate = true)
    /**
     * Id de lista de materiales
     */
    private int id;
    /**
     * Id del producto
     */
    private int id_producto;
    /**
     * Id de material
     */
    private int id_material;
    /**
     * Cantidad del material
     */
    private int cantidad;

    /**
     * Constructor del Lista de materiales
     *
     * @param id_producto id del producto
     * @param id_material id del material
     * @param cantidad    cantidad del material a registrar
     */
    public ListaMateriales(int id_producto, int id_material, int cantidad) {
        this.id_producto = id_producto;
        this.id_material = id_material;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene id del objeto
     */
    public int getId() {
        return id;
    }

    /**
     * Setea id del objeto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene id del producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * Setea id del producto
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Obtiene id del material
     */
    public int getId_material() {
        return id_material;
    }

    /**
     * Setea id del material
     */
    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    /**
     * Obtiene la cantidad del material registrado
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Setea la cantidad del material registrar
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
