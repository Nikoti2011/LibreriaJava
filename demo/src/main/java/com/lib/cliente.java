package com.lib;

public class cliente extends persona{
    private int multa;

    public cliente(String name,int id,String correo, int multa){
        super(name, id, correo);
        this.multa = multa;
    }

    public int getMulta(){
        return multa;
    }

    public void setMulta(int multa){
        this.multa = multa;
    }

    @Override
    public void verRol(){
        System.out.println("Cliente: " + name + " Multa:" + multa);
    }
}
