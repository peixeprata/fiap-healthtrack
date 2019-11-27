package br.com.fiap.healthtrack.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.healthtrack.Alimento;
import br.com.fiap.healthtrack.dao.AlimentoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OracleAlimentoDAO  implements AlimentoDAO {
	private Connection conexao;

	@Override
	public void cadastrar(Alimento alimento) throws DBException {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_ALIM (ID_ALIMENTO, VL_CALORIA, DS_ALIMENTO) VALUES (SQ_T_HT_ALIM.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, alimento.getVlCaloria());
			stmt.setString(2, alimento.getDsAlimento());
			
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
	public void atualizar(Alimento alimento) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_ALIM SET VL_CALORIA = ?, DS_ALIMENTO = ? WHERE ID_ALIMENTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, alimento.getVlCaloria());
			stmt.setString(2, alimento.getDsAlimento());
			
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
			String sql = "DELETE FROM T_HT_ALIM WHERE ID_ALIMENTO = ?";
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
	public Alimento buscar(int id) {
		Alimento alimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_ALIM WHERE ID_ALIMENTO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int codigo = rs.getInt("ID_ALIMENTO");
				String nome = rs.getString("DS_ALIMENTO");
				Double caloria = rs.getDouble("VL_CALORIA");
				
				alimento = new Alimento(codigo, nome, caloria);	
				
			 
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
		return alimento;
	}

	@Override
	public List<Alimento> lista() {
		List<Alimento> lista = new ArrayList<Alimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_ALIM");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("ID_ALIMENTO");
				String nome = rs.getString("DS_ALIMENTO");
				Double caloria = rs.getDouble("VL_CALORIA");
				
				Alimento alimento = new Alimento(codigo, nome, caloria);
				lista.add(alimento);
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
