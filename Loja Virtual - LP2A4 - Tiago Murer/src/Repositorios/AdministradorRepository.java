package Repositorios;

import java.util.HashSet;
import java.util.Set;

import Classes.Administrador;


public class AdministradorRepository {
	
	private static Set<Administrador> admins = new HashSet<Administrador>();

	public static Set<Administrador> getAdmins() {
		return admins;
	}
	
	public static void addAdmin(Administrador admin) {
		admins.add(admin);
	}
	
	public static Administrador getAdm(String login) {
		for (Administrador admin : admins) {
			if (admin.getLogin().equals(login)) {
				return admin;
			}
		}
		return null;
	}
	
	public static Administrador getAdmLogin(String login, String senha) {
		for (Administrador admin : admins) {
			if (admin.getLogin().equals(login) && admin.getSenha().equals(senha)) {
				return admin;
			}
		}
		return null;
	}
	
}