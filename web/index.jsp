<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>MOB INTELIGENCIA PDI</title>
<style type="text/css">  
  @import url("css/login-box.css");  
</style>  
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>


<div style="padding: 100px 0 0 250px;">


<div id="login-box">

               <H2>Login</H2>

<br />
<br />
            <form action="Servlet" method="post">
            <div id="login-box-name" style="margin-top:20px;">login:</div><div id="login-box-field" style="margin-top:20px;"><input name="login" class="form-login" title="Login" value="" size="30" maxlength="2048" /></div>
            <div id="login-box-name">senha:</div><div id="login-box-field"><input name="senha" type="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
            <div align="center"><input type="submit" value="Logar"></input></div>
            <input type="hidden" name="controle" value="logar"></input> 

<%--<a type="submit"><img src="images/login-btn.png" width="103" height="42" style="margin-left:90px;"  /></a>--%>
</form>
<br />
<a href="#" style="margin-left:30px;">Esqueceu a senha?</a></span>
<br />
<br />
</div>
</div>
</body>
</html>
