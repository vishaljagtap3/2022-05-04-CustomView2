package com.bitcode.recyclerview2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgProduct;
        public TextView txtProductTitle, txtProductPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);

            imgProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Product product = products.get(getAdapterPosition());
                    Toast.makeText(v.getContext(), "Image Clicked: " + product.getTitle() , Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                    /*intent.putExtra("id", product.getId());
                    intent.putExtra("title", product.getTitle());
                    intent.putExtra("image_id", product.getImageId());
                    intent.putExtra("price", product.getPrice());*/
                    intent.putExtra("product", product);

                    v.getContext().startActivity(intent);
                }
            });

            txtProductTitle.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Product product = products.get(getAdapterPosition());
                    Toast.makeText(v.getContext(), "Title Clicked: " + product.getTitle() , Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                    intent.putExtra("product", product);

                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_view, null);

        //Not Useful
        /*view.findViewById(R.id.imgProduct).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Image Clicked", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        view.findViewById(R.id.txtProductTitle).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Title Clicked", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        view.findViewById(R.id.txtProductPrice).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Price Clicked", Toast.LENGTH_SHORT).show();
                    }
                }
        );*/

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);

        holder.imgProduct.setImageResource(product.getImageId());
        holder.txtProductTitle.setText(product.getTitle());
        holder.txtProductPrice.setText("Rs. " + product.getPrice() );

        /*holder.imgProduct.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Image: " + product.getTitle(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        holder.txtProductTitle.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Title: " + product.getTitle(), Toast.LENGTH_LONG).show();
                    }
                }
        );*/
    }
}
