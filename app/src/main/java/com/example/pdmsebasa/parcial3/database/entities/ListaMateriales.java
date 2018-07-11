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
    private String id_producto;
    /**
     * Id de material
     */
    private String id_material;
    /**
     * Cantidad del material
     */
    private int cantidad;

    /**
     * Constructor del Lista de materiales
     * @param id_producto id del producto
     * @param id_material id del material
     * @param cantidad    cantidad del material a registrar
     */
    public ListaMateriales(String id_producto, String id_material, int cantidad) {
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
    public String getId_producto() {
        return id_producto;
    }

    /**
     * Setea id del producto
     * @param id_producto
     */
    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Obtiene id del material
     */
    public String getId_material() {
        return id_material;
    }

    /**
     * Setea id del material
     * @param id_material
     */
    public void setId_material(String id_material) {
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
