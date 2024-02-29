package modelo.entidad;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaArticulos {
	
	private List<Articulos> lista;
	


	public ListaArticulos() {
		super();
	}

	public ListaArticulos(List<Articulos> lista) {
		super();
		this.lista = lista;
	}

	public List<Articulos> getLista() {
		return lista;
	}

	public void setLista(List<Articulos> lista) {
		this.lista = lista;
	}
	

}
