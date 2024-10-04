package com.sistema.api.dto;

public class UsuarioDTO {
    private String cedula;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String rol;
    private String rutaImagenPerfil;

    // Constructor
    public UsuarioDTO(String cedula, String nombre, String apellidos, String telefono, String email, String rol, String rutaImagenPerfil) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.rol = rol;
        this.rutaImagenPerfil = rutaImagenPerfil;
    }

    // Getters and setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRutaImagenPerfil() {
        return rutaImagenPerfil;
    }

    public void setRutaImagenPerfil(String rutaImagenPerfil) {
        this.rutaImagenPerfil = rutaImagenPerfil;
    }
}
