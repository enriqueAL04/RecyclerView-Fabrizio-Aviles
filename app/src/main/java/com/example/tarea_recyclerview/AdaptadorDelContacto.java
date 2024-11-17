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

    // lista de contactos y contexto de la aplicacion
    private final List<BaseContacto> contactos;
    private final Context context;

    // interfaz para manejar clics
    public interface OnItemClickListener {
        void onItemClick(BaseContacto contacto, int position);
    }

    private final OnItemClickListener listener;

    public AdaptadorDelContacto(Context context, List<BaseContacto> contactos, OnItemClickListener listener) {
        this.context = context;
        this.contactos = contactos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        BaseContacto contacto = contactos.get(position);
        holder.nombre.setText(contacto.getNombre() + " " + contacto.getApellido());
        holder.email.setText(contacto.getEmail());
        holder.telefono.setText(contacto.getTelefono());
        holder.foto.setImageResource(contacto.getFoto());

        // configura el evento clic para este elemento
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(contacto, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    // viewholder para almacenar vistas individuales
    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nombre, email, telefono;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.contactoFoto);
            nombre = itemView.findViewById(R.id.contactoNombre);
            email = itemView.findViewById(R.id.contactoEmail);
            telefono = itemView.findViewById(R.id.contactoTelefono);
        }
    }
}
