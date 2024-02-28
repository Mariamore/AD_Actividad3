import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class PruebaLibreria {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriasTintazul");
		
		Autor umbral = new Autor("Francisco", "Umbral", new Date(32,4,11));
		Autor martinGaite = new Autor("Carmen", "Martín Gaite", new Date(25,11,8));
		Autor grandes = new Autor("Almudena", "Grandes", new Date(60,4,7));
		
		Direccion direccionTusquets = new Direccion("Avenida", "Diagonal", "662-664", "Barcelona");
		Direccion direccionSiruela = new Direccion("Calle", "Almagro", "25", "Madrid");
		Direccion direccionLib1 = new Direccion("Calle", "Alcalá", "74B", "Madrid");
		Direccion direccionLib2 = new Direccion("Avenida", "del Puerto", "16", "Valencia");
		
		Editorial tusquets = new Editorial("Tusquets Editores", direccionTusquets, null);
		Editorial siruela = new Editorial("Ediciones Siruela", direccionSiruela, null);
		
		Libro mortalYRosa = new Libro("Mortal y Rosa", 9.95, siruela, umbral);
		Libro corazonHelado = new Libro("El Corazón Helado", 19.95, tusquets, grandes);
		Libro cuartoDeAtras = new Libro("El Cuarto de Atrás", 7.25, siruela, martinGaite);
		Libro caperucitaManhattan = new Libro("Caperucita en Manhattan", 12.50, siruela, martinGaite);
		Libro forjaLadron = new Libro("La Forja de un Ladrón", 5.99, tusquets, umbral);
		Libro pacientesDrGarcia = new Libro("Los Pacientes del Doctor García", 8.90, tusquets, grandes);
		Libro besosPan = new Libro("Los Besos en el Pan", 6.10, siruela, grandes);
		Libro entreVisillos = new Libro("Entre Visillos", 8.95, tusquets, martinGaite);
		
		List<Libro> librosLib1 = new ArrayList<Libro>();
		librosLib1.add(entreVisillos);
		librosLib1.add(mortalYRosa);
		librosLib1.add(besosPan);
		librosLib1.add(corazonHelado);
		
		List<Libro> librosLib2 = new ArrayList<Libro>();
		librosLib1.add(caperucitaManhattan);
		librosLib1.add(cuartoDeAtras);
		librosLib1.add(pacientesDrGarcia);
		librosLib1.add(entreVisillos);
		
		Libreria libreria1 = new Libreria("Madrid Alcalá", "Pedro Palacios", direccionLib1, librosLib1);
		Libreria libreria2 = new Libreria("Valencia Puerto", "Ana Sanjuan", direccionLib2, librosLib2);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//Persistimos las dos librerias para que den de alta en cascada todo su contenido
		em.persist(libreria1);
		em.persist(libreria2);
		//El libro "La Forja de un Ladrón" no está en ninguna librería, lo persistiremos aparte.
		em.persist(forjaLadron);
		em.getTransaction().commit(); 
		em.close();		
		emf.close();	
		

	}

}
