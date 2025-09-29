package com.example.parcial_1_am_acn4av_gonzales_oturakdjian;

import java.util.ArrayList;
import java.util.List;

public class CarritoManager {
    private static List<Product> carrito = new ArrayList<>();

    public static void agregarProducto(Product product) {
        carrito.add(product);
    }

    public static List<Product> getCarrito() {
        return carrito;
    }

    public static void limpiarCarrito() {
        carrito.clear();
    }
}
