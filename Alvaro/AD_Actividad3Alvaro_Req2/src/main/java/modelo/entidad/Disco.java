package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="discos")
public class Disco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String estilo;
	private boolean recopilatorio;
	
	@OneToMany(mappedBy="disco", cascade=CascadeType.ALL) 
	private List<Cancion> canciones;
	
	@ManyToMany(mappedBy="discos", cascade=CascadeType.PERSIST)
	private List<Artista> artistas;

	public Disco() {
		super();
	}

	public Disco(String nombre, String estilo, boolean recopilatorio, List<Cancion> canciones, List<Artista> artistas) {
		super();
		this.nombre = nombre;
		this.estilo = estilo;
		this.recopilatorio = recopilatorio;
		this.canciones = canciones;
		this.artistas = artistas;
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

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public boolean isRecopilatorio() {
		return recopilatorio;
	}

	public void setRecopilatorio(boolean recopilatorio) {
		this.recopilatorio = recopilatorio;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", nombre=" + nombre + ", estilo=" + estilo + ", recopilatorio=" + recopilatorio
				+ ", canciones=" + canciones + ", artistas=" + artistas + "]";
	}

}
