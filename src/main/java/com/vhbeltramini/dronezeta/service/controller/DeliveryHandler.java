package com.vhbeltramini.dronezeta.service.controller;

import com.vhbeltramini.dronezeta.model.Delivery;
import com.vhbeltramini.dronezeta.model.Product;
import com.vhbeltramini.dronezeta.model.Travel;

import java.util.ArrayList;
import java.util.List;

public class DeliveryHandler {

    private Delivery delivery;

    public DeliveryHandler(Delivery delivery) {
        this.delivery = delivery;
    }

    public Delivery process() {
        List<Product> productList = this.delivery.getOrder().getProducts();

        if (productList.size() <= 10) {
            return processDeliveryOneTravel();
        }

        return processMultiDeliveryTravels();


    }

    private Delivery processMultiDeliveryTravels() {
        List<Product> productList = this.delivery.getOrder().getProducts();

        List<Product> tempProdList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            tempProdList.add(productList.get(i));
            if (tempProdList.size() == 9) {
                this.delivery.addTravel(new Travel(tempProdList, Travel.TravelStatus.SENT));
                tempProdList = new ArrayList<>();
            }
        }

        return this.delivery;
    }

    private Delivery processDeliveryOneTravel() {
        this.delivery.addTravel(new Travel(this.delivery.getOrder().getProducts(), Travel.TravelStatus.SENT));
        return this.delivery;
    }

}
