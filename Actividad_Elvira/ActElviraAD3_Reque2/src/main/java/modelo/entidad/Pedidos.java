package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String estadoPedido;
	private double precio;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="pedidos_con_productos",
				joinColumns= { @JoinColumn(name="fk_id_pedidos", referencedColumnName="id")},
				inverseJoinColumns= {@JoinColumn(name="fk_id_productos", referencedColumnName="id")})
	private List<Productos> listaProductos;
	
	//Un cliente tiene N pedidos, por lo tanto la fk esta en la entidad Pedidos
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="fk_cliente_id", referencedColumnName="id")
	private Cliente cliente;

	public Pedidos() {
		super();
	}

	public Pedidos(Integer id, String estadoPedido, double precio, List<Productos> listaProductos, Cliente cliente) {
		super();
		this.id = id;
		this.estadoPedido = estadoPedido;
		this.precio = precio;
		this.listaProductos = listaProductos;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Productos> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Productos> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", estadoPedido=" + estadoPedido + ", precio=" + precio + ", listaProductos="
				+ listaProductos + ", cliente=" + cliente + "]";
	}

	

}
