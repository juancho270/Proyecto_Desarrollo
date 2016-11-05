
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juancho270
 */
public class Implementacion {
    AccesoDatos datos;

    public Implementacion() {
        datos = new AccesoDatos();
    }
    
    
    public boolean Loguearse (String nombre, String contraseña) throws SQLException{
       int contador = 0;
       int contador2 = 0;
       boolean validacion = false;
       String[] info = null;
       String[] pass = null;
       ResultSet respuesta = datos.loguearse(nombre);
       
       while (respuesta.next()) {
               String em = respuesta.getString("id_usuario");
               info = em.split("\n");
               String pw = respuesta.getString("password");
               pass = pw.split("\n");   
       }
       
                if (info == null || pass == null){
                   validacion = false;
               }else{
               for (int i =0; i < info.length; i++){
                   System.out.println(info[i]);
                   System.out.println(nombre);
                   if(info[i].equals(nombre)){
                       contador2++;
                   }
               }
               for (int i= 0 ; i < pass.length;i++){
                   System.out.println(pass[i]);
                   System.out.println(contraseña);
                   if (pass[i].equals(contraseña)){
                       contador++;
                   }
               }
                }
               System.out.println(contador);
                   System.out.println(contador2);
               if (contador != 0 && contador2 != 0){
                   validacion = true;
               }
        System.out.println(validacion);
        return validacion;
       
    }
    
    public String tipoUsuario(String nombre) throws SQLException{
        System.out.println("entro");
         String respuestas = "";
         String[] tipo = null;
         String[] name = null;
         ResultSet respuesta = datos.validarUsuario(nombre);
       
       while (respuesta.next()) {
               String em = respuesta.getString("id_usuario");
               name = em.split("\n");
               String pw = respuesta.getString("tipo");
               tipo = pw.split("\n");   
       }
        for(int i = 0 ; i<tipo.length;i++){
            System.out.println(tipo[i]);
            
        }
        respuestas = tipo[0];
        System.out.println(tipo.length);
        return respuestas;
    }
}
