package br.com.fiap.healthtrack.dao;
import java.util.List;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.Alimento;

public interface AlimentoDAO {
	
	void cadastrar(Alimento alimento) throws DBException;
	void atualizar(Alimento alimento) throws DBException;
	void remover (int codigo) throws DBException;
	Alimento buscar(int id);
	List<Alimento> lista ();
	
	

}
