package com.example.pdmsebasa.parcial3.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "producto")
/**
 * Entidad de Producto
 * esta entidad contiene la informacion de un producto
 */
public class Producto {
    @PrimaryKey
    @NonNull
    private String id;
    private String name;
    private int id_lista_materiales;
    private float costo;
    private float price;
    private int stock;
    private int sold;
    private String category;

    /**
     * Constructor de Producto
     *
     * @param id                  id del producto
     * @param name                nombre del producto
     * @param id_lista_materiales id de la lista de materiales que corresponden a el producto
     * @param stock               cantidad de stock del producto
     * @param costo               costo del producto
     * @param price               precio de venta del producto
     * @param sold                cantidad de productos vendidos
     * @param category            categoria a la que pertenece el producto
     */
    public Producto(String id, String name, int id_lista_materiales, float costo, float price, int stock, int sold, String category) {
        this.id = id;
        this.name = name;
        this.id_lista_materiales = id_lista_materiales;
        this.price = price;
        this.stock = stock;
        this.costo = costo;
        this.sold = sold;
        this.category = category;
    }

    /**
     * Obtener el id del producto
 */
    public String getId() {
        return id;
    }
    /**
     * Setear el id del producto
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtener el id del la lista de materiales
     */
    public int getId_lista_materiales() {
        return id_lista_materiales;
    }
    /**
     * Setear el id del la lista de materiales
     */
    public void setId_lista_materiales(int id_lista_materiales) {
        this.id_lista_materiales = id_lista_materiales;
    }
    /**
     * Obtener el costo de produccion del producto
     */
    public float getCosto() {
        return costo;
    }
    /**
     * Setear el costo de produccion del producto
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }
    /**
     * Obtener el precio de venta del producto
     */
    public float getPrice() {
        return price;
    }
    /**
     * Setear el costo de venta del producto
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Obtener el stock del producto
     */
    public int getStock() {
        return stock;
    }
    /**
     * Setear el stock del producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * Obtener el la cantidad de productos vendidos
     */
    public int getSold() {
        return sold;
    }
    /**
     * Setear el la cantidad de productos vendidos
     */
    public void setSold(int sold) {
        this.sold = sold;
    }
    /**
     * Obtener la categoria a la que pertenece el producto
     */
    public String getCategory() {
        return category;
    }
    /**
     * Setear la categoria a la que pertenece el producto
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Obtener el nombre del producto
     */
    public String getName() {
        return name;
    }
    /**
     *Setear el nombre del producto
     */
    public void setName(String name) {
        this.name = name;
    }
}
