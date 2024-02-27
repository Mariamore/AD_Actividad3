package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "colegios")
public class Colegio {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String nombre, direccion;
	
	//Consideramos, para simplificar, que cada profesor solo da clase en un colegio, pero el colegio tiene N profesores
	@OneToMany(mappedBy="colegio", cascade = CascadeType.PERSIST)
	private List<Profesor> listaProfesores;
	//Consideramos que un colegio tiene N asignaturas y cada asigantura puede ser impartida en N colegios
	@ManyToMany
	private List<Asignatura> listaAsignaturas;
	//Consideramos que el colegio tiene un director y que el director solo lo es de un colegio
	@OneToOne
	@JoinColumn(name="fk_id_director", referencedColumnName="id")
	private Director director;
	
	public Colegio(int id, String nombre, String direccion, List<Profesor> listaProfesores,
			List<Asignatura> listaAsignaturas, Director director) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaProfesores = listaProfesores;
		this.listaAsignaturas = listaAsignaturas;
		this.director = director;
	}
	
	public Colegio() {
		super();
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
	
	
	
}
