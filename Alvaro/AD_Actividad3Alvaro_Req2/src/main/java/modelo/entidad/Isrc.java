package modelo.entidad;

import javax.persistence.Embeddable;

@Embeddable
public class Isrc {
	
	private String isrcPais;
	private String isrcRegistrante;
	private String isrcYear;
	private String isrcCodigo;
	
	public Isrc() {
		super();
	}

	public Isrc(String isrcPais, String isrcRegistrante, String isrcYear, String isrcCodigo) {
		super();
		this.isrcPais = isrcPais;
		this.isrcRegistrante = isrcRegistrante;
		this.isrcYear = isrcYear;
		this.isrcCodigo = isrcCodigo;
	}

	public String getIsrcPais() {
		return isrcPais;
	}

	public void setIsrcPais(String isrcPais) {
		this.isrcPais = isrcPais;
	}

	public String getIsrcRegistrante() {
		return isrcRegistrante;
	}

	public void setIsrcRegistrante(String isrcRegistrante) {
		this.isrcRegistrante = isrcRegistrante;
	}

	public String getIsrcYear() {
		return isrcYear;
	}

	public void setIsrcYear(String isrcYear) {
		this.isrcYear = isrcYear;
	}

	public String getIsrcCodigo() {
		return isrcCodigo;
	}

	public void setIsrcCodigo(String isrcCodigo) {
		this.isrcCodigo = isrcCodigo;
	}

	@Override
	public String toString() {
		return "ISRC [" + isrcPais + isrcRegistrante + isrcYear + isrcCodigo + "]";
	}
	
	

}
