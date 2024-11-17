package com.example.tarea_recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // configurar el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_contactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ViewCompat.setOnApplyWindowInsetsListener(recyclerView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // datos de la lista de contactos
        List<BaseContacto> contactos = new ArrayList<>();
        contactos.add(new BaseContacto("Miguel", "Perez", "miguel@gmail.com", "111-111-111", R.drawable.contacto1));
        contactos.add(new BaseContacto("Fabrizio", "Aviles", "fabrizio@gmail.com", "222-222-222", R.drawable.contacto2));
        contactos.add(new BaseContacto("David", "Carbajal", "david@gmail.com", "333-333-333", R.drawable.contacto3));
        contactos.add(new BaseContacto("Daniel", "Castilla", "daniel@gmail.com", "444-444-444", R.drawable.contacto4));

        // configurar el adaptador al recyclerView
        AdaptadorDelContacto adapter = new AdaptadorDelContacto(this, contactos);
        recyclerView.setAdapter(adapter);
    }
}
