package br.com.fiap.healthtrack;
import java.io.Serializable;
import java.util.Calendar;
public class Peso extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cdPeso;
	private int cdUsuario;
	private int vlPeso;
	private Calendar dtPeso;
	
	public Peso() {
		super ();	
	}
	
	public Peso (int cdPeso, int cdUsuario, int vlPeso, Calendar dtPeso) {
		super();
		this.cdPeso = cdPeso;
		this.cdUsuario = cdUsuario;
		this.vlPeso = vlPeso;
		this.dtPeso = dtPeso;
		
	}
	public Peso (int cdUsuario, int vlPeso, Calendar dtPeso) {
		super();
		this.cdUsuario = cdUsuario;
		this.vlPeso = vlPeso;
		this.dtPeso = dtPeso;
		
	}

	
	public int getCdPeso() {
		return cdPeso;
	}
	public void setCdPeso(int cdPeso) {
		this.cdPeso = cdPeso;
	}
	public int getVlPeso() {
		return vlPeso;
	}
	public void setVlPeso(int vlPeso) {
		this.vlPeso = vlPeso;
	}
	public Calendar getDtPeso() {
		return dtPeso;
	}
	public void setDtPeso(Calendar dtPeso) {
		this.dtPeso = dtPeso;
	}
	public int getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

		
}
