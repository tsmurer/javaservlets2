<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/js/bootstrap.min.js"></script>
    <link href="lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="lib/css/padrao.css" rel="stylesheet" type="text/css">
    <script src="lib/js/callAutenticacao.js"></script>
  </head><body>
  <%@ page import="Repositorios.AdministradorRepository, Classes.Administrador" %>
  <% if (AdministradorRepository.getAdmins().size() == 0){
	%>
		<script>
			alert("Cadastre o Administrador!");
			location="cadastroAdministrador.jsp";
		</script>
	<%
		} else{
	%>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; Login - Administrador &lt;&lt;</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" id="form" name="form" method="post" action="autenticacao.jsp">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Login:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="login" placeholder="Login" name="login" required="true">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputNome" class="control-label">Senha:</label>
                </div>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="senha" placeholder="Senha" name="senha" required="true">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-danger">Entrar</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;"></div>
          </div>
        </div>
      </div>
    </footer>
    <%
	}
	%>
</body></html>