package br.com.fiap.healthtrack;
import java.io.Serializable;
import java.sql.Date;


public class RegistroAlimentos extends Alimento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Date dtAlimento;
	
	public RegistroAlimentos () {
		super();
	}
	public RegistroAlimentos (Date dtAlimento) {
		this.dtAlimento = dtAlimento;		
	}

	public Date getDtAlimento() {
		return dtAlimento;
	}

	public void setDtAlimento(Date dtAlimento) {
		this.dtAlimento = dtAlimento;
	}

}
