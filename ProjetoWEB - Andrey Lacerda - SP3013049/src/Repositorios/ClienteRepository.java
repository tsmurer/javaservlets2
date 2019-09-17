package Repositorios;

import java.util.HashSet;
import java.util.Set;

import Classes.Cliente;

public class ClienteRepository {
	
	private static Set<Cliente> clientes = new HashSet<Cliente>();

	public static Set<Cliente> getClientes() {
		return clientes;
	}
	
	public static void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public static void deleteCliente(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				clientes.remove(cliente);
				break;
			}
		}
	}
	
	public static boolean updateCliente(String cpf, String nome, String email) {
		boolean flag = false;
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				cliente.setCpf(cpf);
				cliente.setEmail(email);
				cliente.setNome(nome);
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static Cliente getCliente(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}
	
}