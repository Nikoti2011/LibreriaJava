package com.lib;
import java.sql.*;
import java.util.ArrayList;


public class InvDAO {
    private Connection conn;

    public InvDAO(Connection conn){
        this.conn = conn;
    }

    public void Create(String name, int cantidad, int precio, String genero, String autor){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Inventario(name,cantidad,precio,genero,autor) VALUES (?,?,?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, cantidad);
            ps.setInt(3, precio);
            ps.setString(4, genero);
            ps.setString(5, autor);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void UpdatePrecio(int precio, int id){
        try {
            PreparedStatement psc = conn.prepareStatement("UPDATE Inventario SET precio = ? WHERE id = ?");
            psc.setInt(1, precio);
            psc.setInt(2, id);
            psc.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Get(){
        try {
            Statement cursor = conn.createStatement();
            ResultSet rs = cursor.executeQuery("SELECT * FROM Inventario");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name")+" " +
                    rs.getInt("cantidad")+" " +
                    rs.getInt("precio")+" " +
                    rs.getString("genero")+" " +
                    rs.getString("autor")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Delete(int id){
        try {
            PreparedStatement psd = conn.prepareStatement("DELETE FROM Inventario WHERE id = ?");
            psd.setInt(1, id);
            psd.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void CreateTable(){
        try {
            Statement cursor = conn.createStatement();
            cursor.execute("CREATE TABLE IF NOT EXISTS Libros("+ 
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "cantidad INTEGER," +
                "precio INTEGER," +
                "genero TEXT," +
                "autor TEXT," + 
                "tipo TEXT," +
                "tamano INTEGER," +
                "paginas INTEGER,"+
                "duracion REAL"+
                ")"
            );
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void CreateBook(libro L){
        // ArrayList<String> milibro
        try {
            String name = L.getName();
            int precio = L.getPrecio();
            String genero = L.getCategoria();
            int tamano = 0;
            String tipo = "";
            int paginas = 0;
            double duracion = 0.0;
            
            if(L instanceof librodigital){
                librodigital LD = (librodigital)L;
                tamano = LD.getTamano();
                tipo = "Digital";
            }
            else if (L instanceof librofisico) {
                librofisico LF = (librofisico)L;
                paginas = LF.getPaginas();
                tipo = "Fisico";
            }
            else if (L instanceof audiolibro){
                audiolibro AL = (audiolibro)L;
                duracion = AL.getDuracion();
                tipo = "Audio";
            }

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Libros(name,precio,genero,tamano,tipo,paginas,duracion) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, precio);
            ps.setString(3, genero);
            ps.setInt(4, tamano);
            ps.setString(5, tipo);
            ps.setInt(6, paginas);
            ps.setDouble(7, duracion);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<libro> GetLibros(){  
        ArrayList<libro> ret = new ArrayList<>(); 
        try {
            Statement cursor = conn.createStatement();
            ResultSet rs = cursor.executeQuery("SELECT * FROM Libros");
            while (rs.next()){
                librodigital LD = new librodigital(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("genero"),
                    rs.getInt("precio"),
                    rs.getInt("tamano")
                );
                ret.add(LD);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public void DeleteLibros(int id){
        try {
            PreparedStatement psd = conn.prepareStatement("DELETE FROM Libros WHERE id = ?");
            psd.setInt(1, id);
            psd.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void UpdateLibro(String name, String categoria, int precio, int id){
        try {
            if (name != null){
                PreparedStatement psc = conn.prepareStatement("UPDATE Libros SET name = ? WHERE id = ?");
                psc.setString(1, name);
                psc.setInt(2, id);
                psc.execute();
            }

            if (categoria != null){
                PreparedStatement psc = conn.prepareStatement("UPDATE Libros SET genero = ? WHERE id = ?");
                psc.setString(1, categoria);
                psc.setInt(2, id);
                psc.execute();
            }

            if (precio != -1){
                PreparedStatement psc = conn.prepareStatement("UPDATE Libros SET precio = ? WHERE id = ?");
                psc.setInt(1, precio);
                psc.setInt(2, id);
                psc.execute();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<libro> FilterLibro(String name){
        ArrayList<libro> ret = new ArrayList<>(); 
        try {
            PreparedStatement psc = conn.prepareStatement("SELECT * FROM Libros WHERE name = ?");
            psc.setString(1, name);
            ResultSet rs = psc.executeQuery();
            while (rs.next()){
                String format = rs.getString("tipo");
                libro l = null;
                if (format.equals("Fisico")){
                    l = new librofisico(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("genero"),
                    rs.getInt("precio"),
                    rs.getInt("paginas"));
                }
                else if (format.equals("Digital")){
                    l = new librodigital(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("genero"),
                    rs.getInt("precio"),
                    rs.getInt("tamano"));
                }
                else if (format.equals("Audio")){
                    l = new audiolibro(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("genero"),
                    rs.getInt("precio"),
                    rs.getDouble("duracion"));
                }

                if (l != null) ret.add(l);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }
}