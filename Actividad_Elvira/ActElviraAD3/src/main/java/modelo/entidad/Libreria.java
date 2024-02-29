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
@Table(name="libreria")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String nombreDueño;
	private String direccion;
	
	
	//Coleccion de libros
	//Relacion de muchos a muchos
	//Necesitamos crear una tabla intermedia, ya que su relación con la 
	//Entidad libro es N-->M, por lo que se genera una tabla renacida
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="libreria_libros", //Nombre de la tabla
				joinColumns = {@JoinColumn(name ="fk_id_libreria", referencedColumnName="id")},//Columnas que aporta esta entidad a la nueva tabla
				inverseJoinColumns = { @JoinColumn(name="fk_id_libro", referencedColumnName="id")//Columnas que aporta la otra entidad con la q se relaciona	
				})
	private List<Libro> coleccion;


	public Libreria() {
		super();
	}


	public Libreria(Integer id, String nombreDueño, String direccion, List<Libro> coleccion) {
		super();
		this.id = id;
		this.nombreDueño = nombreDueño;
		this.direccion = direccion;
		this.coleccion = coleccion;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public List<Libro> getColeccion() {
		return coleccion;
	}


	public void setColeccion(List<Libro> coleccion) {
		this.coleccion = coleccion;
	}


	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombreDueño=" + nombreDueño + ", direccion=" + direccion + ", coleccion="
				+ coleccion + "]";
	}



	
	
	
}
