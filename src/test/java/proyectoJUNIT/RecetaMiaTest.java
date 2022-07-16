package proyectoJUNIT;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import proyectoJUNIT.RecetaMia;



public class RecetaMiaTest {

	RecetaMia recetario = new RecetaMia();

	@Before 
	public void setUp() throws Exception {
		recetario.ITEMS.clear();
	}
	
	@Test
	public void EmptyRecetario() throws Exception {
		// GIVEN
		
		// THEN
		
		// WHEN
		Assert.assertTrue(recetario.getItems().size() == 0);
	}
	
	@Test
	public void AgregarReceta() throws Exception{
		RecetaMia.Receta receta = new RecetaMia.Receta("Receta 1","postre","contenido 1","Julio","08/07/2022");
		recetario.addReceta(receta);
		Assert.assertTrue(recetario.getItems().size()==1);
		recetario.ITEMS.clear();
		
	}
	
	@Test
	public void AgregarDosRecetas() throws Exception{
		RecetaMia.Receta receta1 = new RecetaMia.Receta("Receta 1","postre","contenido 1","Julio","08/07/2022");
		RecetaMia.Receta receta2 = new RecetaMia.Receta("Receta 2","postre","contenido 2","Julio","08/07/2022");
		recetario.addReceta(receta1);
		recetario.addReceta(receta2);
		Assert.assertTrue(recetario.getItems().size()==2);
		
	}
	
	@Test
	public void DeleteReceta() throws Exception {
		// GIVEN
		RecetaMia.Receta receta = new RecetaMia.Receta("Receta 1","postre","contenido 1","Julio","08/07/2022");
		recetario.addReceta(receta);
		// THEN
		recetario.ITEMS.remove(receta);
		// WHEN
		Assert.assertTrue(recetario.getItems().size() == 0);
	}
	
	@Test
	public void DuplicateRecete() throws Exception {
		// GIVEN
		RecetaMia.Receta receta1 = new RecetaMia.Receta("Receta 1","postre","contenido 1","Julio","08/07/2022");
		recetario.addReceta(receta1);
		RecetaMia.Receta receta2 = new RecetaMia.Receta("Receta 1","postre","contenido 1","Julio","08/07/2022");
		recetario.addReceta(receta2);
		// THEN
		boolean flag = false;
		
		if(receta1.getAutor()==receta2.getAutor()) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(receta1.getContenido() == receta2.getContenido()) {
			flag = true;
		}else {
				flag=false;
		}
		
		if(receta1.getFecha_publicacion()==receta2.getFecha_publicacion()) {
			flag = true;
		}else {
			flag = false;
		}
		
		if(receta1.getTipo() == receta2.getTipo()) {
			flag=true;
		}else {
			flag = false;
		}
		
		if(receta1.getTitulo() == receta2.getTitulo()) {
			flag=true;
		}else {
			flag=false;
		}
		
		// WHEN
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
	
}
