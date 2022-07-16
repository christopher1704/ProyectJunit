package proyectoJUNIT;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;



public class CafeteraTest {
	
	Main main = new Main();
	
	@Before 
	public void setUp() throws Exception {;
	}
	
	
	@Test
	public void ComprarBebidaTrue() throws Exception {
		// GIVEN
		// Se añaden los ingredientes para luego probar si se puede vender una bebida
		ArrayList<Integer> nuevo_inventario = new ArrayList<Integer>();
		nuevo_inventario.add(2);
		nuevo_inventario.add(0);
		nuevo_inventario.add(4);
		nuevo_inventario.add(2);


		// THEN
		main.inventario = nuevo_inventario;
		
		// WHEN
		
		Assert.assertTrue(main.comprarBebida(1,500));
		//Assert.assertTrue(main.inventario.size()==4);
	}	
	
	
	@Test
	public void AgregarInventario() throws Exception {
		// GIVEN


		// THEN
		
		// WHEN
		
		Assert.assertTrue(main.agregarInvertario());
		//Assert.assertTrue(main.inventario.size()==4);
	}	
	
	@Test
	public void VerificarInventario() throws Exception {
		// GIVEN


		// THEN
		
		// WHEN
		
		Assert.assertTrue(main.verificarInventario());
		//Assert.assertTrue(main.inventario.size()==4);
	}	
}
