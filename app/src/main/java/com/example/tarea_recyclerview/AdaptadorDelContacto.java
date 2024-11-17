package com.example.tarea_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdaptadorDelContacto extends RecyclerView.Adapter<AdaptadorDelContacto.ContactoViewHolder> {

    // lista de contactos y el contexto de la actividad
    private final List<BaseContacto> contactos;
    private final Context context;

    // constructor de contexto y contactos
    public AdaptadorDelContacto(Context context, List<BaseContacto> contactos) {
        this.context = context;
        this.contactos = contactos;
    }

    // crear un nuevo ViewHolder (item de la lista)
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infla (carga) el layout del item (item_contacto) en un objeto View
        View view = LayoutInflater.from(context).inflate(R.layout.item_contacto, parent, false);
        // crea y retorna un nuevo ContactoViewHolder que representa un item de la lista
        return new ContactoViewHolder(view);
    }

    // asigna los datos al ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        // obtiene el contacto en la posicion actual
        BaseContacto contacto = contactos.get(position);
        // asigna los valores del contacto a los campos del ViewHolder
        holder.nombre.setText(contacto.getNombre() + " " + contacto.getApellido());
        holder.email.setText(contacto.getEmail());
        holder.telefono.setText(contacto.getTelefono());
        holder.foto.setImageResource(contacto.getFoto());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    // clase que representa un item individual en el RecyclerView
    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nombre, email, telefono;

        // constructor que inicializa las vistas del item a partir del layout
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.contactoFoto);
            nombre = itemView.findViewById(R.id.contactoNombre);
            email = itemView.findViewById(R.id.contactoEmail);
            telefono = itemView.findViewById(R.id.contactoTelefono);
        }
    }
}
