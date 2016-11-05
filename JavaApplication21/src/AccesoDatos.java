/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author USUARIO
 */
public class AccesoDatos {
    
    Fachada fachada;
    ResultSet respuesta;
    Statement instruccion;
    
    public AccesoDatos(){
        fachada = new Fachada();
    }
    
    /**
     * Método que se encarga de ingresar la información de un programa a la base de datos
     * @param cod
     * @param nom
     * @param niv 
     * @param cred 
     * @return 
     */
    
    public int ingresarUsuario(String id, String pass, String cdl, String pNom, String sNom,String pApe,String sApe, String tel1,String tel2,String dir,String foto,String fdn,String estado,String id_sede,String tipo){
        int numFilas;
        String consulta="INSERT INTO usuario VALUES ('"+ id+"','"+pass+"','"+cdl+"','"+pNom+"','"+sNom+"','"+pApe+"','"+sApe+"','"+tel1+"','"+tel2+"','"+dir+"','"+foto+"','"+fdn+"','"+estado+"',"+id_sede+",'"+tipo+"');";
        System.out.println(consulta);
        try{
           Connection con = fachada.conectarABD();
           instruccion = con.createStatement();
           numFilas = instruccion.executeUpdate(consulta);
           fachada.cerrarConexion(con);
        }catch(SQLException sqle){
            System.out.println("Error de Sql al conectar en programa \n"+sqle);
            numFilas=-1;
        }
        catch(Exception e){
            System.out.println("Ocurrió cualquier otra excepcion en programa"+e);
            numFilas=-1;
        }
        
        return numFilas;
    }
    
    public int ingresarSede(String id_sede,String nom,String ciudad,String direccion,String tlf1,String tlf2,String gerente){
        int numFilas;
        String consulta = "INSERT INTO sede VALUES ('"+ id_sede + "','" + nom + "','" + ciudad + "','" + direccion + "','"+ tlf1+  "','" + tlf2 + "','"+gerente+"');";
        try{
           Connection con = fachada.conectarABD();
           instruccion = con.createStatement();
           numFilas = instruccion.executeUpdate(consulta);
           fachada.cerrarConexion(con);
        }catch(SQLException sqle){
            System.out.println("Error de Sql al conectar en programa \n"+sqle);
            numFilas=-1;
        }
        catch(Exception e){
            System.out.println("Ocurrió cualquier otra excepcion en programa"+e);
            numFilas=-1;
        }
        return numFilas;
    }
    

    
    public ResultSet loguearse(String nom){
        String consulta ="SELECT id_usuario,password FROM usuario WHERE id_usuario='" + nom + "';";
        
        try{
            Connection con = fachada.conectarABD();
            instruccion = con.createStatement();
            respuesta = instruccion.executeQuery(consulta);
            fachada.cerrarConexion(con);
            
               
        }catch(SQLException sqle){
            System.out.println("Error al consultar datos");
        }
        
        return respuesta;
    }
    
    public ResultSet validarUsuario(String nom){
        String consulta ="SELECT id_usuario,tipo FROM usuario WHERE id_usuario='" + nom + "';";
        
        try{
            Connection con = fachada.conectarABD();
            instruccion = con.createStatement();
            respuesta = instruccion.executeQuery(consulta);
            fachada.cerrarConexion(con);
            
               
        }catch(SQLException sqle){
            System.out.println("Error al consultar datos");
        }
        
        return respuesta;
    }
    
    
   
    
}