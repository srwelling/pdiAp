<%-- 
    Document   : AndamentoProjeto
    Created on : 30/10/2014, 13:17:44
    Author     : amarildo.pena
--%>

<%@page import="Control.ProjetoDAO"%>
<%@page import="Model.Projeto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Control.TarefaDAO"%>
<%@page import="Model.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tarefas</title>
    </head>
    <body>
        <div name="FormCadTempo">
                Projeto: <br/>
                Pacote: <br/>
                Tópico: <br/>
                <table border='1' align=center>
                <tr>
                    <td align=center>Tarefa</td>
                    <td align=center>Tempo Estimado</td>
                    <td align=center>Tempo Real</td>
                    <td align=center>Data Início</td>
                    <td align=center>Data Término</td>
                    
                </tr>
                <%
                    %>
                
                
                
                <%
                    Tarefa atual = new Tarefa();
                    TarefaDAO tarefas = new TarefaDAO();
                    ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();
                    listaTarefas = tarefas.listarProjetos();
                    for(int i=0;i<listaTarefas.size()-1;i++){
                        
                    int segundos = listaTarefas.get(i).getTempoEstimado(); 
                    int segundo = segundos % 60; 
                    int minutos = segundos / 60; 
                    int minuto = minutos % 60; 
                    int hora = minutos / 60; 
                    String hmsTempoprevisto = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
                    
                    segundos = listaTarefas.get(i).getTempoReal(); 
                    segundo = segundos%60;
                    minutos = segundos/60;
                    minuto = minutos%60;
                    hora = minutos/60;
                    String hmsTemporeal = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
                   
                    
                       
                %>
                <tr>
                    <td align=center><%= listaTarefas.get(i).getNomeTarefa() %></td>
                    <td align=center><input type='text' disabled="" style="width:30%" maxlength="8" value='<%= hmsTempoprevisto %>' ></td>
                    <td align=center><input type='text' disabled="" style="width:30%" maxlength="8" value='<%= hmsTemporeal%>'></td>
                    <td align=center><input type='text' disabled="" maxlength="8" value='<%= listaTarefas.get(i).getDatainicio() %>' ></td>
                    <td align=center><input type='text' disabled="" maxlength="8" value='<%= listaTarefas.get(i).getDatatermino() %>'></td>
                    
                </tr>
                <%    
                    }   
                %>
                
                <tr>
                    <%
                    int segundos = listaTarefas.get(listaTarefas.size()-1).getTemporeal();
                    int segundo = segundos % 60; 
                    int minutos = segundos / 60; 
                    int minuto = minutos % 60; 
                    int hora = minutos / 60; 
                    String hmsTempoprevisto = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
                    
                    segundos = listaTarefas.get(listaTarefas.size()-1).getTemporeal(); 
                    segundo = segundos%60;
                    minutos = segundos/60;
                    minuto = minutos%60;
                    hora = minutos/60;
                    String hmsTemporeal = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
                   
                    
                       
                %>
                    <td align=center><%= listaTarefas.get(listaTarefas.size()-1).getNomeTarefa() %></td>
                    <td align=center><input type='text' disabled="" style="width:30%" maxlength="8" value='<%= hmsTempoprevisto  %>' ></td>
                    <td align=center><input type='text' disabled="" style="width:30%" maxlength="8" value='<%= hmsTemporeal %>'></td>
                    <td align=center><input type='text' disabled="" maxlength="8" value='<%= listaTarefas.get(listaTarefas.size()-1).getDatainicio() %>' ></td>
                    <td align=center><input type='text' disabled="" maxlength="8" value='<%= listaTarefas.get(listaTarefas.size()-1).getDatatermino() %>'></td>
                    
                </tr>
            </table>
        </div>
                    
                    <div>
                        <ol>
                        <a href="Servlet">Adicionar Tarefa</a><br/>
                        <a href="Servlet">Editar Tarefa</a><br/>
                        <a href="Servlet">Excluir Tarefa</a><br/>
                        </ol>
                        
                        
                    </div>
    </body>
</html>
