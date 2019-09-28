package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Cliente;
import Classes.Curso;
import Classes.Pagamento;

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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			Cliente cliente = em.find(Cliente.class, cpf);
			
			if (cliente != null) {
				em.getTransaction().begin();
				em.remove(cliente);
				em.getTransaction().commit();
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Excluído!');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Inexistente!');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/exclusao.jsp");
		}
		em.close();
		emf.close();
	}
	
	private void clienteConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			Cliente cliente = em.find(Cliente.class, cpf);

			if (cliente != null) {
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+cliente.toString()+"');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Inexistente!');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/consulta.jsp");
		}
		em.close();
		emf.close();
	}
	
	private void clienteCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		String validadorCPF = request.getParameter("validadorCPF");
		String validadorEmail = request.getParameter("validadorEmail");
		
		if (validadorCPF.equals("true") && validadorEmail.equals("true")) {
			String cpf = request.getParameter("cpf");
			
			Cliente cliente = em.find(Cliente.class, cpf);
			if (cliente == null) {
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				
				Cliente clienteNovo = new Cliente(cpf, nome, email);
				
				em.getTransaction().begin();
				em.persist(clienteNovo);
				em.getTransaction().commit();
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Cadastrado!');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente já existente!');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
			
		} else {
			if (validadorCPF.equals("false") || validadorEmail.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/cadastro.jsp");
		}
		em.close();
		emf.close();
	}
	
	private void clienteAlteracao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String validadorCPF = request.getParameter("validadorCPF");
		String validadorEmail = request.getParameter("validadorEmail");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		if (validadorCPF.equals("true") && validadorEmail.equals("true")) {
			String cpf = request.getParameter("cpf");
			
			Cliente cliente = em.find(Cliente.class, cpf);

			if (cliente != null) {
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				cliente.setEmail(email);
				cliente.setNome(nome);
				em.getTransaction().begin();
				em.merge(cliente);
				em.getTransaction().commit();
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Alterado!');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Inexistente!');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false") || validadorEmail.equals("false"))
				response.sendRedirect("/ProjetoWEB/clientes/alteracao.jsp");
		}
		em.close();
		emf.close();
	}
	
	private void cursoExclusao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		String cursoId = request.getParameter("cursoId");
		Curso curso = em.find(Curso.class, cursoId);
		if (curso != null) {
			em.getTransaction().begin();
			em.remove(curso);
			em.getTransaction().commit();
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Excluído!');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Inexistente!');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		}
		em.close();
		emf.close();
	}
	
	private void cursoConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		String cursoId = request.getParameter("cursoId");
		Curso curso = em.find(Curso.class, cursoId);
		
		if (curso != null) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+curso.toString()+"');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Inexistente!');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		}
		em.close();
		emf.close();
	}
	
	private void cursoCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		String cursoId = request.getParameter("cursoId");
		Curso curso = em.find(Curso.class, cursoId);
		
		if (curso == null) {
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			String site = request.getParameter("site");
			Curso cursoNovo = new Curso(cursoId, nome, valor, site);
			
			em.getTransaction().begin();
			em.persist(cursoNovo);
			em.getTransaction().commit();
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Cadastrado!');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso já existente!');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		}
		em.close();
		emf.close();
	}
	
	private void cursoAlteracao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		String cursoId = request.getParameter("cursoId");
		Curso curso = em.find(Curso.class, cursoId);
		
		if (curso != null) {
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			String site = request.getParameter("site");
	
			curso.setNome(nome);
			curso.setSite(site);
			curso.setValor(valor);
			
			em.getTransaction().begin();
			em.merge(curso);
			em.getTransaction().commit();
			
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Alterado!');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Curso Inexistente!');");
			out.println("location='/ProjetoWEB/cursos/index.jsp';");
			out.println("</script>");
			out.close();
		}
		em.close();
		emf.close();
	}
	
	private void pagamentoExclusao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			String cursoId = request.getParameter("cursoId");			
			
			Pagamento pg = em.find(Pagamento.class, cpf+cursoId);
			if (pg != null) {
				
				em.getTransaction().begin();
				em.remove(pg);
				em.getTransaction().commit();
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Excluído!');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/exclusao.jsp");
		}
		em.close();
		emf.close();
	}
	
	private void pagamentoConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			String cursoId = request.getParameter("cursoId");

			Pagamento pg = em.find(Pagamento.class, cpf+cursoId);
			if (pg != null) {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+pg.toString()+"');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/consulta.jsp");
		}
		em.close();
		emf.close();
	}
	
	private void pagamentoCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			String cursoId = request.getParameter("cursoId");
		
			Pagamento pg = em.find(Pagamento.class, cpf+cursoId);
			if (pg == null) {
				Pagamento pgNovo = new Pagamento(request.getParameter("cpf"), request.getParameter("cursoId"), request.getParameter("data"));
				
				em.getTransaction().begin();
				em.persist(pgNovo);
				em.getTransaction().commit();
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento cadastrado!');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento já existente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/cadastro.jsp");
		}
		em.close();
		emf.close();
	}
	
	private void pagamentoAlteracao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
		String validadorCPF = request.getParameter("validadorCPF");
		
		if (validadorCPF.equals("true")) {
			String cpf = request.getParameter("cpf");
			String cursoId = request.getParameter("cursoId");
			Pagamento pg = em.find(Pagamento.class, cpf+cursoId);
			
			if (pg != null) {
				String data = request.getParameter("data");
				
				pg.setDtInscricao(data);
				
				em.getTransaction().begin();
				em.merge(pg);
				em.getTransaction().commit();
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Alterado!');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente!');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
		} else {
			if (validadorCPF.equals("false"))
				response.sendRedirect("/ProjetoWEB/pagamentos/alteracao.jsp");
		}
		em.close();
		emf.close();
	}
}