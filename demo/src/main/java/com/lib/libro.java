package com.lib;

public abstract class libro implements Comparable<libro> {
    //atributes
    protected int id;
    protected String name;
    protected String categoria;
    protected int precio;

    //construct
    public libro(String name,String categoria,int precio){
        this.name = name;
        this.categoria = categoria;
        this.precio = precio;
    }

    public libro(int id, String name,String categoria,int precio){
        this.id = id;
        this.name = name;
        this.categoria = categoria;
        this.precio = precio;
    }

     //get
    public String getName(){
        return name;
    }
    public String getCategoria(){
        return categoria;
    }
    public int getPrecio(){
        return precio;
    }

    public int getId(){
        return id;
    }

    //set
    public void setName(String name){
        this.name = name;
    }
    public void setCorreo(String categoria){
        this.categoria = categoria;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }

    //methodo concreto
    public void showInfo(){
        System.out.println("Name: " + name + " Categoria: " + categoria + " Precio: " + precio);
    }

    //methodo abstracto
    public abstract void verTipo();

    @Override
    public int compareTo(libro b){
        return this.precio - b.precio;
    }
}
