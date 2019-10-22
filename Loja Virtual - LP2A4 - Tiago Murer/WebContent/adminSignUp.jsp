<%@page import="Repositorios.AdministradorRepository, Classes.Administrador" %>
<%
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	Administrador admin = new Administrador(login, senha);
	
	AdministradorRepository.addAdmin(admin);
%>
	<script>
		alert("Cadastro realizado");
		location="login.jsp";
	</script>