package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Con la notacion @Entinty le decimo a JPA que esta clase sera una tabla en la BBDD

@Entity
//cambiamos el nombre de la tabla en la base de datos con @Table
@Table(name="editorial")
public class Editorial {
	
	//Con @Id hacemos PK sobre la propiedad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//nos autogenera la PK
	private Integer id;
	private String nombre, direccion;
	
	//Coleccion de libros de uno a muchos
	@OneToMany(mappedBy="editorial",cascade=CascadeType.ALL)
	private List<Libro> listaLibros;
	
	

	public Editorial() {
		super();
	}



	public Editorial(Integer id, String nombre, String direccion, List<Libro> listaLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibros = listaLibros;
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public List<Libro> getListaLibros() {
		return listaLibros;
	}



	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}



	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", listaLibros="
				+ listaLibros + "]";
	}

	
	

}
