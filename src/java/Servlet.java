/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.Conexao;
import Control.PacoteDAO;
import Control.ProjetoDAO;
import Control.TarefaDAO;
import Control.UsuarioDAO;
import Model.Pacote;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amarildo.pena
 */
public class Servlet extends HttpServlet {
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String controle = request.getParameter("controle");
            System.out.println(controle);
            
            
            if(controle.equalsIgnoreCase("redirecionarProjeto")){
                String parcial;
                parcial = request.getParameter("idprojeto");
                request.setAttribute("retornoProjeto", parcial);
                RequestDispatcher rd = 
                request.getRequestDispatcher("selecionarPacote.jsp"); 
                rd.forward(request, response); 
                
                
            }
            if(controle.equalsIgnoreCase("selecionarPacote")){
                String parcial;
                parcial = request.getParameter("idprojeto");
                request.setAttribute("retornoProjeto", parcial);
                RequestDispatcher rd = 
                request.getRequestDispatcher("selecionarPacote.jsp"); 
                rd.forward(request, response); 
            }
            
            if(controle.equalsIgnoreCase("redirecionarPacote")){
                String parcialProjeto;
                parcialProjeto = request.getParameter("idprojeto");
                request.setAttribute("retornoProjeto", parcialProjeto);
                String parcialPacote;
                parcialPacote = request.getParameter("idpacote");
                request.setAttribute("retornoPacote", parcialPacote);
                RequestDispatcher rd = 
                request.getRequestDispatcher("selecionarTarefa.jsp"); 
                rd.forward(request, response); 
            }
            
            if(controle.equalsIgnoreCase("logar")){
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    String login = request.getParameter("login");
                    String senha = request.getParameter("senha");
                    if(login.equals("")||senha.equals("")){

                     }else
                        response.sendRedirect("selecionarProjeto.jsp");
            }
            
            if(controle.equals("cadastroprojeto")){
                RequestDispatcher rd = 
                request.getRequestDispatcher("CadastroProjeto.jsp"); 
                rd.forward(request, response); 
            }
            
            if(controle.equals("cadastropacote")){
                String parcial;
                parcial = request.getParameter("idprojeto");
                PacoteDAO pacoteDao = new PacoteDAO();
                String sValue = "2009-06-16" ; 
                java.sql.Date dtValue = java.sql.Date.valueOf(sValue); 
                pacoteDao.inserirPacote(request.getParameter("nomepacote"), 0, 0, dtValue, dtValue, Integer.parseInt(parcial) );
                request.setAttribute("retornoProjeto", parcial);
                RequestDispatcher rd = 
                request.getRequestDispatcher("selecionarPacote.jsp"); 
                rd.forward(request, response); 
                
                
            }
            if(controle.equals("cadastrotarefa")){
                String parcialProjeto;
                String parcialPacote;
                parcialProjeto = request.getParameter("idprojeto");
                parcialPacote = request.getParameter("idpacote");
                request.setAttribute("retornoProjeto", parcialProjeto);
                request.setAttribute("retornoPacote", parcialPacote);
                RequestDispatcher rd = 
                request.getRequestDispatcher("CadastroTarefa.jsp"); 
                rd.forward(request, response); 
                
            }    
            if(controle.equals("inserirProjeto")){
                ProjetoDAO projetoDao = new ProjetoDAO();
                String sValue = "2009-06-16" ; 
                java.sql.Date dtValue = java.sql.Date.valueOf(sValue); 
                projetoDao.inserirProjeto(request.getParameter("nomeprojeto"), 0, 0, dtValue, dtValue );
                response.sendRedirect("logado.jsp");
            } 
            
            if(controle.equals("inserirtarefa")){
                TarefaDAO tarefaDao = new TarefaDAO();
                String v1 =request.getParameter("idpacote");
                String v2 =request.getParameter("idprojeto");
                
                int pacoteAtual = Integer.parseInt(v1);
                int projetoAtual = Integer.parseInt(v2);
                
                
                System.out.println(pacoteAtual);
                System.out.println(projetoAtual);
                    String sValue = request.getParameter("datainicial"); 
                    String sValue1 = request.getParameter("datafinal"); 
                System.out.println(sValue);
                System.out.println(sValue1);    
                    String mm = sValue.substring(0,2);
                    String dd = sValue.substring(3,5);
                    String aaaa = sValue.substring(6,10);
                    String formatado = aaaa+"-"+dd+"-"+mm;
                    System.out.println(formatado);
                java.sql.Date dtValue = java.sql.Date.valueOf(formatado);   
                    System.out.println(dtValue);
                    mm = sValue1.substring(0,2);
                    dd = sValue1.substring(3,5);
                    aaaa = sValue1.substring(6,10);
                    formatado = aaaa+"-"+dd+"-"+mm;
                java.sql.Date dtValue1 = java.sql.Date.valueOf(formatado); 
                tarefaDao.inserirTarefa(request.getParameter("nometarefa"), Integer.parseInt(request.getParameter("tempoprevisto")), Integer.parseInt(request.getParameter("temporeal")), dtValue, dtValue1, pacoteAtual);
                
                
                request.setAttribute("retornoPacote", v1);
                request.setAttribute("retornoProjeto", v2);
                
                RequestDispatcher rd = 
                request.getRequestDispatcher("selecionarTarefa.jsp"); 
                rd.forward(request, response); 
                
                
            }    
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
