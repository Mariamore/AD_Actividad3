package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	

	private String nombre, descripcion;
	private double precio;
	private String tipo, color;
	
	@ManyToMany(mappedBy="listaProductos", cascade=CascadeType.PERSIST)
	private List<Pedidos> listapedidos;
	
	
	
	public Productos() {
		super();
	}
	
	

	public Productos(Integer id, String nombre, String descripcion, double precio, String tipo, String color,
			List<Pedidos> listapedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipo = tipo;
		this.color = color;
		this.listapedidos = listapedidos;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Pedidos> getListapedidos() {
		return listapedidos;
	}

	public void setListapedidos(List<Pedidos> listapedidos) {
		this.listapedidos = listapedidos;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", tipo=" + tipo + ", color=" + color + ", listapedidos=" + listapedidos + "]";
	}
	
	

}
