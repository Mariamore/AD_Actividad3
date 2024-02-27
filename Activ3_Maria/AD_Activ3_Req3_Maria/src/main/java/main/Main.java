package main;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modelo.entidad.Articulo;
import modelo.entidad.ConjuntoArticulo;

public class Main {

	public static void main(String[] args) {
		
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(ConjuntoArticulo.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			ConjuntoArticulo almacen = new ConjuntoArticulo();
			List<Articulo> listaArticulos = new ArrayList<>();
			listaArticulos.add(new Articulo(1, "Martillo", "Martillo de carpintero", 50, 15.99));
	        listaArticulos.add(new Articulo(2, "Destornillador", "Destornillador Phillips", 100, 5.49));
	        listaArticulos.add(new Articulo(3, "Sierra", "Sierra para madera", 30, 12.79));
	        
	        almacen.setListaArticulos(listaArticulos);
			
			m.marshal(almacen, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
