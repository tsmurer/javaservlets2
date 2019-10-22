<%
	String login = (String)session.getAttribute("admin");
	if (login == null){
%>
	<script>
		alert("Usuário não logou");
		location="/ProjetoWEB/login.jsp";
	</script>
<%
	}
%>