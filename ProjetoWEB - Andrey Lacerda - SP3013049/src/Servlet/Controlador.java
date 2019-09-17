package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Cliente;
import Classes.Curso;
import Classes.Pagamento;
import Repositorios.ClienteRepository;
import Repositorios.CursoRepository;
import Repositorios.PagamentoRepository;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controlador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String form = request.getParameter("formulario");
		
		if (form.contains("cliente")) {
			if (form.equals("cliente exclusao"))
					clienteExclusao(request, response);
			else
				if (form.equals("cliente cadastro"))
					clienteCadastro(request, response);
				else
					if (form.equals("cliente alteracao"))
						clienteAlteracao(request, response);
					else
						if (form.equals("cliente consulta"))
								clienteConsulta(request, response);
						else
							if (form.equals("cliente total"))
								clienteConsultaTotal(request, response);
		} else {
			if (form.contains("curso")) {
				if (form.equals("curso exclusao"))
					cursoExclusao(request, response);
				else
					if (form.equals("curso cadastro"))
						cursoCadastro(request, response);
					else
						if (form.equals("curso alteracao"))
							cursoAlteracao(request, response);
						else
							if (form.equals("curso consulta"))
								cursoConsulta(request, response);
							else
								if (form.equals("curso total"))
									cursoConsultaTotal(request, response);
			} else {
				if (form.contains("pagamento")) {
					if (form.equals("pagamento exclusao"))
						pagamentoExclusao(request, response);
					else
						if (form.equals("pagamento cadastro"))
							pagamentoCadastro(request, response);
						else
							if (form.equals("pagamento alteracao"))
								pagamentoAlteracao(request, response);
							else
								if (form.equals("pagamento consulta"))
									pagamentoConsulta(request, response);
								else
									if (form.equals("pagamento total"))
										pagamentoConsultaTotal(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void clienteExclusao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			Cliente cliente = ClienteRepository.getCliente(cpf);
			if (cliente != null) {
				ClienteRepository.deleteCliente(cpf);
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Excluído!');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Inexistente!');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			}
			
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/exclusao.html");
		}
	}
	
	private void clienteConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			Cliente cliente = ClienteRepository.getCliente(cpf);
			if (cliente != null) {
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+cliente.toString()+"');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Inexistente!');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/consulta.html");
		}
	}
	
	private void clienteCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		String validadorEmail = request.getParameter("validadorEmail");
		
		if (validadorCPF.equals("true") && validadorEmail.equals("true")) {
			String cpf = request.getParameter("cpf");
			Cliente cliente = ClienteRepository.getCliente(cpf);
			if (cliente == null) {
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				
				Cliente clienteNovo = new Cliente(cpf, nome, email);
				ClienteRepository.addCliente(clienteNovo);
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Cadastrado!');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente já existente!');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			}
			
			
		} else {
			if (validadorCPF.equals("false") || validadorEmail.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/cadastro.html");
		}
	}
	
	private void clienteAlteracao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		String validadorEmail = request.getParameter("validadorEmail");
		
		if (validadorCPF.equals("true") && validadorEmail.equals("true")) {
			String cpf = request.getParameter("cpf");
			
			Cliente cliente = ClienteRepository.getCliente(cpf);

			if (cliente != null) {
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				ClienteRepository.updateCliente(cpf, nome, email);
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Alterado!');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Inexistente!');");
				out.println("location='/ProjetoWEB/clientes/index.html';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false") || validadorEmail.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/alteracao.html");
		}
	}
	
	private void clienteConsultaTotal(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		if (ClienteRepository.getClientes().size() == 0) {
			out.println("Nenhum cliente cadastrado");
		} else {
			for (Cliente cliente : ClienteRepository.getClientes())
				out.println(cliente.toString());
		}
		out.close();
	}
	
	private void cursoExclusao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			String cursoId = request.getParameter("cursoId");
			Curso curso = CursoRepository.getCurso(cursoId);
			if (curso != null) {
				CursoRepository.deleteCurso(cursoId);
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Curso Excluído!');");
				out.println("location='/ProjetoWEB/cursos/index.html';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Curso Inexistente!');");
				out.println("location='/ProjetoWEB/cursos/index.html';");
				out.println("</script>");
				out.close();
			}
	}
	
	private void cursoConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cursoId = request.getParameter("cursoId");
		
		Curso curso = CursoRepository.getCurso(cursoId);
		if (curso != null) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+curso.toString()+"');");
			out.println("location='/ProjetoWEB/cursos/index.html';");
			out.println("</script>");
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Inexistente!');");
			out.println("location='/ProjetoWEB/cursos/index.html';");
			out.println("</script>");
			out.close();
		}
	}
	
	private void cursoCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cursoId = request.getParameter("cursoId");
		
		Curso curso = CursoRepository.getCurso(cursoId);
		if (curso == null) {
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			String site = request.getParameter("site");
			Curso cursoNovo = new Curso(cursoId, nome, valor, site);
			CursoRepository.addCurso(cursoNovo);
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Cadastrado!');");
			out.println("location='/ProjetoWEB/cursos/index.html';");
			out.println("</script>");
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso já existente!');");
			out.println("location='/ProjetoWEB/cursos/index.html';");
			out.println("</script>");
			out.close();
		}
	}
	
	private void cursoAlteracao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cursoId = request.getParameter("cursoId");
		
		Curso curso = CursoRepository.getCurso(cursoId);
		if (curso != null) {
			curso.setCurso(cursoId);
			curso.setNome(request.getParameter("nome"));
			curso.setValor(request.getParameter("valor"));
			curso.setSite(request.getParameter("site"));
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Alterado!');");
			out.println("location='/ProjetoWEB/cursos/index.html';");
			out.println("</script>");
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Inexistente!');");
			out.println("location='/ProjetoWEB/cursos/index.html';");
			out.println("</script>");
			out.close();
		}
	}
	
	private void cursoConsultaTotal(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		if (CursoRepository.getCursos().size() == 0) {
			out.println("Nenhum curso cadastrado");
		} else {
			for (Curso curso : CursoRepository.getCursos())
				out.println(curso.toString());
		}
		out.close();
	}
	
	private void pagamentoExclusao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			Pagamento pg = PagamentoRepository.getPagamentos(request.getParameter("cpf"), request.getParameter("cursoId"));
			if (pg != null) {
				PagamentoRepository.deletePagamento(request.getParameter("cpf"), request.getParameter("cursoId"));
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Excluído!');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			}
			
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/exclusao.html");
		}
	}
	
	private void pagamentoConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			Pagamento pg = PagamentoRepository.getPagamentos(request.getParameter("cpf"), request.getParameter("cursoId"));
			if (pg != null) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+pg.toString()+"');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/consulta.html");
		}
	}
	
	private void pagamentoCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			Pagamento pg = PagamentoRepository.getPagamentos(request.getParameter("cpf"), request.getParameter("cursoId"));
			if (pg == null) {
				Pagamento pgNovo = new Pagamento(request.getParameter("cpf"), request.getParameter("cursoId"), request.getParameter("data"));
				PagamentoRepository.addPagamento(pgNovo);
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento cadastrado!');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento já existente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/cadastro.html");
		}
	}
	
	private void pagamentoAlteracao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			Pagamento pg = PagamentoRepository.getPagamentos(request.getParameter("cpf"), request.getParameter("cursoId"));
			if (pg != null) {
				pg.setCPF(request.getParameter("cpf"));
				pg.setCurso(request.getParameter("cursoId"));
				pg.setDtInscricao(request.getParameter("data"));
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Alterado!');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.html';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/alteracao.html");
		}
	}
	
	private void pagamentoConsultaTotal(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		if (PagamentoRepository.getPagamentos().size() == 0) {
			out.println("Nenhum pagamentos cadastrado");
		} else {
			for (Pagamento pg : PagamentoRepository.getPagamentos())
				out.println(pg.toString());
		}
		out.close();
	}
}