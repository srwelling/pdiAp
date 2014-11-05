/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Projeto;
import Model.Usuario;
import Model.Tarefa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author amarildo.pena
 */
public class TarefaDAO {
     Tarefa tarefa = new Tarefa();
     Conexao con = new Conexao();
     Connection c  = null;
     PreparedStatement stsm =null;
     ResultSet rs= null;
     
     
     public void inserirTarefa(String nomeprojeto, int tempoestimado, int temporeal, Date datainicial, Date datafinal, int idPacote){
      
      try{
      Connection con = this.con.getConexao();
      Statement stmt;
      stmt = con.createStatement();
      
      Projeto p1 = new Projeto();
      stmt.executeUpdate("INSERT INTO tarefa VALUES ("+tempoestimado+","+temporeal+",'"+datainicial+"','"+datafinal+"','"+nomeprojeto+"',default,'"+idPacote+"');");  
      
      
      stmt.close();
      System.out.println("Objeto inserido");
         }catch(Exception e){
          e.printStackTrace();
         }
     }
     
     public Tarefa procurarTarefa(int i){
      Tarefa retorno = new Tarefa();
      try{
            c = con.getConexao();
            stsm = c.prepareStatement("select * from projeto");
            rs = stsm.executeQuery();
            
            if(rs!=null){
                while(rs.next()) {
                    if(rs.getInt("idprojeto")==i){
                        System.out.println("encontrei");
                        tarefa.setIdTarefa(rs.getInt("idprojeto"));
                        tarefa.setIdPacote(rs.getInt("idpacote"));
                        tarefa.setNomeTarefa(rs.getString("nomeprojeto"));
                        tarefa.setTempoprevisto(rs.getInt("tempoestimado"));
                        tarefa.setTemporeal(rs.getInt("temporeal"));
                        tarefa.setDatainicial(rs.getDate("datainicial"));
                        tarefa.setDatatermino(rs.getDate("datafinal"));
                        retorno = tarefa;
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
     
     
     
     
     
     
     public ArrayList<Tarefa> listarTarefas(int i){
         ArrayList<Tarefa> teste = new ArrayList<Tarefa>();
         try{
            c = con.getConexao();
            stsm = c.prepareStatement("select * from tarefa where idpacote="+i);
            rs = stsm.executeQuery();
            
           
            while(rs.next()) {
                tarefa.setIdTarefa(rs.getInt("idtarefa"));
                tarefa.setTempoprevisto(rs.getInt("tempoprevisto"));
                tarefa.setTemporeal(rs.getInt("temporeal"));
                tarefa.setDatainicial(rs.getDate("datainicial"));
                tarefa.setDatatermino(rs.getDate("datatermino"));
                tarefa.setNomeTarefa(rs.getString("nometarefa"));
                tarefa.setIdPacote(rs.getInt("idpacote"));
                teste.add(tarefa);
                System.out.println(teste);
                tarefa  = new Tarefa();
            }
            
         }catch(Exception e){
             e.printStackTrace();
         }
         finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (stsm != null) try { stsm.close(); } catch (SQLException ignore) {}
            if (c != null) try { c.close(); } catch (SQLException ignore) {}
        }

         System.out.println(teste);
         return teste;
     }
    
}
