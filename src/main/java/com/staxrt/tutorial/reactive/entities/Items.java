package com.staxrt.tutorial.reactive.entities;

/**
 * Created by ubuntu on 18/05/20.
 */
public class Items {
    private String id;
    private String name;
    private String quantity;

    public Items(String id, String name, String quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Items items = (Items) o;

        return id != null ? id.equals(items.id) : items.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
