package com.bitcode.recyclerview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductView extends LinearLayout {

    private Product product;

    private ImageView imgProduct;
    private TextView txtProductTitle, txtProductPrice, txtProductId;


    public ProductView(Context context) {
        super(context);

        View view = LayoutInflater.from(context).inflate(R.layout.product_view, this);
        //this.addView(view);

        imgProduct = view.findViewById(R.id.imgProduct);
        txtProductTitle = view.findViewById(R.id.txtProductTitle);
        txtProductPrice = view.findViewById(R.id.txtProductPrice);
        txtProductId = view.findViewById(R.id.txtProductId);

        /*imgProduct = new ImageView(context);
        imgProduct.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
        this.addView(imgProduct);

        txtProductTitle = new TextView(context);
        txtProductTitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.addView(txtProductTitle);

        txtProductPrice = new TextView(context);
        txtProductPrice.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.addView(txtProductPrice);*/

    }

    public void setProduct(Product product) {
        this.product = product;

        imgProduct.setImageResource(product.getImageId());
        txtProductTitle.setText(product.getTitle());
        txtProductPrice.setText("Rs. " + product.getPrice());
        txtProductId.setText("" + product.getId());
    }
}
