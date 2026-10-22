package com.lib;

public class librofisico extends libro implements Prestar{
    private int paginas;

    public librofisico(String name,String categoria, int precio,int paginas){
        super(name, categoria,precio);
        this.paginas = paginas;
    }
    public librofisico(int id, String name,String categoria, int precio,int paginas){
        super(id, name, categoria,precio);
        this.paginas = paginas;
    }

    public int getPaginas(){
        return paginas;
    }

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }

    @Override
    public void verTipo(){
        System.out.println("Libro: " + name + " Paginas: " + paginas);
    }

    @Override
    public void prestar(){
        System.out.println("Prestando Libro: " + name);
    }

    @Override
    public void devolver(){
        System.out.println("Devolviendo Libro: " + name);
    }
}
