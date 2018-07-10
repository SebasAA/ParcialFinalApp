package com.example.pdmsebasa.parcial3.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductoModel {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("product_materials")
    @Expose
    private List<MaterialModel> productMaterials = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cost")
    @Expose
    private Float cost;
    @SerializedName("price")
    @Expose
    private Float price;
    @SerializedName("stock")
    @Expose
    private Integer stock;
    @SerializedName("sold")
    @Expose
    private Integer sold;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("productImage")
    @Expose
    private String productImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MaterialModel> getProductMaterials() {
        return productMaterials;
    }

    public void setProductMaterials(List<MaterialModel> productMaterials) {
        this.productMaterials = productMaterials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

}
