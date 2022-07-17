package proyectoJUNIT;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import jdk.internal.org.jline.utils.Log;


public class Main {
	
	public Main() {}
	
	private static Logger LogJava = Logger.getLogger(Main.class);
	
	static ArrayList<Integer> inventario = new ArrayList<Integer>();
    static ArrayList<Integer> aux_inventario = new ArrayList<Integer>();
    static ArrayList<Receta> recetas;
	
	public static void main(String[] args) {
		
		LogJava.info("Cafetera Prendida");
		
		boolean flag = true;
		
	    // Menu de la cafetera
		while(flag) {
			System.out.println("MENU CAFERA\n	1.Agregar inventario\n	2.Verificar Inventario\n	3.Comprar Bebida\n	4.Salir");
			
			System.out.println("Ingrese su eleccion;");
			try {
				
				Scanner in = new Scanner(System.in);
				int option = in.nextInt();
				if (option == 1) {
					agregarInvertario();
				}else if (option == 2) {
					verificarInventario();
				}else if (option == 3) {
					
					// Se muestran las bebidas 
					for (int i=0;i<recetas.size();i++) {
						String indice = String.valueOf(i+1);
						System.out.println("	"+indice+". "+recetas.get(i).nombre);
						System.out.println("		precio : $"+String.valueOf(recetas.get(i).precio));
					}
			
					boolean flag2 = true;
					int option_receta = 1;
					int option_dinero = 0;
					
					while (flag2) {
						try {
							System.out.println("\nIngrese la bebida que desea:");
							Scanner in_receta = new Scanner(System.in);
							option_receta = in_receta.nextInt();
							// Si se ingresa una opcion no valida
							if (option_receta > recetas.size()){
								System.out.println("Ingrese una opcion valida");
								LogJava.error("Opcion no compatible");
								continue;
							//opcion correcta
							}else if(option_receta > 0){
								flag2 = false;
							// Si se ingresa un negativo
							}else {
								System.out.println("Ingrese un numero mayor a cero");
								LogJava.error("Opcion no valida");

							}
						// Atrapa lo que no es entero
						}catch (Exception e) {
							System.out.println("Ingrese un valor entero");
							LogJava.error("No ingresa un numero");
							flag2 = true;
						}
					}
					
					flag2=true;
					while(flag2) {
						try {
							System.out.println("Ingrese la cantidad de dinero:");
							Scanner in_dinero = new Scanner(System.in);
							option_dinero = in_dinero.nextInt();
							// Si ingresa un negativo
							if(option_dinero<0) {
								LogJava.error("Cantidad de dinero no compatible");
								System.out.println("Ingrese un valor positivo");
								continue;
							}else {flag2 = false;}
							
						}catch (Exception e) {
							System.out.println("Ingrese un valor entero");
							LogJava.error("No ingresa un numero");
						}
						
					}
					
					
					comprarBebida(option_receta,option_dinero);
				}else if (option == 4) {
					System.out.println("Saliendo de la Cafetera...");
					LogJava.info("Cafetera Apagada");
					System.exit(0);
					flag = false;
				}else {
					// condicion que captura el no ingresar una un entero como opcion valida en el menu
					
					//System.out.println("Ingrese una opcion correcta\n");
					System.err.println("Ingrese una opcion correcta\n");

				}
				
			//catch que captura si se ingresa un char en vez de un int	
			}catch (Exception e) {
				System.out.println("Ingrese una opcion valida en el menu de la cafetera");
				LogJava.error("No ingresa un numero");
				continue;
			}
			
		}
		
		
	}
	
	// funcion que agrega insumos al inventario
	public static boolean agregarInvertario() {
		System.out.println("Ingrese la cantidad de insumo que desea agregar en este orden :\n	1. Cafe\n	2.Leche\n	3.Chocolate\n	4.Azucar");
		ArrayList<Integer> nuevo_inventario = new ArrayList<Integer>();
		boolean flag = true;
		int i = 0;
		Scanner in;
		int option;
		while (flag) {
			try {
				if(i==0) {System.out.println("Cafe:");}
				if(i==1) {System.out.println("Leche:");}
				if(i==2) {System.out.println("Chocolate:");}
				if(i==3) {System.out.println("Azucar:");}
				in = new Scanner(System.in);
				option = in.nextInt();
				// si es negativo, vuelve a preguntar por el mismo ingrediente
				if (option >= 0){
					int aux = (Integer)inventario.get(i);
					
					//control para no superar la capacidad maxima por insumo de la cafetera
					if(i==0) {
						if (aux+option>10) {nuevo_inventario.add(10);}
						else {nuevo_inventario.add(i,aux+option);}
					}
					if(i==1) {
						if (aux+option>10) {nuevo_inventario.add(10);}
						else {nuevo_inventario.add(i,aux+option);}}
					if(i==2) {
						if (aux+option>80) {nuevo_inventario.add(80);}
						else {nuevo_inventario.add(i,aux+option);}}
					if(i==3) {
						if (aux+option>40) {nuevo_inventario.add(40);}
						else {nuevo_inventario.add(i,aux+option);}}
					
					i++;
				}else {
					System.out.println("Ingrese un numero mayor a cero");
					LogJava.error("Cantidad no compatible");
				}
			// catch que captura si ingresa un char en vez de un int
			}catch (Exception e){
				System.out.println("Ingrese un numero entero");
				LogJava.error("No ingresa un numero");

				flag = true;
			}
			if (i== 4) {flag = false;LogJava.info("Inventario agregado");}
			option = 0;
		}
		inventario = nuevo_inventario;
		return !flag;
		
	}
	
	//funcion que muestra los insumos que estan en el inventario
	public static boolean verificarInventario() {
		boolean flag = false;
		for(int i=0;i<inventario.size();i++) {
			if (i == 0) {
				System.out.println("	Cafe      : " + inventario.get(0));
			}else if (i == 1) {
				System.out.println("	Leche     : " + inventario.get(1));

			}else if (i == 2) {
				System.out.println("	Chocolate : " + inventario.get(2));

			}else{
				System.out.println("	Azucar    : " + inventario.get(3)+"\n");
				flag = true;
			}
		}
		LogJava.info("Se verificó inventario");
		return flag;
	}

	//funcion que simula la compra de una bebida, retorna el nuevo inventario descontando los insumos usados
	public static boolean comprarBebida(int option_receta,int option_dinero) {
		boolean posibleventa = false;
	
		if(option_dinero<recetas.get(option_receta-1).precio) {
			LogJava.error("Cantidad de dinero insuficiente");
			System.out.println("Dinero insuficiente");
			return false;
		}
		
		posibleventa = sePuedeVender(recetas.get(option_receta - 1));

		if (posibleventa) {
			disminucionInventario(recetas.get(option_receta - 1));
			int vuelto = option_dinero - recetas.get(option_receta - 1).precio;
			System.out.println("	Su bebida " + recetas.get(option_receta - 1).nombre + " esta lista");
			System.out.println("	Su cambio es de: " + String.valueOf(vuelto) + "\n");
			LogJava.info(recetas.get(option_receta - 1).nombre + " vendido/a");
		} else {
			System.out.println(
					"Insumos insifucientes para preparar un/a " + recetas.get(option_receta - 1).nombre + "\n");
			LogJava.info("Insumos insuficientes para preparar la bebida seleccionada");
			
		}

		
		// POR AHORA
		return posibleventa;
	}
	
	// Verifica si existen los insumos suficientes para preparar la bebida
	public static boolean sePuedeVender(Receta receta) {
		boolean flag = true;
		
		if(inventario.get(0)<receta.uni_cafe) {flag=false;}
		if(inventario.get(1)<receta.uni_leche) {flag=false;}
		if(inventario.get(2)<receta.uni_chocolate) {flag=false;}
		if(inventario.get(3)<receta.uni_azucar) {flag=false;}

		return flag;
	}
	
	// disminuye del inventario los insumos que se usan para preparar una receta en especifico
	public static void disminucionInventario(Receta receta) {
		ArrayList<Integer> nuevo_inventario = new ArrayList<Integer>();
		
		nuevo_inventario.add(inventario.get(0) - receta.uni_cafe);
		nuevo_inventario.add(inventario.get(1) - receta.uni_leche);
		nuevo_inventario.add(inventario.get(2) - receta.uni_chocolate);
		nuevo_inventario.add(inventario.get(3) - receta.uni_azucar);	
		
		inventario = nuevo_inventario;
		return;
	}
	static {
	    inventario.add(0);
	    inventario.add(0);
	    inventario.add(0);
	    inventario.add(0);
	    
	    // Se crean las recetas de la cafetera
	    recetas = new ArrayList<Receta>();
	    Receta receta1 = new Receta("Cafe con Leche",500,2,0,4,2);
	    Receta receta2 = new Receta("Leche con Chocolate",500,0,2,4,2);
	    Receta receta3 = new Receta("Cafe",500,2,0,0,2);
	    recetas.add(0, receta1);
	    recetas.add(1, receta2);
	    recetas.add(2, receta3);
	    
	}
}