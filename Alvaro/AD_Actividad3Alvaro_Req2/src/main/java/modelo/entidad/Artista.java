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
@Table(name="artistas")
public class Artista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private boolean grupo;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="artistas_discos",
	   joinColumns= { @JoinColumn(name="fk_id_artista", referencedColumnName="id") },
	   inverseJoinColumns= { @JoinColumn(name="fk_id_disco", referencedColumnName="id")})
	private List<Disco> discos;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="artistas_canciones",
	   joinColumns= { @JoinColumn(name="fk_id_artista", referencedColumnName="id") },
	   inverseJoinColumns= { @JoinColumn(name="fk_id_cancion", referencedColumnName="id")})
	private List<Cancion> canciones;

	public Artista() {
		super();
	}

	public Artista(String nombre, boolean grupo, List<Disco> discos, List<Cancion> canciones) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
		this.discos = discos;
		this.canciones = canciones;
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

	public boolean isGrupo() {
		return grupo;
	}

	public void setGrupo(boolean grupo) {
		this.grupo = grupo;
	}

	public List<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", grupo=" + grupo + ", discos=" + discos + ", canciones="
				+ canciones + "]";
	}
	
	

}
