package com.example.pdmsebasa.parcial3.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaterialModel {

    @SerializedName("id_material")
    @Expose
    private String idMaterial;

    @SerializedName("quantity")
    @Expose
    private int cantidad;

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
