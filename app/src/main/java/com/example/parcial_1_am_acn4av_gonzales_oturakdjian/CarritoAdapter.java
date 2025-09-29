package com.example.parcial_1_am_acn4av_gonzales_oturakdjian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder> {

    private List<Product> carrito;

    public CarritoAdapter(List<Product> carrito) {
        this.carrito = carrito;
    }

    @Override
    public CarritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrito, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarritoViewHolder holder, int position) {
        Product producto = carrito.get(position);
        holder.ivProduct.setImageResource(producto.getImageResId());
        holder.tvName.setText(producto.getName());
        holder.tvPrice.setText(producto.getPriceFormatted());
    }

    @Override
    public int getItemCount() {
        return carrito.size();
    }

    static class CarritoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        TextView tvName, tvPrice;

        public CarritoViewHolder(View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
