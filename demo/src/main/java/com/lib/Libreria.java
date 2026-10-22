/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.lib;

/**
 *
 * @author NIkolai
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Libro, Categoria, Empleados, Clientes, Prestamo, Capacidad
        //OBJ : Libro, Empleados, Clientes
        //Abstr: Categoria, Capacidad
        //Rel: Prestamo
        
        //Clase Abstracta: Libro, Persona
        //Herencias: Empleados, Clientes, AudioLibro, LibroDigital, LibroPapel
        //Interfaces: Prestar, Descargar

        cliente c1 = new cliente("Dummy1", 0, "dummy1@gmail.com", 0);
        cliente c2 = new cliente("Dummy2", 1, "dummy2@gmail.com", 0);

        empleado e1 = new empleado("Dummy3", 0, "dummy3@gmail.com", 100);
        empleado e2 = new empleado("Dummy4", 1, "dummy4@gmail.com", 100);

        c1.showInfo();
        c2.showInfo();

        e1.showInfo();
        e2.showInfo();

        c1.verRol();
        c2.verRol();

        e1.verRol();
        e2.verRol();

        // librofisico lf1 = new librofisico("LibroFisico1", 0, "cocina", 30, 250);
        // librofisico lf2 = new librofisico("LibroFisico2", 1, "suspenso", 35, 250);

        // librodigital ld1 = new librodigital("LibroDigital1", 0, "suspenso", 2, 300);

        // audiolibro al1 = new audiolibro("AudioLibro1", 0, "Economia", 2, 30.4);

        // System.out.println("---Catalogo---");
        // libro[] libros = {lf1,lf2,ld1,al1}; 
        // for (libro i : libros){
        //     i.verTipo();
        // }
        // System.out.println("---Prestamos---");
        // lf1.prestar();
        // lf2.prestar();
        // System.out.println("---Descargables---");
        // ld1.guardar();
        // al1.tamano();

        // System.out.println("---Polimorfismo de Interfaces---");
        // Descargar[] Descargables = {ld1,al1};
        // for (Descargar j : Descargables){
        //     j.guardar();
        // }
    }
    
}
