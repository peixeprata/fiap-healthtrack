package br.com.fiap.healthtrack.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.healthtrack.Atividade;
import br.com.fiap.healthtrack.dao.AtividadeDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleAtividadeDAO implements AtividadeDAO {
	private Connection conexao;

	@Override
	public void cadastrar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_ATIV (CD_ATIVIDADE, VL_CALORIAMINUTO, DS_ATIVIDADE) VALUES (SQ_T_HT_ATIV.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, atividade.getVlCaloriaMinuto());
			stmt.setString(2, atividade.getDsAtividade());
			
			stmt.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public void atualizar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_ATIV SET VL_CALORIAMINUTO = ?, DS_ATIVIDADE = ? WHERE CD_ATIVIDADE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, atividade.getVlCaloriaMinuto());
			stmt.setString(2, atividade.getDsAtividade());
			
			stmt.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_HT_ATIV WHERE CD_ATIVIDADE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			
			stmt.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Atividade buscar(int id) {
		Atividade atividade = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_ATIV WHERE CD_ATIVIDADE = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int codigo = rs.getInt("CD_ATIVIDADE");
				String nome = rs.getString("DS_ATIVIDADE");
				Double caloria = rs.getDouble("VL_CALORIAMINUTO");
				
				atividade = new Atividade(codigo, nome, caloria);	
				
			 
			} 
			
		}catch (SQLException e) {
				e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return atividade;
	}


	@Override
	public List<Atividade> lista() {
		List<Atividade> lista = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_ATIV");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("CD_ATIVIDADE");
				String nome = rs.getString("DS_ATIVIDADE");
				Double caloria = rs.getDouble("VL_CALORIAMINUTO");
				
				Atividade atividade = new Atividade(codigo, nome, caloria);
				lista.add(atividade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
				
	}

}

	

