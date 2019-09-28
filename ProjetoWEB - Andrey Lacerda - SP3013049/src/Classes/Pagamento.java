package Classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class Pagamento implements Serializable{
	
	@Id
	private String pgId;
	private String cpf;
	private String curso;
	private String dtInscricao;
	
	public Pagamento() {
		
	}
	
	public Pagamento(String cpf, String curso, String dtInscricao) {
		this.pgId = cpf+curso;
		this.cpf = cpf;
		this.curso = curso;
		this.dtInscricao = dtInscricao;
	}

	@Override
	public String toString() {
		return "Pagamento [cpf=" + cpf + ", curso=" + curso + ", dtInscricao=" + dtInscricao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
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

	public String getcpf() {
		return cpf;
	}

	public void setcpf(String cpf) {
		cpf = cpf;
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
