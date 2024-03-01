package modelo.entidad;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_autor", referencedColumnName = "id")
	private Autor autor;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_editorial", referencedColumnName = "id")
	private Editorial editorial;
	@ManyToMany( cascade=CascadeType.PERSIST)
	private List<Libreria> listaLibrerias;
	
	
	
	public Libro(int id, String titulo, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		
	}
	
	
	public Libro() {
		super();
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", listaLibrerias=" + listaLibrerias + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public List<Libreria> getListaLibrerias() {
		return listaLibrerias;
	}
	public void setListaLibrerias(List<Libreria> listaLibrerias) {
		this.listaLibrerias = listaLibrerias;
	}
	
	
}
