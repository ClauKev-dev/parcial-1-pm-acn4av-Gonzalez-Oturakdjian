package com.example.parcial_1_am_acn4av_gonzales_oturakdjian;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        container = findViewById(R.id.container);
    }

    protected void setContent(@LayoutRes int layoutResId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(layoutResId, container, false);
        container.removeAllViews();
        container.addView(view);
    }
}

