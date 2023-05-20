package com.vhbeltramini.dronezeta.service.dto;


import com.vhbeltramini.dronezeta.model.ProductStorage;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ProductDTO {

    private String name;

    private Double price;

    private List<ProductStorageDTO> productStorages;

    private String photoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ProductStorageDTO> getProductStorages() {
        return productStorages;
    }

    public void setProductStorages(List<ProductStorageDTO> productStorages) {
        this.productStorages = productStorages;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
