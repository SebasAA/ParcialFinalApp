package com.example.pdmsebasa.parcial3.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "listamateriales")
public class ListaMateriales {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int id_producto;
    private int id_material;
    private int cantidad;


    public ListaMateriales(int id, int id_producto, int id_material, int cantidad) {
        this.id = id;
        this.id_producto = id_producto;
        this.id_material = id_material;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}