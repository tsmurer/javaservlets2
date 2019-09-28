<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/js/bootstrap.min.js"></script>
    <link href="../lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/padrao.css" rel="stylesheet" type="text/css">
    <script src="../lib/js/validadores.js"></script>
  </head><body>
  <%@ include file="../topo.jsp" %>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-12 text-center" style="margin-top: 50px !important">
	    <h1>CLIENTE - CONSULTA TOTAL</h1>
	    <div class="section">
      		<div class="container">
	        	<div class="row">
	        		<div class="col-md-12 text-center corrigir">
	        			<%@ page import = "javax.persistence.EntityManager, 
	        			javax.persistence.EntityManagerFactory,javax.persistence.Persistence, 
	        			javax.persistence.TypedQuery, 
	        			Classes.Cliente, 
	        			java.util.List" %>
	            		<%
	            			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
	            			EntityManager em = emf.createEntityManager();
	            			TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class); 
	            			List<Cliente> clientes = query.getResultList();
	            			
	            			if (clientes.size() == 0){
	            		%>	
	            			<p>Não Existem Clientes Cadastrados!</p>
	            			<br>
	            		<%
	            		
	            			} else{
	            				for (Cliente cliente : clientes){
	            		%>	
	            					<p style="color: white; "><%=cliente.toString()%></p>
	            					<br>
	            		<%
	            				}
	            			}
	            		%>
	            		<br>
		        	</div>
	          		<div class="col-md-12 text-center corrigir">
	            		<a class="btn btn-default" href="/ProjetoWEB/clientes/index.jsp">Voltar</a>
		        	</div>
		        </div>
		    </div>
	    </div>
    </div>
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">Andrey Camargo Lacerda - SP3013049</div>
          </div>
        </div>
      </div>
    </footer>
    
</body></html>