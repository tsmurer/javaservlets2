<%@ page import="Repositorios.AdministradorRepository, Classes.Administrador" %>
<%
	if (AdministradorRepository.getAdmins().size() > 0){
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Administrador adm = AdministradorRepository.getAdmLogin(login, senha);
		
		if (adm == null){
%>
			<script>
				alert("Administrador Não Encontrado");
				location="login.jsp";
			</script>
<%
			response.sendRedirect("cadastroAdmin.jsp");
		} else{
			session.setAttribute("admin", login);
			response.sendRedirect("index.jsp");
		}
	} else{
		
%>
		<script>
			alert("Cadastre o Administrador!");
			location="cadastroAdmin.jsp";
		</script>
<%
	}
%>