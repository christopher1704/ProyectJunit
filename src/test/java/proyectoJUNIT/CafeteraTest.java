package proyectoJUNIT;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;



public class CafeteraTest {
	
	@Before 
	public void setUp() throws Exception {;
	}
	
	// verifica el comprar una bebida considerando insumos suficientes para prepararña y dinero suficiente
	@Test
	public void ComprarBebidaTrue() throws Exception {
		// GIVEN
		Main main = new Main();
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
	
	// verifica el no poder comprar una bebida si no tiene suficiente dinero
	@SuppressWarnings("deprecation")
	@Test
	public void ComprarBebidaFalseDinero() throws Exception {
		// GIVEN
		Main main = new Main();
		// Se añaden los ingredientes para luego probar si se puede vender una bebida
		ArrayList<Integer> nuevo_inventario = new ArrayList<Integer>();
		nuevo_inventario.add(2);
		nuevo_inventario.add(0);
		nuevo_inventario.add(4);
		nuevo_inventario.add(2);


		// THEN
		main.inventario = nuevo_inventario;
		
		// WHEN
		
		Assert.assertEquals(false,main.comprarBebida(1,400));
		//Assert.assertTrue(main.inventario.size()==4);
	}	
	
	// verifica el no poder comprar una bebida por falta de insumos
	@SuppressWarnings("deprecation")
	@Test
	public void ComprarBebidaFalseInsumo() throws Exception {
		// GIVEN
		Main main = new Main();
		// Se añaden los ingredientes para luego probar si se puede vender una bebida
		ArrayList<Integer> nuevo_inventario = new ArrayList<Integer>();
		nuevo_inventario.add(0);
		nuevo_inventario.add(0);
		nuevo_inventario.add(0);
		nuevo_inventario.add(0);


		// THEN
		main.inventario = nuevo_inventario;
		
		// WHEN
		
		Assert.assertEquals(false,main.comprarBebida(1,500));
		//Assert.assertTrue(main.inventario.size()==4);
	}	
	
	
	// verifica el agregar inventario en la cafetera
	@Test
	public void AgregarInventario() throws Exception {
		// GIVEN
		Main main = new Main();


		// THEN
		
		// WHEN
		
		Assert.assertTrue(main.agregarInvertario());
		//Assert.assertTrue(main.inventario.size()==4);
	}	
	
	// verifica si se muestran por pantalla los datos
	@Test
	public void VerificarInventario() throws Exception {
		// GIVEN
		Main main = new Main();


		// THEN
		
		// WHEN
		
		Assert.assertEquals(true,main.verificarInventario());
		//Assert.assertTrue(main.inventario.size()==4);
	}	
}
