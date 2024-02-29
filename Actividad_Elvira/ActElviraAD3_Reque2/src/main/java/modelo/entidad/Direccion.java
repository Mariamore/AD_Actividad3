package modelo.entidad;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String calle, ciudad;
	private int cp;
	
	@OneToOne
	@JoinColumn(name="fk_id_cliente", referencedColumnName ="id")
	private Cliente cliente;
	
	

	public Direccion() {
		super();
	}

	public Direccion(Integer id, String calle, String ciudad, int cp, Cliente cliente) {
		super();
		this.id = id;
		this.calle = calle;
		this.ciudad = ciudad;
		this.cp = cp;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + ", cp=" + cp + ", cliente=" + cliente
				+ "]";
	}

	
	
	
	
	

	

}
