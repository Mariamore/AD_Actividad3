package modelo.prueba;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.entidad.*;

public class Test {

    public static void main(String[] args) {
        // Objeto para conexión y transacciones con la base de datos
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("Librerias");
        EntityManager em = null;
        
       
        
        Date d1 = new Date(27, 2, 6);
        Date d2 = new Date(75, 11, 16);
        Date d3 = new Date(System.currentTimeMillis());
        
        // Autores
        Autor a1 = new Autor(null, "Gabriel", "Garcia Marquez", d1, null);
        Autor a2 = new Autor(null, "Jane", "Austen", d2, null);
        Autor a3 = new Autor(null, "Alejandro", "Dumas", d3, null);
        
        // Editoriales
        Editorial e1 = new Editorial(null, "Penguin Random House", "1745 Broadway, New York, NY 10019, Estados Unidos", null);
        Editorial e2 = new Editorial(null, "HarperCollins Publishers", "195 Broadway, New York, NY 10007, Estados Unidos", null);
        
        // Libros
        Libro l1 = new Libro(null, "Cien años de soledad", 20.99, e1, a1, null);
        Libro l2 = new Libro(null, "El amor en los tiempos del cólera", 18.50, e1, a1, null);
        // Libros escritos por Alexandre Dumas
        Libro l3 = new Libro(null, "Los tres mosqueteros", 15.75, e2, a3, null);
        Libro l4 = new Libro(null, "El conde de Montecristo", 22.30, e2, a3, null);
        // Libros escritos por Jane Austen
        Libro l5 = new Libro(null, "Orgullo y prejuicio", 12.99, e1, a2, null);
        Libro l6 = new Libro(null, "Sentido y sensibilidad", 11.20, e2, a2, null);
        // Otros libros
        Libro l7 = new Libro(null, "Moby Dick", 19.99, e2, a1, null); // Escrito por Gabriel García Márquez
        Libro l8 = new Libro(null, "Hamlet", 14.50, e1, a2, null); // Escrito por Alexandre Dumas

        // Lista de libros se lo asociamos a la libreria
        List<Libro> libreria1 = new ArrayList<>();
        libreria1.add(l1);
        libreria1.add(l3);
        libreria1.add(l5);
        libreria1.add(l8);
        
        List<Libro> libreria2 = new ArrayList<>();
        libreria2.add(l2);
        libreria2.add(l4);
        libreria2.add(l6);
        libreria2.add(l7);
        
        Libreria lib1 = new Libreria(null, "LibreriaAna", "Calle de Langosta 17", libreria2);
        Libreria lib2 = new Libreria(null, "LibreriaAlvaro", "Calle de Lagarto 9", libreria1);
        
        
        em = fac.createEntityManager();
        // Commit de la transacción
        em.getTransaction().begin();
        
        em.persist(lib1);
        em.persist(lib2);
       
        em.getTransaction().commit();
        
        
        
        //Usamos JPQL
        //Mostrar todos los libros dados de alta con su editorial 
        List<Libro> lista = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
		System.out.println("======== LIBROS ========");
		System.out.println(lista);
        
        //Mostrar todos los autores dados de alta y los libros asociados
		List<Autor> listaAutores = em.createQuery("SELECT a FROM Autor a ", Autor.class).getResultList();
		System.out.println("======== AUTORES ========");
		System.out.println(listaAutores);
	        
        //Mostrar todas las librerias 
		List<Libreria> librerias = em.createQuery("SELECT lib FROM Libreria lib ", Libreria.class).getResultList();
		System.out.println("======== LIBRERIAS ========");
		System.out.println(librerias);
	        
       
        // Cerrar el EntityManager
        em.close();
        
        // Cerrar la factoría de EntityManager
        fac.close();
        
        

		
    }
}


