package Classes;

public class Pagamento {
	private String CPF;
	private String curso;
	private String dtInscricao;
	
	public Pagamento(String cpf, String curso, String dtInscricao) {
		super();
		this.CPF = cpf;
		this.curso = curso;
		this.dtInscricao = dtInscricao;
	}

	@Override
	public String toString() {
		return "Pagamento [CPF=" + CPF + ", curso=" + curso + ", dtInscricao=" + dtInscricao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((dtInscricao == null) ? 0 : dtInscricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (dtInscricao == null) {
			if (other.dtInscricao != null)
				return false;
		} else if (!dtInscricao.equals(other.dtInscricao))
			return false;
		return true;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDtInscricao() {
		return dtInscricao;
	}

	public void setDtInscricao(String dtInscricao) {
		this.dtInscricao = dtInscricao;
	}
		
}
