package br.com.fiap.healthtrack;
import java.io.Serializable;

public class Atividade extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cdAtividade;
	private String dsAtividade;
	private double vlCaloriaMinuto;
	
	public Atividade () {

	}
	public Atividade (int cdAtividade, String dsAtividade, double vlCaloriaMinuto) {
		this.cdAtividade = cdAtividade;
		this.dsAtividade = dsAtividade;
		this.vlCaloriaMinuto = vlCaloriaMinuto;
	}

	
	public int getCdAtividade() {
		return cdAtividade;
	}
	public void setCdAtividade(int cdAtividade) {
		this.cdAtividade = cdAtividade;
	}
	public String getDsAtividade() {
		return dsAtividade;
	}
	public void setDsAtividade(String dsAtividade) {
		this.dsAtividade = dsAtividade;
	}
	public double getVlCaloriaMinuto() {
		return vlCaloriaMinuto;
	}
	public void setVlCaloriaMinuto(double vlCaloriaMinuto) {
		this.vlCaloriaMinuto = vlCaloriaMinuto;
	}

}
