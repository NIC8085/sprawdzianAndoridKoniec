package com.example.sprawdziankoncowy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<String> booksTitle = new ArrayList<>();
        ArrayList<String> booksAuthor = new ArrayList<>();

        Button add = findViewById(R.id.add);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, booksTitle);
        ListView booksList = findViewById(R.id.booksList);
        booksList.setAdapter(adapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEdit = findViewById(R.id.titleEdit);
                EditText authorEdit = findViewById(R.id.authorEdit);

                String title = titleEdit.getText().toString();
                String author = authorEdit.getText().toString();


                booksTitle.add(title);
                booksAuthor.add(author);
                booksList.setAdapter(adapter);


            }
        });
        booksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),BookDetails.class);
                intent.putExtra("title",booksTitle.get(position));
                intent.putExtra("author",booksAuthor.get(position));
                startActivity(intent);

            }
        });

    }
}