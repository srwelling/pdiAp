<%@page import="Control.TarefaDAO"%>
<%@page import="Control.PacoteDAO"%>
<%@page import="Control.ProjetoDAO"%>
<%@page import="Model.Tarefa"%>
<%@page import="Model.Projeto"%>
<%@page import="Model.Pacote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><script>function formatar(mascara, documento){
 var i = documento.value.length;
 var saida = mascara.substring(0,1);
 var texto = mascara.substring(i)
 
 if (texto.substring(0,1) != saida){
 documento.value += texto.substring(0,1);
 }    
}
    </script>
<link rel="stylesheet" href="css/bootstrap-responsive.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="screen">

     <script src="lib/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="src/jquery.maskedinput.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
        <link type="text/css" rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/redmond/jquery-ui.css" />

        <script type="text/javascript">
            $(function() {
                $("#date")
                                        .datepicker({ nextText: "", prevText: "", changeMonth: true, changeYear: true })
                                        .mask("99/99/9999");
            });
            $(function() {
                $("#date1")
                                        .datepicker({ nextText: "", prevText: "", changeMonth: true, changeYear: true })
                                        .mask("99/99/9999");
            });
            
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Tarefa</title>
    </head>
    <body>
        <% 
            String v1 = request.getParameter("idprojeto");
            String v2 = request.getParameter("idpacote");
            
            int projetoAtual = Integer.parseInt(v1);
            int pacoteAtual = Integer.parseInt(v2);
            
            Projeto projeto = new Projeto();
            ProjetoDAO projetoDao = new ProjetoDAO();
            projeto = projetoDao.procurarProjeto(projetoAtual);
            
            Pacote pacote = new Pacote();
            PacoteDAO pacoteDao = new PacoteDAO();
            pacote = pacoteDao.procurarPacote(pacoteAtual);
            
            
            Tarefa tarefa = new Tarefa();
            TarefaDAO tarefaDao = new TarefaDAO();
            
            
            %>
            <form method="post" action="Servlet" role="form">
                <div class="form-group">
                    <table style="width:100%">
                <tr>
                    
                    <td><strong>Nome do Projeto:</strong><br/><input type="text" name="nomeprojeto" class="form-control" disabled="" value="<%= projeto.getNomeProjeto() %>" /></td>
                </tr>
                <tr>
                    
                    <td><strong>Nome do Pacote:</strong><br/><input type="text" name="nomepacote" class="form-control" disabled="" value="<%= pacote.getNomePacote() %>" /></td>
                </tr>
                
                <tr>
                    
                    <td><strong>Nome da Tarefa:</strong><br/><input type="text"  class="form-control" name="nometarefa"> </td>
                </tr>
                <tr>
                    
                    <td><strong>Tempo Previsto:</strong><br/><input type="text" id="tempo1" class="form-control" name="tempoprevisto" maxlength="5" OnKeyPress="formatar('##:##', this)"></td>
                </tr>
                <tr>
                    
                    <td><strong>Tempo Real:</strong><br /><input type="text" id="tempo2" class="form-control" name="temporeal" maxlength="9" OnKeyPress="formatar('###:##:##', this)"> </td>
                </tr>
                <tr>
                    <td><strong>Data Início:</strong><br/><input name="datainicial" class="form-control" id="date" value="1231" type="text" tabindex="1" /></td>
                </tr>
                
                <tr>
                    <td><strong>Data de Término:</strong><br/><input type="text" class="form-control" name="datafinal" id="date1" value="1231" tabindex="1"> </td>
                </tr>
                    
                <tr>
                    
                    <td><input type="hidden" name='controle' value="inserirtarefa" </td>
                    <td><input type="hidden" name="idpacote" value="<%= pacoteAtual%>"</td>
                    <td><input type="hidden" name="idprojeto" value="<%= projetoAtual%>"</td>
                    
                </tr>
                
                
            </table>
                    </div>
                    <tr style="width:100%">
                         <button type="submit" class="btn btn-default" value="Cadastrar" style="width:100%">Cadastrar Projeto</button>
                    </tr>
        </form>
    </body>
</html>
