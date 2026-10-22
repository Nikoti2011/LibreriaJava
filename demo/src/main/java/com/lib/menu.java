package com.lib;

import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    Scanner SS = new Scanner(System.in);
        int choice = 0;
        InvDAO Dao;

        public menu(InvDAO Dao){
            this.Dao = Dao;
        }
    public void menuUsuario(){

        do{
            System.out.println("--- Libreria ---");
            System.out.println("- Registrar Libro [1]");
            System.out.println("- Eliminar Libro [2]");
            System.out.println("- Editar info Libro [3]");
            System.out.println("- Filtrar Libros [4]");
            System.out.println("- Listar Libros [5]");
            System.out.println("- Cerrar Menu [6]");

            choice = SS.nextInt();

            switch (choice){
                case 1:
                    SS.nextLine();
                    System.out.println("Registrar");
                System.out.println("Nombre: ");
                String nam = SS.nextLine();
                System.out.println("Precio: ");
                int prec = SS.nextInt();
                SS.nextLine();
                System.out.println("Genero: ");
                String gen = SS.nextLine();
                System.out.println("Tipo 1:Fisico 2:Digital 3:Audio : ");
                int res = SS.nextInt(); 
                SS.nextLine();
                if (res == 1){
                    System.out.println("Libro Fisico");
                    System.out.println("Paginas: ");
                    int pag = SS.nextInt();
                    Dao.CreateBook(new librofisico(nam, gen, prec, pag));
                }
                else if (res == 2) {
                    System.out.println("Libro Digital");
                    System.out.println("Tamano: ");
                    int tam = SS.nextInt();
                    Dao.CreateBook(new librodigital(nam, gen, prec,tam ));
                }
                else if (res == 3) {
                    System.out.println("Duracion: ");
                    double dub = SS.nextDouble();
                    System.out.println("Audio Libro");
                    Dao.CreateBook(new audiolibro(nam, gen, prec, dub));
                }
                System.out.println("Libro Registrado");
                break;
                case 2: 
                    System.out.println("Eliminar");
                    System.out.println("ID de libro al eliminar");
                    int id = SS.nextInt();
                    Dao.DeleteLibros(id);
                    System.out.println("Libro Eliminado");
                break;
                case 3: 
                    System.out.println("Editar");
                    System.out.println("ID de libro a editar");
                    int Edit = SS.nextInt();
                    System.out.println("Cambiar Nombre [1], Cambiar Categoria [2], Cambiar Precio [3]");
                    int opcion = SS.nextInt();
                    SS.nextLine();
                    switch (opcion) {
                        case 1:
                            String newName = SS.nextLine();
                            Dao.UpdateLibro(newName, null, -1, Edit);
                        break;
                        case 2:
                            String newCate = SS.nextLine();
                            Dao.UpdateLibro(null, newCate, -1, Edit);
                        break;
                        case 3:
                            int newPric = SS.nextInt();
                            Dao.UpdateLibro(null, null, newPric, Edit);
                        break;
                        default:
                            break;
                    }
                    System.out.println("Libro actualizado");
                break;
                case 4:
                    SS.nextLine();
                    System.out.println("Filtrar");
                    String search = SS.nextLine();
                    ArrayList<libro> resu = Dao.FilterLibro(search);
                    for (libro l : resu){
                        System.out.println(l.getId() + " " + l.getName() + " " + l.getPrecio() + " " + l.getCategoria());
                    }
                break;
                case 5:
                    System.out.println("Listar");
                    ArrayList<libro> list = Dao.GetLibros();
                    for (libro i : list){
                        System.out.println(i.getId() + " " + i.getName() + " " + i.getPrecio() + " " + i.getCategoria());
                    }
                break;
                case 6: System.out.println("Cerrar"); break;
                default: System.out.println("No se encontro accion relacionada");
            }
        } while (choice != 6);
    }
}


//registrar libro, eliminar, editar, filtrar, listado, cerrar 