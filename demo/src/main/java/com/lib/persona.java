package com.lib;
public abstract class persona {
    //atributes
    protected String name;
    protected int id;
    protected String correo;

    //construct
    public persona(String name,int id,String correo){
        this.name = name;
        this.id = id;
        this.correo = correo;
    }

    //get
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getCorreo(){
        return correo;
    }

    //set
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }

    //methodo concreto
    public void showInfo(){
        System.out.println("Name: " + name + " Id: " + id + " Correo: " + correo);
    }

    //methodo abstracto
    public abstract void verRol();

}
