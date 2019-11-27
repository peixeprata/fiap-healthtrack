package br.com.fiap.healthtrack.teste;
import java.util.List;
import br.com.fiap.healthtrack.Alimento;
import br.com.fiap.healthtrack.dao.AlimentoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.factory.DAOFactory;

public class AlimentoDAOTeste {
	public static void main (String[] args) {
		AlimentoDAO dao = DAOFactory.getAlimentoDAO();
		
		Alimento alimento = new Alimento(0, "Alcatra Assada", 301);
		try {
			dao.cadastrar(alimento);
			System.out.println("Alimento cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		alimento = dao.buscar(1);
		alimento.setDsAlimento("Alcatra cozida");
		alimento.setVlCaloria(301);
		
		try {
			dao.atualizar(alimento);
			System.out.println("Alimento atualizado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		List<Alimento> lista = dao.lista();
		for (Alimento item : lista) {
			System.out.println(item.getDsAlimento() + " " + item.getVlCaloria());
			
		}
		try {
			dao.remover(1);
			System.out.println("Alimento removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
