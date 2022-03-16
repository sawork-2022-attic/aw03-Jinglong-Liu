package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    @Override
    public String toString(){
        return product.toString() +"\t" + quantity;
    }
    public int increase(int amount){
        quantity += amount;
        return quantity;
    }
    public int decrease(int amount){
        quantity -= amount;
        return quantity;
    }
}
