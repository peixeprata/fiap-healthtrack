package br.com.fiap.healthtrack.factory;
import br.com.fiap.healthtrack.dao.AlimentoDAO;
import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.dao.impl.OracleAlimentoDAO;
import br.com.fiap.healthtrack.dao.impl.OracleAtividadeDAO;
import br.com.fiap.healthtrack.dao.impl.OraclePesoDAO;
public class DAOFactory {
	
	public static AlimentoDAO getAlimentoDAO() {
		return new OracleAlimentoDAO();
	}
	
	public static AtividadeDAO getAtividadeDAO () {
		return new OracleAtividadeDAO();
	}
	
	public static PesoDAO getPesoDAO () {
		return new OraclePesoDAO();
	}
}
