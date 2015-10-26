package com.alejandrobarrero.practica4;

public class Lista_Entrada {
    private int idImagen;
    private String nombreActividad;
    private String descripcion;
    private int idAct;

    public Lista_Entrada(int idImagen, String nombreActividad, String descripcion, int idAct) {
        this.idImagen = idImagen;
        this.nombreActividad = nombreActividad;
        this.descripcion = descripcion;
        this.idAct = idAct;
    }

    public int getIdImagen()
    {
        return idImagen;
    }

    public String getNombreActividad()
    {
        return nombreActividad;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public int getIdAct()
    {
        return idAct;
    }

}