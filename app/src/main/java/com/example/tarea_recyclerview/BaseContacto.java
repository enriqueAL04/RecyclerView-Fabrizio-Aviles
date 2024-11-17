package com.example.tarea_recyclerview;

public class BaseContacto {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String telefono;
    private final int foto;

    public BaseContacto(String nombre, String apellido, String email, String telefono, int foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getFoto() {
        return foto;
    }
}
