package modelo.entidad;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ListaArticulos")
public class ArticuloList {
    private List<Articulo> articulos;
    
    public ArticuloList() {
		super();
	}

	public ArticuloList(List<Articulo> articulos) {
		super();
		this.articulos = articulos;
	}

	@XmlElement(name="articulo")
    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}