package com.lib;

public class empleado extends persona{
    private int salario;

    public empleado(String name,int id,String correo, int salario){
        super(name, id, correo);
        this.salario = salario;
    }

    public int getSalario(){
        return salario;
    }

    public void setSalario(int salario){
        this.salario = salario;
    }

    @Override
    public void verRol(){
        System.out.println("Empleado: " + name + " Salario:" + salario);
    }
}
