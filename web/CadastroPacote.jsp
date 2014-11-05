<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Projeto</title>
    </head>
    <body>
        <form method="post" action="Servlet">
            <table>
                <tr>
                    <td><input type="text" name="nomepacote" value="Nome do Pacote"> </td>  
                    <td><input type="submit" value="Cadastrar"> </td>
                    <input type="hidden" name="idprojeto" value="<%= request.getParameter("idprojeto")%>" />
                    <input type="hidden" name="controle" value="cadastropacote" />
                </tr>
            </table>
        </form>
    </body>
</html>
