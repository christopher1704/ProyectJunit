package proyectoJUNIT;
import java.util.ArrayList;

public class RecetaMia {
	
	public RecetaMia() {}
		
	public static class Receta {
		public String titulo;
		public String tipo;
		public String contenido;
		public String autor;
		public String fecha_publicacion;
		
		public Receta (String titulo, String tipo, String  contenido, String autor, String fecha_publicacion) {
			this.titulo = titulo;
			this.tipo = tipo;
			this.contenido = contenido;
			this.autor = autor;
			this.fecha_publicacion = fecha_publicacion;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getContenido() {
			return contenido;
		}

		public void setContenido(String contenido) {
			this.contenido = contenido;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public String getFecha_publicacion() {
			return fecha_publicacion;
		}

		public void setFecha_publicacion(String fecha_publicacion) {
			this.fecha_publicacion = fecha_publicacion;
		}
		
		
		
		
	}

	public static final ArrayList<Receta> ITEMS = new ArrayList<Receta>();
	
	public static void addReceta(Receta receta) {
		ITEMS.add(receta);
	}
	
	public static Receta getReceta(String titulo) {
		for(Receta current_receta: RecetaMia.ITEMS) {
			if (titulo.equals(current_receta.titulo)) {
				return current_receta;
			}
		}
		return null;
	}

	public static ArrayList<Receta> getItems() {
		return ITEMS;
	}
	
	
	

}
