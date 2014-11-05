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
public class PacoteDAO {
     ArrayList<Pacote> listaProjetos = new ArrayList<Pacote>();
     Pacote pacote = new Pacote();
     Conexao con = new Conexao();
     Connection c  = null;
     PreparedStatement stsm =null;
     ResultSet rs= null;
    
     public void inserirPacote(String nomepacote, int tempoestimado, int temporeal, Date datainicial, Date datafinal, int idprojeto){
      
      try{
      Connection con = this.con.getConexao();
      Statement stmt;
      stmt = con.createStatement();
      
      Projeto p1 = new Projeto();
      stmt.executeUpdate("insert into pacote values("+tempoestimado+","+temporeal+",'"+datainicial+"','"+datafinal+"','"+nomepacote+"',default,"+idprojeto+");");  
      
      
      stmt.close();
      System.out.println("Objeto inserido");
         }catch(Exception e){
          e.printStackTrace();
         }
     }
    
     public Pacote procurarPacote(int i){
      Pacote retorno = new Pacote();
      try{
            c = con.getConexao();
            stsm = c.prepareStatement("select * from pacote where idpacote="+i);
            rs = stsm.executeQuery();
            
            if(rs!=null){
                while(rs.next()) {
                    
                        System.out.println("encontrei");
                        pacote.setIdPacote(rs.getInt("idpacote"));
                        pacote.setIdProjeto(rs.getInt("idprojeto"));
                        pacote.setNomePacote(rs.getString("nomepacote"));
                        pacote.setTempoEstimado(rs.getInt("tempoestimado"));
                        pacote.setTempoReal(rs.getInt("temporeal"));
                        pacote.setDataInicial(rs.getDate("datainicial"));
                        pacote.setDataFinal(rs.getDate("datafinal"));
                        retorno = pacote;
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
     
     
     
    
    public ArrayList<Pacote> listarPacotes(int idProjeto){
        ArrayList<Pacote> lista = new ArrayList<>();
         try{
            c = con.getConexao();
            stsm = c.prepareStatement("select * from pacote where idprojeto="+idProjeto);
            rs = stsm.executeQuery();
            
            if(rs!=null){
                while(rs.next()) {
                pacote.setIdPacote(rs.getInt("idpacote"));
                pacote.setNomePacote(rs.getString("nomepacote"));
                pacote.setTempoEstimado(rs.getInt("tempoestimado"));
                pacote.setTempoReal(rs.getInt("temporeal"));
                pacote.setDataInicial(rs.getDate("datainicial"));
                pacote.setDataFinal(rs.getDate("datafinal"));
                lista.add(pacote);
                pacote = new Pacote();
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
