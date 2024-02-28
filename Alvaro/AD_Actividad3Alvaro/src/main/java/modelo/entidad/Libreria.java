package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="librerias")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String nombreDueno;
	
	@Embedded
	private Direccion direccion;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="librerias_libros",
	   joinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id") },
	   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id")})
	private List<Libro> libros;
	
	
	public Libreria() {
		super();
	}

	//Al constructor con atributos no le añadimos el id porque se generará automáticamente
	public Libreria(String nombre, String nombreDueno, Direccion direccion, List<Libro> libros) {
		super();
		this.nombre = nombre;
		this.nombreDueno = nombreDueno;
		this.direccion = direccion;
		this.libros = libros;
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

	public String getNombreDueno() {
		return nombreDueno;
	}

	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombreDueno=" + nombreDueno + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}

}
