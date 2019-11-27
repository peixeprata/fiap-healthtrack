package br.com.fiap.healthtrack.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.Peso;
import br.com.fiap.healthtrack.Usuario;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class PesoDAOTeste {
	
public static void main (String[] args) {
	PesoDAO dao = DAOFactory.getPesoDAO();
	
	//Listar peso
	List<Peso> listaPeso = new ArrayList <Peso>();
	listaPeso = dao.lista(1);
	for (Peso item : listaPeso) {
		System.out.println("Código do Usuário: " +item.getCdUsuario());
		System.out.println("Peso: " + item.getVlPeso());
		System.out.println("-------------------------------------");
		System.out.println("");
	}
	
	try {
		Peso peso2 = new Peso(1,1,80, Calendar.getInstance());
		dao.atualizar(peso2);
		System.out.println("Código do Usuário: " + peso2.getCdUsuario());
		System.out.println("Peso: " + peso2.getVlPeso());
	} catch (DBException e) {
		e.printStackTrace();
	}
	
	//Cadastrar peso
	Peso pesoTeste = new Peso(1, 1, 56, Calendar.getInstance());
	try {
		dao.cadastrar(pesoTeste);
		System.out.println("Peso cadastrado.");
	} catch (DBException e) {
		e.printStackTrace();
	}
	
	Peso peso = new Peso();
	peso = dao.buscar(1);
	peso.setVlPeso(58);
	try {
		dao.atualizar(peso);
		System.out.println("Peso atualizado");
	} catch (DBException e) {
		e.printStackTrace();
	}
	

}
}