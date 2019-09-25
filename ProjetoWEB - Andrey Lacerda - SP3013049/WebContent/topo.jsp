<%
	String login = (String)session.getAttribute("admin");
	if (login == null){
%>
	<script>
		alert("Usuário Não Logado");
		location="/ProjetoWEB/login.jsp";
	</script>
<%
	}
%>