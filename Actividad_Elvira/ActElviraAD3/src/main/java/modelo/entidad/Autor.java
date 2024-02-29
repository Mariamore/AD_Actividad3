package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//Con la notacion @Entinty le decimo a JPA que esta clase sera una tabla en la BBDD

@Entity
//cambiamos el nombre de la tabla en la base de datos con @Table
@Table(name="autores")
public class Autor {
	
	//Con @Id hacemos PK sobre la propiedad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//nos autogenera la PK
	private Integer id;
	private String nombre, apellidos;
	
	//Convertir el atributo fecha en la BBDD
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	
	//Para hacer la relacion bidireccional, la clase que tiene obligada la fk es la de libro
	//Cuando demos de alta o baja a un autor, daremos de alta o baja  sus libros asociados
	@OneToMany(cascade=CascadeType.ALL)
	private List<Libro> listaLibros;


	public Autor() {
		super();
	}


	public Autor(Integer id, String nombre, String apellidos, Date fechaNacimiento, List<Libro> listaLibros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
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


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public List<Libro> getListaLibros() {
		return listaLibros;
	}


	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}


	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", listaLibros=" + listaLibros + "]";
	}
	
	
}
