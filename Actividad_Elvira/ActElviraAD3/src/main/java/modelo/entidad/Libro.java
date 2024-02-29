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
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Con la notacion @Entinty le decimo a JPA que esta clase sera una tabla en la BBDD

@Entity
//cambiamos el nombre de la tabla en la base de datos con @Table
@Table(name="libro")
public class Libro {
	
	//Con @Id hacemos PK sobre la propiedad
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//nos autogenera la PK
	private Integer id;
	
	
	private String titulo;
	private double precio;
	
	//muchos a muchos la fk del lado de los muchos
	//Solo en el caso que demos de alta un libro, daremos de alta una editorial para el libro
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_id_editorial", referencedColumnName="id")
	private Editorial editorial;
	
	
	//muchos a muchos la fk siempre esta del lado de los muchos
	//Solo en el caso que demos de alta un libro, daremos de alta una editorial para el libro
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_id_autor", referencedColumnName="id")
	private Autor autor;

	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Libreria> listaLibrerias;

	
	public Libro() {
		super();
	}


	public Libro(Integer id, String titulo, double precio, Editorial editorial, Autor autor,
			List<Libreria> listaLibrerias) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
		this.listaLibrerias = listaLibrerias;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public List<Libreria> getListaLibrerias() {
		return listaLibrerias;
	}


	public void setListaLibrerias(List<Libreria> listaLibrerias) {
		this.listaLibrerias = listaLibrerias;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + ", listaLibrerias=" + listaLibrerias + "]";
	}


	
	
}
