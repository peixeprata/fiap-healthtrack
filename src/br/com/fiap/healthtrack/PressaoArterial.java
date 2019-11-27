package br.com.fiap.healthtrack;
import java.io.Serializable;
import java.sql.Date;


public class PressaoArterial extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cdPressao;
	private int vlSistolica;
	private int vlDiastolica;
	private Date dtPressao;
	
	public PressaoArterial () {
		super();
	}
	public PressaoArterial (int cdPressao, int vlSistolica, int vlDiastolica, Date dtPressao) {
		this.cdPressao = cdPressao;
		this.vlDiastolica = vlDiastolica;
		this.dtPressao = dtPressao;
		this.vlSistolica = vlSistolica;
	}
	
	public int getCdPressao() {
		return cdPressao;
	}
	public void setCdPressao(int cdPressao) {
		this.cdPressao = cdPressao;
	}
	public int getVlSistolica() {
		return vlSistolica;
	}
	public void setVlSistolica(int vlSistolica) {
		this.vlSistolica = vlSistolica;
	}
	public int getVlDiastolica() {
		return vlDiastolica;
	}
	public void setVlDiastolica(int vlDiastolica) {
		this.vlDiastolica = vlDiastolica;
	}
	public Date getDtPressao() {
		return dtPressao;
	}
	public void setDtPressao(Date dtPressao) {
		this.dtPressao = dtPressao;
	}

	
	

}

