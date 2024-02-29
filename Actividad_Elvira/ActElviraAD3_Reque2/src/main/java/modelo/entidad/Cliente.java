package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String nombre, apellidos;
	private Integer telefono;
	
	@OneToOne(mappedBy="cliente", cascade=CascadeType.ALL)
	private Direccion direccion;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.PERSIST)
	private List<Pedidos> listaPedidos;

	public Cliente(Integer id, String nombre, String apellidos, Integer telefono, Direccion direccion,
			List<Pedidos> listaPedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.listaPedidos = listaPedidos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Pedidos> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedidos> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", listaPedidos=" + listaPedidos + "]";
	}
	
	
	

	
	
}
