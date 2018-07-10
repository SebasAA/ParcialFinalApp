package com.example.pdmsebasa.parcial3.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "materiales")
public class Material {
    @PrimaryKey
    private String id;
    private int stock;
    private float costo;

    public Material(String id, int stock, float costo) {
        this.id = id;
        this.stock = stock;
        this.costo = costo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
