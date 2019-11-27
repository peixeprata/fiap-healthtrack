package br.com.fiap.healthtrack;

import java.io.Serializable;

public class Alimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		private double vlCaloria;
		private int idAlimento;
		private String dsAlimento;
		
		public Alimento () {
			super();
		}
		public Alimento (int idAlimento, String dsAlimento, double vlCaloria) {
			this.idAlimento = idAlimento;
			this.dsAlimento = dsAlimento;
			this.vlCaloria = vlCaloria;
		}
		
		public double getVlCaloria() {
			return vlCaloria;
		}
		public void setVlCaloria(double vlCaloria) {
			this.vlCaloria = vlCaloria;
		}
		public int getIdAlimento() {
			return idAlimento;
		}
		public void setIdAlimento(int idAlimento) {
			this.idAlimento = idAlimento;
		}
		public String getDsAlimento() {
			return dsAlimento;
		}
		public void setDsAlimento(String dsAlimento) {
			this.dsAlimento = dsAlimento;
		}
	}

