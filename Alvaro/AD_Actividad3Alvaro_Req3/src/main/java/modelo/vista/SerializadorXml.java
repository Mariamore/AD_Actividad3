package modelo.vista;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import modelo.entidad.Articulo;
import modelo.entidad.ArticuloList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class SerializadorXml {
    public static void main(String[] args) {
        Articulo articulo1 = new Articulo(1, "Reloj", "Oro Blanco", 4, 1199.99);
        Articulo articulo2 = new Articulo(2, "Anillo", "Cobre Verde", 25, 11.99);
        Articulo articulo3 = new Articulo(3, "Pulsera", "Plata y nácar", 10, 95.50);

        List<Articulo> listaArticulos = new ArrayList<>();
        listaArticulos.add(articulo1);
        listaArticulos.add(articulo2);
        listaArticulos.add(articulo3);

        try {
            JAXBContext context = JAXBContext.newInstance(ArticuloList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Como no es posible serializar un ArrayList, creamos una clase para la lista de artículos
            ArticuloList articuloList = new ArticuloList(listaArticulos);

            // Creamos un StringWriter para almacenar la salida XML
            StringWriter stringWriter = new StringWriter();

            // Serializamos del contenedor a XML
            marshaller.marshal(articuloList, stringWriter);

            // Imprimimos la salida XML
            System.out.println(stringWriter.toString());
            
            // Lo guardamos en un archivo XML mediante un objeto de la clase FileOutputStream
            FileOutputStream fileOutputStream;
			try {
				fileOutputStream = new FileOutputStream(new File("articulos.xml"));
				marshaller.marshal(articuloList, fileOutputStream);
	            try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}


