package modelo.prueba;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modelo.entidad.Articulos;
import modelo.entidad.ListaArticulos;

public class Test {

	public static void main(String[] args) {
		
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(ListaArticulos.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		try {
			
			m= contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Articulos a1 = new Articulos(1, "Silla", "Madera", 15, 29.99);
			Articulos a2 = new Articulos(2, "Mesa", "Hierro Forjado", 4, 249.99);
			Articulos a3 = new Articulos(3, "cuchara", "Acero inox.", 300, 2.99);
			
			ListaArticulos lista = new ListaArticulos();
			
			List<Articulos> listarArticulos = new ArrayList<>();
			listarArticulos.add(a1);
			listarArticulos.add(a2);
			listarArticulos.add(a3);
			
			lista.setLista(listarArticulos);
			
			m.marshal(lista, System.out);
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
