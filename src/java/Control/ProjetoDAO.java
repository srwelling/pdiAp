/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author amarildo.pena
 */
public class ProjetoDAO {
     ArrayList<Projeto> listaProjetos = new ArrayList<Projeto>();
     Projeto projeto = new Projeto();
     Conexao con = new Conexao();
     Connection c  = null;
     PreparedStatement stsm =null;
     ResultSet rs= null;
    
     public void inserirProjeto(String nomeprojeto, int tempoestimado, int temporeal, Date datainicial, Date datafinal){
      
      try{
      Connection con = this.con.getConexao();
      Statement stmt;
      stmt = con.createStatement();
      
      Projeto p1 = new Projeto();
      stmt.executeUpdate("INSERT INTO projeto VALUES ("+tempoestimado+","+temporeal+",'"+datainicial+"','"+datafinal+"','"+nomeprojeto+"');");  
      
      
      stmt.close();
      System.out.println("Objeto inserido");
         }catch(Exception e){
          e.printStackTrace();
         }
     }
     public Projeto procurarProjeto(int i){
      Projeto retorno = new Projeto();
      try{
            c = con.getConexao();
            stsm = c.prepareStatement("select * from projeto");
            rs = stsm.executeQuery();
            
            if(rs!=null){
                while(rs.next()) {
                    if(rs.getInt("idprojeto")==i){
                        System.out.println("encontrei");
                        projeto.setIdProjeto(rs.getInt("idprojeto"));
                        projeto.setNomeProjeto(rs.getString("nomeprojeto"));
                        projeto.setTempoEstimado(rs.getInt("tempoestimado"));
                        projeto.setTempoReal(rs.getInt("temporeal"));
                        projeto.setDataInicial(rs.getDate("datainicial"));
                        projeto.setDataFinal(rs.getDate("datafinal"));
                        retorno = projeto;
                        break;
                    }
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
      
       return retorno;
     }
    
    
    public ArrayList<Projeto> listarProjetos(){
        ArrayList<Projeto> lista = new ArrayList<>();
         try{
            c = con.getConexao();
            stsm = c.prepareStatement("select * from projeto");
            rs = stsm.executeQuery();
            
            if(rs!=null){
                while(rs.next()) {
                projeto.setIdProjeto(rs.getInt("idprojeto"));
                projeto.setNomeProjeto(rs.getString("nomeprojeto"));
                projeto.setTempoEstimado(rs.getInt("tempoestimado"));
                projeto.setTempoReal(rs.getInt("temporeal"));
                projeto.setDataInicial(rs.getDate("datainicial"));
                projeto.setDataFinal(rs.getDate("datafinal"));
                lista.add(projeto);
                projeto = new Projeto();
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
         
         return lista;
     }
}
