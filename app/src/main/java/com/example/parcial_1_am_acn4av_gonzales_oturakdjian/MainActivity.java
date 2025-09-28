package com.example.parcial_1_am_acn4av_gonzales_oturakdjian;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout tabHome, tabDescuentos, tabTienda, tabCuadrado, tabMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation();
    }

    private void setupBottomNavigation() {

        tabHome = findViewById(R.id.tab_home);
        tabDescuentos = findViewById(R.id.tab_descuentos);
        tabTienda = findViewById(R.id.tab_tienda);
        tabCuadrado = findViewById(R.id.tab_cuadrado);
        tabMenu = findViewById(R.id.tab_menu);


        tabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToTab(0);
            }
        });

        tabDescuentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToTab(1);
            }
        });

        tabTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToTab(2);
            }
        });

        tabCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToTab(3);
            }
        });

        tabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToTab(4);
            }
        });
    }

    private void navigateToTab(int tabIndex) {
        resetTabs();

        switch (tabIndex) {
            case 0:
                tabHome.setAlpha(1f);

                break;
            case 1:
                tabDescuentos.setAlpha(1f);

                break;
            case 2:
                tabTienda.setAlpha(1f);

                break;
            case 3:
                tabCuadrado.setAlpha(1f);

                break;
            case 4:
                tabMenu.setAlpha(1f);

                break;
        }
    }

    private void resetTabs() {
        if (tabHome != null) tabHome.setAlpha(0.6f);
        if (tabDescuentos != null) tabDescuentos.setAlpha(0.6f);
        if (tabTienda != null) tabTienda.setAlpha(0.6f);
        if (tabCuadrado != null) tabCuadrado.setAlpha(0.6f);
        if (tabMenu != null) tabMenu.setAlpha(0.6f);
    }
}