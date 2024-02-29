package modelo.prueba;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Cliente;
import modelo.entidad.Direccion;
import modelo.entidad.Pedidos;
import modelo.entidad.Productos;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tienda");
		EntityManager em =  null;
		
		Direccion d1 = new Direccion(null, "Calle Sanchez Irujo", "Madrid", 28014,null);
		Direccion d2 = new Direccion(null, "Avenida la suerte", "Sevilla", 28009,null);
		Direccion d3 = new Direccion(null, "Paseo Infanta Isabel", "Salamanca", 48567,null);
		
		
		Cliente c1 = new Cliente(null, "Alvaro", "Lopez", 112233, null, null);
		Cliente c2 = new Cliente(null, "Ana", "Medina", 445566, null, null);
		Cliente c3 = new Cliente(null, "Enrique", "Benito", 778899, null, null);
		
		//cruzamos los datos bancarios
		c1.setDireccion(d1);
		c2.setDireccion(d2);
		c3.setDireccion(d3);
		
		d1.setCliente(c1);
		d2.setCliente(c2);
		d3.setCliente(c3);
		
		
		//Pedidos
		Pedidos p1 = new Pedidos(null, "entregado", 150.00, null, c1);
		Pedidos p2 = new Pedidos(null, "entregado", 59.00, null, c1);
		Pedidos p3 = new Pedidos(null, "procesado", 250.00, null, c2);
		Pedidos p4 = new Pedidos(null, "enviado", 19.99, null, c2);
		Pedidos p5 = new Pedidos(null, "devuelo", 39.99, null, c3);
		Pedidos p6 = new Pedidos(null, "transito", 180.00, null, c3);
		
		//Añadimos los pedidos asociados al cliente
		List<Pedidos> lp1 = new ArrayList<>();
		lp1.add(p1);
		lp1.add(p2);
		c1.setListaPedidos(lp1);
		List<Pedidos> lp2 = new ArrayList<>();
		lp2.add(p3);
		lp2.add(p4);
		c2.setListaPedidos(lp2);
		List<Pedidos> lp3 = new ArrayList<>();
		lp3.add(p5);
		lp3.add(p6);
		c3.setListaPedidos(lp3);
		
		
		List<Productos> listaProductos = new ArrayList<>();
		Productos pr1 = new Productos(null, "Pantalon", "Verano", 19.99, "Corto", "azul", lp3);
		Productos pr2 = new Productos(null, "Camiseta", "Primavera", 15.50, "Manga corta", "blanca", lp2);
		Productos pr3 = new Productos(null, "Vestido", "Verano", 29.99, "Largo", "rojo", lp1);
		Productos pr4 = new Productos(null, "Chaqueta", "Invierno", 49.99, "Largo", "negro", lp2);
		Productos pr5 = new Productos(null, "Shorts", "Verano", 12.99, "Corto", "verde", lp3);
		Productos pr6 = new Productos(null, "Bufanda", "Otoño", 9.99, "Largo", "gris", lp1);
		Productos pr7 = new Productos(null, "Sandalia", "Verano", 24.50, "Plana", "marrón", lp2);
		Productos pr8 = new Productos(null, "Jersey", "Otoño", 39.99, "Manga larga", "azul marino", lp1);
		Productos pr9 = new Productos(null, "Gorra", "Primavera", 7.99, "Visera", "negro", lp2);
		Productos pr10 = new Productos(null, "Abrigo", "Invierno", 79.99, "Largo", "beige", lp3);
		Productos pr11 = new Productos(null, "Pantalon", "Otoño", 19.99, "Largo", "azul", lp3);
		
		listaProductos.add(pr1);
		listaProductos.add(pr2);
		listaProductos.add(pr3);
		listaProductos.add(pr4);
		listaProductos.add(pr5);
		listaProductos.add(pr6);
		listaProductos.add(pr7);
		listaProductos.add(pr8);
		listaProductos.add(pr9);
		listaProductos.add(pr10);
		listaProductos.add(pr11);
		
		
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		
		em.persist(pr1);
		em.persist(pr2);
		em.persist(pr3);
		em.persist(pr4);
		em.persist(pr5);
		em.persist(pr6);
		em.persist(pr7);
		em.persist(pr8);
		em.persist(pr9);
		em.persist(pr10);
		em.persist(pr11);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	
	}

}
