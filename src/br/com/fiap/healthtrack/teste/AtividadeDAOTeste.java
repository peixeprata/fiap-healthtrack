package br.com.fiap.healthtrack.teste;

import java.util.List;

import br.com.fiap.healthtrack.Atividade;
import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class AtividadeDAOTeste {
	public static void main (String[] args) {
	AtividadeDAO dao = DAOFactory.getAtividadeDAO();
	
	Atividade atividade = new Atividade(0, "Hatha Yoga", 3.05);
	try {
		dao.cadastrar(atividade);
		System.out.println("Atividade cadastrada.");
	} catch (DBException e) {
		e.printStackTrace();
	}
	atividade = dao.buscar(1);
	atividade.setDsAtividade("Hatha Yoga");
	atividade.setVlCaloriaMinuto(3.06);
	
	try {
		dao.atualizar(atividade);
		System.out.println("Atividade atualizada.");
	} catch (DBException e) {
		e.printStackTrace();
	}
	
	List<Atividade> lista = dao.lista();
	for (Atividade item : lista) {
		System.out.println(item.getDsAtividade() + " " + item.getVlCaloriaMinuto());
		
	}
	try {
		dao.remover(1);
		System.out.println("Atividade removida.");
	} catch (DBException e) {
		e.printStackTrace();
	}
}
}
