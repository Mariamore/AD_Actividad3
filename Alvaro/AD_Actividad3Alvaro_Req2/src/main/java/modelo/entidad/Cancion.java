package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="canciones")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	@ManyToMany(mappedBy="canciones", cascade=CascadeType.PERSIST)
	private List<Artista> artistas;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_id_disco", referencedColumnName="id")
	private Disco disco;
	
	@Embedded
	private Isrc isrc;

	public Cancion() {
		super();
	}

	public Cancion(String nombre, List<Artista> artistas, Disco disco, Isrc isrc) {
		super();
		this.nombre = nombre;
		this.artistas = artistas;
		this.disco = disco;
		this.isrc = isrc;
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

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	public Isrc getIsrc() {
		return isrc;
	}

	public void setIsrc(Isrc isrc) {
		this.isrc = isrc;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", nombre=" + nombre + ", artistas=" + artistas + ", disco=" + disco + ", isrc="
				+ isrc + "]";
	}

}
