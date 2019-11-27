package br.com.fiap.healthtrack.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.healthtrack.Peso;
import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.exception.DBException;
import br.com.fiap.healthtrack.singleton.ConnectionManager;

public class OraclePesoDAO implements PesoDAO {
	private Connection conexao;
	
	@Override
	public void cadastrar(Peso peso) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_HT_PESO (CD_USUARIO, CD_PESO, VL_PESO, DT_PESO) VALUES (?, ?, ?, ?)";
					
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getCdUsuario());
			stmt.setInt(2, peso.getVlPeso());
			java.sql.Date data = new java.sql.Date(peso.getDtPeso().getTimeInMillis());
			stmt.setDate(3, data);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException ("Erro ao cadastrar");
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
	public void atualizar(Peso peso) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_HT_PESO SET VL_PESO = ?, DT_PESO = ? WHERE CD_PESO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getVlPeso());
			java.sql.Date data = new java.sql.Date(peso.getDtPeso().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setInt(3, peso.getCdPeso());
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
	public void remover(int cdPeso) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_HT_PESO WHERE CD_PESO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdPeso);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
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
	public Peso buscar(int id) {
		Peso peso = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_HT_PESO WHERE CD_PESO =?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int cdPeso = rs.getInt("CD_PESO");
				int cdUsuario = rs.getInt("CD_USUARIO");
				int vlPeso = rs.getInt("VL_PESO");
				java.sql.Date data = rs.getDate("DT_PESO");
				Calendar dtPeso = Calendar.getInstance();
				dtPeso.setTimeInMillis(data.getTime());
				
				peso = new Peso(cdPeso, cdUsuario, vlPeso, dtPeso);
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
		return peso;
	}


	@Override
	public List<Peso> lista(int codigoUsuario) {
		List<Peso> lista = new ArrayList<Peso>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_HT_PESO WHERE CD_USUARIO = ? ordey by DT_PESO DESC";
			stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1,  codigoUsuario);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int cdPeso = rs.getInt("CD_PESO");
				int cdUsuario = rs.getInt("CD_USUARIO");
				int vlPeso = rs.getInt("VL_PESO");
				java.sql.Date data = rs.getDate("DT_PESO");
				Calendar dtPeso = Calendar.getInstance();
				dtPeso.setTimeInMillis(data.getTime());
				
				Peso peso = new Peso(cdPeso, cdUsuario, vlPeso, dtPeso);
				lista.add(peso);
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

