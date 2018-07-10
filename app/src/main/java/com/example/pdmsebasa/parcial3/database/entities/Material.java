package com.example.pdmsebasa.parcial3.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "material")
/**
 * Entidad de Materiales
 * esta entidad contiene la informacion de los materiales
 */
public class Material {
    @PrimaryKey
    @NonNull
    private String id;
    private String name;
    private int stock;
    private float costo;

    /**
     * Constructor de Material
     *
     * @param id    id del material
     * @param name  nombre del material
     * @param stock cantidad de stock del material
     * @param costo costo del material
     */
    public Material(String id, String name, int stock, float costo) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.costo = costo;
    }

    /**
     * Obtiene id del objeto
     */
    public String getId() {
        return id;
    }

    /**
     * Setea id del objeto
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtener el stock del producto
     */
    public int getStock() {
        return stock;
    }

    /**
     * Setea la cantidad de stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Obtener el costo del material
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Setea la costo del material
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * Setea la nombre del material
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el nombre del material
     */
    public void setName(String name) {
        this.name = name;
    }
}
