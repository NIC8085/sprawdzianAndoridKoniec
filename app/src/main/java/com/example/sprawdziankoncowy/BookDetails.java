package com.example.sprawdziankoncowy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class BookDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.a);
        imageList.add(R.drawable.b);
        imageList.add(R.drawable.c);
        imageList.add(R.drawable.d);
        imageList.add(R.drawable.e);
        imageList.add(R.drawable.f);
        imageList.add(R.drawable.g);

        Bundle bundle = getIntent().getExtras();
        String title = String.valueOf(bundle.get("title"));
        String author = String.valueOf(bundle.get("author"));
        ImageView image = findViewById(R.id.bookImage);

        Random rand = new Random();
        int random = rand.nextInt(7);
        Integer i = imageList.get(random);
        image.setImageResource(i);


        TextView titleView = findViewById(R.id.titleDetails);
        TextView authorView = findViewById(R.id.authorDetails);

        titleView.setText(title);
        authorView.setText(author);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}