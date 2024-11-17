package com.example.tarea_recyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdaptadorDelContacto.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_contactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // lista de contactos con sus mensajes personalizados
        List<BaseContacto> contactos = new ArrayList<>();
        contactos.add(new BaseContacto("Miguel", "Perez", "miguel@gmail.com", "111-111-111", R.drawable.contacto1));
        contactos.add(new BaseContacto("Fabrizio", "Aviles", "fabrizio@gmail.com", "222-222-222", R.drawable.contacto2));
        contactos.add(new BaseContacto("David", "Carbajal", "david@gmail.com", "333-333-333", R.drawable.contacto3));
        contactos.add(new BaseContacto("Daniel", "Castilla", "daniel@gmail.com", "444-444-444", R.drawable.contacto4));

        // inicializa el adaptador con la lista de contactos y el listener de clics
        AdaptadorDelContacto adapter = new AdaptadorDelContacto(this, contactos, this);
        recyclerView.setAdapter(adapter);
    }

    // implementacion del metodo onItemClick para manejar el evento de clic
    @Override
    public void onItemClick(BaseContacto contacto, int position) {
        String mensaje = "";
        switch (contacto.getNombre()) {
            case "Miguel":
                mensaje = "ojala me apruebe la tarea";
                break;
            case "Fabrizio":
                mensaje = "suspendio fol";
                break;
            case "David":
                mensaje = "buena gente";
                break;
            case "Daniel":
                mensaje = "juega bien al magic";
                break;
            default:
                mensaje = "falta informacion";
        }
        Toast.makeText(this, contacto.getNombre() + ": " + mensaje, Toast.LENGTH_SHORT).show();
    }
}
