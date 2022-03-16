package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        for(Item it:items){
            if(item.getProduct().getId().equals(it.getProduct().getId())){
                it.increase(item.getQuantity());
                return true;
            }
        }
        return items.add(item);
    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
    public void removeItemByProductId(String id){
        this.items.removeIf(item->item.getProduct().getId().equals(id));
    }

    public void decreaseItem(Item item) {
        String pid = item.getProduct().getId();
        Iterator<Item> iterator = items.iterator();
        for(;iterator.hasNext();){
            Item next = iterator.next();
            if(pid.equals(next.getProduct().getId())){
                next.decrease(item.getQuantity());
                if(next.getQuantity() == 0){
                    iterator.remove();
                }
            }
        }
    }
}
