package modelo.entidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="directores")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int edad;
	//Consideramos que el colegio tiene un director y que el director solo lo es de un colegio
	@OneToOne
	private Colegio Colegio;
	//Consideramos que un profesor tiene como jefe un director, y un director tiene a cargo N profesores
	@OneToMany
	private List<Profesor> listaProfesores;
	public Director(int id, String nombre, int edad, modelo.entidad.Colegio colegio, List<Profesor> listaProfesores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		Colegio = colegio;
		this.listaProfesores = listaProfesores;
	}
	public Director() {
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Colegio getColegio() {
		return Colegio;
	}
	public void setColegio(Colegio colegio) {
		Colegio = colegio;
	}
	public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}
	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}
	
	
}
