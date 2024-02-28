import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Artista;
import modelo.entidad.Cancion;
import modelo.entidad.Disco;
import modelo.entidad.Isrc;

public class PruebaDiscografica {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DiscosMetralleta");
		
		Artista coldplay = new Artista("Coldplay", true, null, null);
		Artista beyonce = new Artista("Beyoncé", false, null, null);
		Artista sheeran = new Artista("Ed Sheeran", false, null, null);
		Artista bts = new Artista("BTS", true, null, null);
		
		List<Artista> artistasHeadFull = new ArrayList<Artista>();
		artistasHeadFull.add(coldplay);
		artistasHeadFull.add(beyonce);
		
		List<Artista> artistasDivide = new ArrayList<Artista>();
		artistasDivide.add(sheeran);
		artistasDivide.add(beyonce);
		
		List<Artista> artistasSpheres = new ArrayList<Artista>();
		artistasSpheres.add(coldplay);
		artistasSpheres.add(bts);
		
		List<Artista> artistaColdplay = new ArrayList<Artista>();
		artistaColdplay.add(coldplay);
		
		List<Artista> artistaSheeran = new ArrayList<Artista>();
		artistaColdplay.add(sheeran);
		
		Disco headFull = new Disco("A Head Full of Dreams", "Pop Alternativo", false, null, artistasHeadFull);
		Disco divide = new Disco("Divide", "Pop", false, null, artistasDivide);
		Disco spheres = new Disco("Music of the Spheres", "Pop", false, null, artistasSpheres);
		
		Isrc isrcHymn = new Isrc("GB", "AYE", "15", "01020");
		Isrc isrcAdventure = new Isrc("GB", "AYE", "15", "00981");
		Isrc isrcUp = new Isrc("GB", "AYE", "15", "00987");
		Isrc isrcPerfect = new Isrc("GB", "AHS", "17", "01211");
		Isrc isrcShape = new Isrc("GB", "AHS", "16", "00463");
		Isrc isrcEraser = new Isrc("GB", "AHS", "17", "00020");
		Isrc isrcUniverse = new Isrc("GB", "AYE", "21", "00779");
		
		Cancion hymn = new Cancion("Hymn for the Weekend", artistasHeadFull, headFull, isrcHymn);
		Cancion adventure = new Cancion("Adventure of a Lifetime", artistaColdplay, headFull, isrcAdventure);
		Cancion up = new Cancion("Up&Up", artistaColdplay, headFull, isrcUp);
		Cancion perfect = new Cancion("Perfect", artistasDivide, divide, isrcPerfect);
		Cancion shape = new Cancion("Shape of You", artistaSheeran, divide, isrcShape);
		Cancion eraser = new Cancion("Eraser", artistaSheeran, divide, isrcEraser);
		Cancion universe = new Cancion("My Universe", artistasSpheres, spheres, isrcUniverse);
		
		List<Cancion> cancionesHeadFull = new ArrayList<Cancion>();
		cancionesHeadFull.add(hymn);
		cancionesHeadFull.add(adventure);
		cancionesHeadFull.add(up);
		headFull.setCanciones(cancionesHeadFull);
		
		List<Cancion> cancionesDivide = new ArrayList<Cancion>();
		cancionesDivide.add(perfect);
		cancionesDivide.add(shape);
		cancionesDivide.add(eraser);
		divide.setCanciones(cancionesDivide);
		
		List<Cancion> cancionesSpheres = new ArrayList<Cancion>();
		cancionesSpheres.add(universe);
		spheres.setCanciones(cancionesSpheres);
		
		List<Cancion> cancionesColdplay = new ArrayList<Cancion>();
		cancionesColdplay.add(hymn);
		cancionesColdplay.add(adventure);
		cancionesColdplay.add(up);
		cancionesColdplay.add(universe);
		coldplay.setCanciones(cancionesColdplay);
		
		List<Cancion> cancionesBts = new ArrayList<Cancion>();
		cancionesBts.add(universe);
		bts.setCanciones(cancionesBts);
		
		List<Cancion> cancionesSheeran = new ArrayList<Cancion>();
		cancionesSheeran.add(perfect);
		cancionesSheeran.add(shape);
		cancionesSheeran.add(eraser);
		sheeran.setCanciones(cancionesSheeran);
		
		List<Cancion> cancionesBeyonce = new ArrayList<Cancion>();
		cancionesBeyonce.add(hymn);
		cancionesBeyonce.add(perfect);
		beyonce.setCanciones(cancionesBeyonce);
		
		List<Disco> discosColdplay = new ArrayList<Disco>();
		discosColdplay.add(headFull);
		discosColdplay.add(spheres);
		coldplay.setDiscos(discosColdplay);
		
		List<Disco> discosBts = new ArrayList<Disco>();
		discosBts.add(spheres);
		bts.setDiscos(discosBts);
		
		List<Disco> discosBeyonce = new ArrayList<Disco>();
		discosBeyonce.add(headFull);
		discosBeyonce.add(divide);
		beyonce.setDiscos(discosBeyonce);
		
		List<Disco> discosSheeran = new ArrayList<Disco>();
		discosSheeran.add(divide);
		sheeran.setDiscos(discosSheeran);
		
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(headFull);
		em.persist(divide);
		em.persist(spheres);
		em.getTransaction().commit(); 
		em.close();		
		emf.close();	

	}

}
