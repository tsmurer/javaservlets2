package Repositorios;

import java.util.HashSet;
import java.util.Set;

import Classes.Pagamento;

public class PagamentoRepository {

	private static Set<Pagamento> pagamentos = new HashSet<Pagamento>();

	public static Set<Pagamento> getPagamentos() {
		return pagamentos;
	}
	
	public static void addPagamento(Pagamento pg) {
		pagamentos.add(pg);
	}
	
	public static void deletePagamento(String cpf, String curso) {
		for (Pagamento pg : pagamentos) {
			if (pg.getCPF().equals(cpf) && pg.getCurso().equals(curso)) {
				pagamentos.remove(pg);
				break;
			}
		}
	}
	
	public static boolean updatePagamento(String cpf, String curso, String dt) {
		boolean flag = false;
		for (Pagamento pg : pagamentos) {
			if (pg.getCPF().equals(cpf) && pg.getCurso().equals(curso)) {
				pg.setCPF(cpf);
				pg.setCurso(curso);
				pg.setDtInscricao(dt);
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static Pagamento getPagamentos(String cpf, String curso) {
		for (Pagamento pg : pagamentos) {
			if (pg.getCPF().equals(cpf) && pg.getCurso().equals(curso)) {
				return pg;
			}
		}
		return null;
	}
}
