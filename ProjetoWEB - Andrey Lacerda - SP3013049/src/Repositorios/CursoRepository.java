package Repositorios;

import java.util.HashSet;
import java.util.Set;

import Classes.Curso;

public class CursoRepository {
	
	private static Set<Curso> cursos = new HashSet<Curso>();

	public static Set<Curso> getCursos() {
		return cursos;
	}
	
	public static void addCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public static void deleteCurso(String cursoId) {
		for (Curso curso : cursos) {
			if (curso.getCurso().equals(cursoId)) {
				cursos.remove(curso);
				break;
			}
		}
	}
	
	public static boolean updateCurso(String cursoId, String nome, String valor, String site) {
		boolean flag = false;
		for (Curso curso : cursos) {
			if (curso.getCurso().equals(cursoId)) {
				curso.setCurso(cursoId);
				curso.setNome(nome);
				curso.setValor(valor);
				curso.setSite(site);
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static Curso getCurso(String cursoId) {
		for (Curso curso : cursos) {
			if (curso.getCurso().equals(cursoId)) {
				return curso;
			}
		}
		return null;
	}
}
