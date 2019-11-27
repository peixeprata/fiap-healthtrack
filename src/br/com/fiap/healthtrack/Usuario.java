package br.com.fiap.healthtrack;
import java.io.Serializable;
import java.sql.Date;


public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cdUsuario;
	private String dsEmail;
	private String nmUsuario;
	private String dsSenha;
	private Date dtNascimento;
	private String dsSexo;
	private double vlAltura;
	
	public Usuario() {
		super();	
	}
	public Usuario (String dsEmail, 
			String nmUsuario, String dsSenha, Date dtNascimento, String dsSexo, double vlAltura) {
		super();
		this.dsEmail = dsEmail;
		this.nmUsuario = nmUsuario;
		this.dsSenha = dsSenha;
		this.dtNascimento = dtNascimento;
		this.dsSexo = dsSexo;
		this.vlAltura = vlAltura;
		
	}
	public Usuario (int cdUsuario, String dsEmail, 
			String nmUsuario, String dsSenha, Date dtNascimento, String dsSexo, double vlAltura) {
		super();
		this.cdUsuario = cdUsuario;
		this.dsEmail = dsEmail;
		this.nmUsuario = nmUsuario;
		this.dsSenha = dsSenha;
		this.dtNascimento = dtNascimento;
		this.dsSexo = dsSexo;
		this.vlAltura = vlAltura;
		
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getDsSexo() {
		return dsSexo;
	}
	public void setDsSexo(String dsSexo) {
		this.dsSexo = dsSexo;
	}
	public double getVlAltura() {
		return vlAltura;
	}
	public void setVlAltura(double vlAltura) {
		this.vlAltura = vlAltura;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}	
}