<%
	String login = (String)session.getAttribute("admin");
	if (login == null){
%>
	<script>
		alert("Usuário Não Logado");
		location="login.jsp";
	</script>
<%
	}
%>