/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Usuario usuario = new Usuario();
     Conexao con = new Conexao();
     Connection c  = null;
     PreparedStatement stsm =null;
     ResultSet rs= null;
     
     public boolean pesquisarUsuario(String login, String senha){
         boolean resposta = false;
         try{
            c = con.getConexao();
            stsm = c.prepareStatement("select id,login,senha,nome from usuario where nome='"+login+"';");
            rs = stsm.executeQuery();
            
            if(rs!=null){
                while(rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));
                System.out.println(usuario);
             
            }
                if(usuario.getLogin().equals(login)&&usuario.getSenha().equals(senha)){
                    resposta = true;
                }else{
                    resposta = false;
                }
            }
             
         }catch(Exception e){
             e.printStackTrace();
         }
         finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (stsm != null) try { stsm.close(); } catch (SQLException ignore) {}
            if (c != null) try { c.close(); } catch (SQLException ignore) {}
            
        }
         
         return resposta;
     }
    
    
    
}
