package com.example.parcial_1_am_acn4av_gonzales_oturakdjian;

import java.util.Locale;

public class Product {
    private int imageResId;
    private String name;
    private double price;

    public Product(int imageResId, String name, double price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    public int getImageResId() { return imageResId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Método útil para mostrar el precio en la UI
    public String getPriceFormatted() {
        return String.format(Locale.getDefault(), "$%.2f", price);
    }
}
