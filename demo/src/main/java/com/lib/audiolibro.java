package com.lib;

public class audiolibro extends libro implements Descargar{
    private double duracion;

    public audiolibro(String name,String categoria, int precio,double duracion){
        super(name, categoria,precio);
        this.duracion = duracion;
    }

    public audiolibro(int id, String name,String categoria, int precio,double duracion){
        super(id,name, categoria,precio);
        this.duracion = duracion;
    }

    public double getDuracion(){
        return duracion;
    }

    public void setDuracion(double duracion){
        this.duracion = duracion;
    }

    @Override
    public void verTipo(){
        System.out.println("Libro: " + name + " Duracion: " + duracion);
    }

    @Override
    public void tamano(){
        System.out.println("Tamano del Libro: " + name + " = " + duracion + " min");
    }

    @Override
    public void guardar(){
        System.out.println("Guardando Libro: " + name);
    }
}