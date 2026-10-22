package com.lib;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class bd {
    //JDBC java db conect
    public static void main(String[] args){
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:libreria.bd");
            System.out.println("Conexion exitosa");
            Statement cursor = conn.createStatement();
            cursor.execute("DROP TABLE IF EXISTS Inventario");
            cursor.execute("CREATE TABLE IF NOT EXISTS Inventario("+ 
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT," +
            "cantidad INTEGER," +
            "precio INTEGER," +
            "genero TEXT," +
            "autor TEXT" + 
            ")"
            );
            System.out.println("Se creo tabla");

            InvDAO Dao = new InvDAO(conn);

            /* Dao.Create("Dummy1", 30, 4000, "test", "niko");
            Dao.Create("Dummy2", 30, 4000, "test", "niko");

            Dao.Get();

            Dao.UpdatePrecio(3000,2);

            Dao.Get();

            Dao.Delete(1);

            Dao.Get(); */

            //Dao.CreateTable();

            ArrayList<String> milibro = new ArrayList<>();
            milibro.add("Dummy3");
            milibro.add("30");
            milibro.add("4000");
            milibro.add("test");
            milibro.add("niko");
            milibro.add("fisico");

            //ArrayList<String> milibro2 = new ArrayList<>(Arrays.asList(null));

            //Dao.CreateBook(milibro);

            //Dao.GetLibros();

           /*  librodigital LD = new librodigital("LDDummy", "test", 100, 100210);
            librodigital LD2 = new librodigital("LDDummy2", "test", 1020, 1001320);
            librodigital LD3 = new librodigital("LDDummy3", "test", 11100, 101300);
            librodigital LD4 = new librodigital("LDDummy4", "test", 10330, 1001310);
            librodigital LD5 = new librodigital("LDDummy5", "test", 10220, 100640);
            
            Dao.CreateBook(LD);
            Dao.CreateBook(LD2);
            Dao.CreateBook(LD3);
            Dao.CreateBook(LD4);
            Dao.CreateBook(LD5);

            Dao.GetLibros(); */

            /* ArrayList<libro> ret = Dao.GetLibros();
            
            //comparator
            Comparator<libro> porprecio = (a,b) -> b.getName() .compareTo( a.getName());
            //neg a,b . 0 equal, pos b,a

            Collections.sort(ret,porprecio); */

            /* for (libro i : ret){
                i.verTipo();
            } */

            /* librodigital LDe = new librodigital("LDeDummy", "test", 100, 100210);
            librodigital LDe2 = new librodigital("LDeDummy2", "test", 1020, 1001320);
            librodigital LDe3 = new librodigital("LDeDummy3", "test", 11100, 101300);
            librodigital LDe4 = new librodigital("LDeDummy4", "test", 10330, 1001310);
            librodigital LDe5 = new librodigital("LDeDummy5", "test", 10220, 100640);
            
            Dao.CreateBook(LDe);
            Dao.CreateBook(LDe2);
            Dao.CreateBook(LDe3);
            Dao.CreateBook(LDe4);
            Dao.CreateBook(LDe5); */

            //Dao.GetLibros();

            /* ArrayList<libro> rete = Dao.GetLibros();

            Collections.sort(rete);

            for (libro i : rete){
                i.verTipo();
            } */

            menu m = new menu(Dao);

            m.menuUsuario();
            
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}


//id,precio,tipo

//categoria,duracion,tamano

//registrar libro, eliminar, editar, filtrar, listado, cerrar