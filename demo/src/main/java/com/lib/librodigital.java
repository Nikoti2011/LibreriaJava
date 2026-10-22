package com.lib;

public class librodigital extends libro implements Descargar{
    private int tamano;

    public librodigital(int id, String name,String categoria, int precio,int tamano){
        super(id, name,categoria,precio);
        this.tamano = tamano;
    }
    public librodigital(String name,String categoria, int precio,int tamano){
        super(name,categoria,precio);
        this.tamano = tamano;
    }

    public int getTamano(){
        return tamano;
    }

    public void setTamano(int tamano){
        this.tamano = tamano;
    }

    @Override
    public void verTipo(){
        System.out.println("Libro: " + name + " Tamano: " + tamano + " Precio: " + precio);
    }

    @Override
    public void tamano(){
        System.out.println("Tamano del Libro: " + name + " = " + tamano + "mb");
    }

    @Override
    public void guardar(){
        System.out.println("Guardando Libro: " + name);
    }
}
