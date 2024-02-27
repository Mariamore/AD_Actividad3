package modelo.entidad;




import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="articulo")
@XmlType(propOrder= {
		"id",
		"nombre",
		"descripcion",
		"stock",
		"precio"
})
public class Articulo{

		private int id;
		private String nombre, descripcion;
		private int stock;
		private double precio;
		
		

		//Constructor
		public Articulo(int id, String nombre, String descripcion, int stock, double precio) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.stock = stock;
			this.precio = precio;
			
		}
		
		//Getter and setters 

		public Articulo() {
			// TODO Auto-generated constructor stub
		}
		
		@XmlAttribute
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public int getStock() {
			return stock;
		}


		public void setStock(int stock) {
			this.stock = stock;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}


		//Metodo toString
		@Override
		public String toString() {
			return "Articulos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
					+ ", precio=" + precio + "]";
		}
	
		  
	
	
}
