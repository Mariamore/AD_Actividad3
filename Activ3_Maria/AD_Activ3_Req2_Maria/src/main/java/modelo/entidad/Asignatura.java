package modelo.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="asignaturas")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int creditos;
	//Consideramos que un colegio tiene N asignaturas y cada asigantura puede ser impartida en N colegios
	@ManyToMany
	@JoinTable(name="colegios_asignaturas",
				joinColumns= {@JoinColumn(name="fk_id_asignatura", referencedColumnName = "id")},
				inverseJoinColumns= {@JoinColumn(name="fk_id_colegio", referencedColumnName = "id")})
	private List<Colegio> listaColegios;
	//Consideramos que cada el profesor puede impartir N asignaturas y cada asignatura puede ser impartida por N profesores
	@ManyToMany
	private List<Profesor> listaProfesores;
	public Asignatura(int id, String nombre, int creditos, List<Colegio> listaColegios,
			List<Profesor> listaProfesores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
		this.listaColegios = listaColegios;
		this.listaProfesores = listaProfesores;
	}
	public Asignatura() {
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
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public List<Colegio> getListaColegios() {
		return listaColegios;
	}
	public void setListaColegios(List<Colegio> listaColegios) {
		this.listaColegios = listaColegios;
	}
	public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}
	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}
	
	
}
