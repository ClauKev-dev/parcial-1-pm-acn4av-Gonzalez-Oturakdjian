package com.example.parcial_1_am_acn4av_gonzales_oturakdjian;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import java.util.Timer;
import java.util.TimerTask;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseActivity {

    private LinearLayout tabHome, tabDescuentos, tabTienda, tabCuadrado, tabMenu;

    // Variables para el carrusel
    private ViewPager viewPager;
    private LinearLayout layoutDots;
    private CarouselAdapter carouselAdapter;
    private TextView tvCartCount;
    private int cartCount = 0;

    // ARRAY ACTUALIZADO con las imágenes que creaste
    private int[] images = {
            R.drawable.image1,    // Tu primera imagen creada
            R.drawable.image2     // Tu cuarta imagen creada
    };

    private int currentPage = 0;
    private Timer timer;
    private final long DELAY_MS = 500;
    private final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation();
        tvCartCount = findViewById(R.id.tv_cart_count);
        setupCarousel();

        RecyclerView recyclerProducts = findViewById(R.id.recyclerProducts);

// 2 columnas en el grid
        recyclerProducts.setLayoutManager(new GridLayoutManager(this, 2));

// Lista de productos
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(R.drawable.image3, "Curitas", 3500.0));
        productList.add(new Product(R.drawable.image4, "Jarabe para la tos", 4200.0));
        productList.add(new Product(R.drawable.image5, "Tafirol para espasmos", 8000.0));
        productList.add(new Product(R.drawable.image6, "Ibuprofeno 400", 6000.0));

        ProductAdapter adapter = new ProductAdapter(this, productList, product -> {
            // Agregar producto al carrito
            CarritoManager.agregarProducto(product);

            // Actualizar contador de carrito en pantalla
            actualizarCartCount();
        });
        recyclerProducts.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarCartCount();
    }

    private void setupCarousel() {
        // Inicializar ViewPager y dots
        viewPager = findViewById(R.id.viewPager);
        layoutDots = findViewById(R.id.layoutDots);

        // Crear y configurar el adaptador CON LAS NUEVAS IMÁGENES
        carouselAdapter = new CarouselAdapter(this, images);
        viewPager.setAdapter(carouselAdapter);

        // Crear los dots indicadores
        createDots();

        // Configurar el cambio automático de slides
        setupAutoSlide();

        // Listener para cambiar los dots cuando se desliza manualmente
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                updateDots();
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }



    private void createDots() {
        // Limpiar dots existentes
        layoutDots.removeAllViews();

        ImageView[] dots = new ImageView[images.length];

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);

            // Configurar el tamaño y margen de los dots
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    20,  // Ancho en pixels
                    20   // Alto en pixels
            );
            params.setMargins(8, 0, 8, 0);
            dots[i].setLayoutParams(params);

            layoutDots.addView(dots[i]);
        }

        updateDots();
    }

    private void updateDots() {
        for (int i = 0; i < layoutDots.getChildCount(); i++) {
            ImageView dot = (ImageView) layoutDots.getChildAt(i);

            // Cambiar color según si está activo o no
            if (i == currentPage) {
                dot.setBackgroundResource(R.drawable.dot_active);
            } else {
                dot.setBackgroundResource(R.drawable.dot_inactive);
            }
        }
    }

    private void setupAutoSlide() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == images.length - 1) {
                    currentPage = 0;
                } else {
                    currentPage++;
                }
                viewPager.setCurrentItem(currentPage, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    private void actualizarCartCount() {
        int total = 0;
        for (Product p : CarritoManager.getCarrito()) {
            total += p.getQuantity(); // suma todas las unidades
        }

        if (total > 0) {
            tvCartCount.setText(String.valueOf(total));
            tvCartCount.setVisibility(View.VISIBLE);
        } else {
            tvCartCount.setVisibility(View.GONE);
        }
    }

}