package com.example.pdmsebasa.parcial3.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "producto")
public class Producto {
    @PrimaryKey
    private String id;
    private int id_lista_materiales;
    private float costo;
    private float price;
    private int stock;
    private int sold;
    private String category;

    public Producto(String id, int id_lista_materiales, float costo, float price, int stock, int sold, String category) {
        this.id = id;
        this.id_lista_materiales = id_lista_materiales;
        this.price = price;
        this.stock = stock;
        this.costo = costo;
        this.sold = sold;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_lista_materiales() {
        return id_lista_materiales;
    }

    public void setId_lista_materiales(int id_lista_materiales) {
        this.id_lista_materiales = id_lista_materiales;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
