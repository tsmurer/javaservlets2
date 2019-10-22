<%@ page import="Repositorios.AdministradorRepository, Classes.Administrador" %>
<%
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Administrador adm = AdministradorRepository.getAdmLogin(login, senha);
		
		if (adm == null){
%>
			<script>
				alert("Login falhou");
				location="login.jsp";
			</script>
<%
		} else{
			session.setAttribute("admin", login);
			response.sendRedirect("index.jsp");
		}		
%>