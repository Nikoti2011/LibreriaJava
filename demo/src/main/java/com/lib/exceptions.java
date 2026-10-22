package com.lib;

public class exceptions {
    //crear exception propia
    public static void verificarEx(int inv){
        if(inv <= 0){
            throw new UnsupportedOperationException("no hay inventario valido");
        }
        System.out.println("Inventario Actual: " + inv);
    }
    public static void main(String[] args) {
        try {
            verificarEx(5);
            verificarEx(-1);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println(":D");
        }
    }
}
//arthmeticException operacion math incorecta
//nullPointerException intenatr usar objeto vacio
//arrayIndexOutBoundsException
//numberFormatException usar un numero como texto
//classCastException casting incorecto entre tipos

