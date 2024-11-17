package com.example.tarea_recyclerview;

public class BaseContacto {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int foto;

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