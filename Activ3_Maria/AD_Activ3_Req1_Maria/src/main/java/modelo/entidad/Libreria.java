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
import javax.persistence.Table;

@Entity
@Table(name = "librerias")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre, nombreDueño, direccion;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="librerias_libros",
				joinColumns= {@JoinColumn(name="fk_id_libreria", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name="fk_id_libro", referencedColumnName = "id")})
	private List<Libro> listaLibros;
	
	
	public Libreria(int id, String nombre, String nombreDueño, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreDueño = nombreDueño;
		this.direccion = direccion;
		
	}
	
	
	public Libreria() {
		super();
	}


	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombreDueño=" + nombreDueño + ", direccion=" + direccion
				+ ", listaLibros=" + listaLibros + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreDueño() {
		return nombreDueño;
	}
	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
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
	
	

}
