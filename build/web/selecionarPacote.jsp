<%@page import="Control.PacoteDAO"%>
<%@page import="Model.Pacote"%>
<%@page import="Control.ProjetoDAO"%>
<%@page import="Model.Projeto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Control.TarefaDAO"%>
<%@page import="Model.Tarefa"%>
  
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap-responsive.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="screen">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/cufon-replace.js" type="text/javascript"></script>
<script src="js/Open_Sans_400.font.js" type="text/javascript"></script>
<script src="js/Open_Sans_Light_300.font.js" type="text/javascript"></script> 
<script src="js/Open_Sans_Semibold_600.font.js" type="text/javascript"></script>  
<script type="text/javascript" src="js/tms-0.3.js"></script>
<script type="text/javascript" src="js/tms_presets.js"></script> 
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 
<script src="js/FF-cash.js" type="text/javascript"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selecionar Pacotes</title>
    </head>
    <body>
         <div class="bg">
		<div class="main">
                    <header>
                        
        <div class="row-1">
					<h1>
						
						<strong class="slog">Gerenciador de Projetos do Grupo MOB</strong>
					</h1>
            <%--
					<form id="search-form" action="" method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="search-form">					
								<input type="text" name="search" value="Type Keyword Here" onBlur="if(this.value=='') this.value='Type Keyword Here'" onFocus="if(this.value =='Type Keyword Here' ) this.value=''" />
								<a href="#" onClick="document.getElementById('search-form').submit()">Search</a>									
							</div>
						</fieldset>
					</form>
            --%>
            
            
                         <%
                 String sValue = (String)request.getAttribute("retornoProjeto");
                 int projetoAtual = Integer.parseInt(sValue);
                 ProjetoDAO projetoDao = new ProjetoDAO();
                 Projeto projeto = projetoDao.procurarProjeto(projetoAtual);
                 
            %>
           

            
				</div>
        <div class="row-2">

               
					<nav>
						<ul class="menu">
                                                  <li><a href="selecionarProjeto.jsp">Projetos em Andamento</a></li>
						  <li><a class="active" disabled="" >Pacotes</a></li>
						  <li><a >Tarefas</a></li>
						  <li><a >Nova O.S.</a></li>	
						</ul>
					</nav>
				</div>
                        </header>
                     <section id="content">
				<div class="padding">
					<div class="box-bg margin-bot">
						<div class="wrapper">
                                                    
		
                                                    <p style="width:100%" align="center">Você está no projeto: <strong><%= projeto.getNomeProjeto() %></strong></p>
            <span class="psdg-bold">Pacotes deste projeto</span><br />
            <div class="table table-striped" >
                                                    <table cellspacing="0" style="width:100%"> 
                                                          
                                                                <tr> 
                                                                    <td>Nome do Pacote</td> 
                                                                    <td>Tempo Previsto</td> 
                                                                    <td>Tempo Real</td> 
                                                                    <td>Data Inicial</td> 
                                                                    <td>Data Final</td> 
                                                                </tr> 
                                                   
		
            <%
                    Pacote atual = new Pacote();
                    PacoteDAO pacotes = new PacoteDAO();
                    ArrayList<Pacote> listaPacotes = new ArrayList<Pacote>();
                    listaPacotes = pacotes.listarPacotes(projetoAtual);
                    for(int i=0;i<listaPacotes.size();i++){
                        
                    int segundos = listaPacotes.get(i).getTempoEstimado(); 
                    int segundo = segundos % 60; 
                    int minutos = segundos / 60; 
                    int minuto = minutos % 60; 
                    int hora = minutos / 60; 
                    String hmsTempoprevisto = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
                    
                    segundos = listaPacotes.get(i).getTempoReal(); 
                    segundo = segundos%60;
                    minutos = segundos/60;
                    minuto = minutos%60;
                    hora = minutos/60;
                    String hmsTemporeal = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
            %>
                
                    <tr> 
                                                                    <td><a href="Servlet?idprojeto=<%= projetoAtual %>&idpacote=<%= listaPacotes.get(i).getIdPacote()%>&controle=redirecionarPacote"><%= listaPacotes.get(i).getNomePacote()%></a></td> 
                                                                    <td><%= hmsTempoprevisto %></td> 
                                                                    <td><%= hmsTemporeal%></td> 
                                                                    <td><%= listaPacotes.get(i).getDataInicial() %></td> 
                                                                    <td><%= listaPacotes.get(i).getDataFinal() %> </td> 
                                                                </tr>
                    
                    
                <%    
                    }   
                %>
                
                <tr><td><a href="CadastroPacote.jsp?idprojeto=<%= projeto.getIdProjeto() %>" >Cadastrar Pacote</a></td></tr>
            </table>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <div><br/>
        </div>
        <footer>
				<div class="row-top">
					<div class="row-padding">
						<div class="wrapper">
							<div class="col-1">
								<h4>Localizacao:</h4>
								<dl class="address">
									<dt><span>País:</span>Brasil</dt>
									<dd><span>Cidade:</span>Fortaleza</dd>
									<dd><span>Endereço:</span>Avenida Abolição,4140</dd>
									<dd><span>Email:</span><a href="#">tisuporte-l@mobinteligencia.com.br</a></dd>
								</dl>
							</div>
							<div class="col-2">
								<h4>Follow Us:</h4>
								<ul class="list-services">
									<li class="item-1"><a href="#">Facebook</a></li>
									<li class="item-2"><a href="#">Twitter</a></li>
									<li class="item-3"><a href="#">LinkedIn</a></li>
								</ul>
							</div>
							<div class="col-4">
							</div>
						</div>
					</div>
				</div>
				<div class="row-bot">
					<div class="aligncenter">
						<p class="p0"> Desenvolvido pot Amarildo Pena - TI INTERNA GRUPO MOB| <a rel="nofollow" href="http://www.html5xcss3.com/" target="_blank">html5xcss3.com<a/></p>
						
						<!-- {%FOOTER_LINK} -->
					</div>
				</div>
			</footer>
    </body>
</html>
