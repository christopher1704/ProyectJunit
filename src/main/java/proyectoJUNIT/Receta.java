package proyectoJUNIT;

public class Receta{
	String nombre;
	int precio;
	int uni_cafe;
	int uni_leche;
	int uni_chocolate;
	int uni_azucar;
	
	public Receta(String nombre,int precio,int uni_cafe,int uni_leche,int uni_chocolate,int uni_azucar) {
		this.nombre = nombre;
		this.precio = precio;
		this.uni_azucar = uni_azucar;
		this.uni_cafe = uni_cafe;
		this.uni_chocolate = uni_chocolate;
		this.uni_leche = uni_leche;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getUni_cafe() {
		return uni_cafe;
	}

	public void setUni_cafe(int uni_cafe) {
		this.uni_cafe = uni_cafe;
	}

	public int getUni_leche() {
		return uni_leche;
	}

	public void setUni_leche(int uni_leche) {
		this.uni_leche = uni_leche;
	}

	public int getUni_chocolate() {
		return uni_chocolate;
	}

	public void setUni_chocolate(int uni_chocolate) {
		this.uni_chocolate = uni_chocolate;
	}

	public int getUni_azucar() {
		return uni_azucar;
	}

	public void setUni_azucar(int uni_azucar) {
		this.uni_azucar = uni_azucar;
	}
	
}
