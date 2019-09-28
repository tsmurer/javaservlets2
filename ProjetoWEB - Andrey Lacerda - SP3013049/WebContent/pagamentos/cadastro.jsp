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
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <h3 class="tt_menu">&gt;&gt; PAGAMENTOS - CADASTRAR UM NOVO PAGAMENTO &lt;&lt;</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" id="form" name="form" method="post" action="../Controlador">
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputCPF" class="control-label">Informar o CPF:</label>
                </div>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="inputCPF" placeholder="CPF" name="cpf">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputCURSO" class="control-label">Informar o CURSO:</label>
                </div>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="inputCURSO" placeholder="CURSO" name="cursoId">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputDATA" class="control-label">Informar a DATA DE INSCRIÇÃO:</label>
                </div>
                <div class="col-sm-9">
                  <input type="date" class="form-control" id="inputDATA" title="Preencha o campo Nome" name="data">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                  <input type="hidden" name="formulario" value="pagamento cadastro">
                	<input type="hidden" name="validadorCPF" value="">
                  <button type="button" class="btn btn-danger" onclick="validacaoCPF(document.form.cpf.value, document.form, document.form.validadorCPF)">Cadastrar</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
            <a class="btn btn-default" href="/ProjetoWEB/pagamentos/index.jsp">Voltar</a>
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