package br.com.fiap.healthtrack;
import java.io.Serializable;
import java.sql.Date;


public class RegistroAtividade extends Atividade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date dtAtividade; 
	
	
	public RegistroAtividade () {
		super();
	}
	public RegistroAtividade (Date dtAtividade) {
		this.dtAtividade = dtAtividade;		
	}


	public Date getDtAtividade() {
		return dtAtividade;
	}


	public void setDtAtividade(Date dtAtividade) {
		this.dtAtividade = dtAtividade;
	}

}
