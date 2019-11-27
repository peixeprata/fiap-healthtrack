package br.com.fiap.healthtrack.dao;
import java.util.List;
import br.com.fiap.healthtrack.Peso;
import br.com.fiap.healthtrack.exception.DBException;

public interface PesoDAO {
	
	void cadastrar(Peso peso) throws DBException;
	void atualizar(Peso peso) throws DBException;
	void remover (int cdPeso) throws DBException;
	Peso buscar(int id);
	List<Peso> lista (int cdUsuario);

}
