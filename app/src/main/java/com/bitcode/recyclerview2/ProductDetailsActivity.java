package com.bitcode.recyclerview2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    private TextView txtProductTitle, txtProductPrice;
    private ImageView imgProduct;

    private int id, price, imageId;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_view);

        initViews();
        extractInput();
    }

    private void extractInput() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        title = intent.getStringExtra("title");
        price = intent.getIntExtra("price", 0);
        imageId = intent.getIntExtra("image_id", R.mipmap.ic_launcher);

        imgProduct.setImageResource(imageId);
        txtProductTitle.setText(title);
        txtProductPrice.setText("Rs. " + price);
    }

    private void initViews() {
        txtProductTitle = findViewById(R.id.txtProductTitle);
        txtProductPrice = findViewById(R.id.txtProductPrice);
        imgProduct = findViewById(R.id.imgProduct);
    }
}
