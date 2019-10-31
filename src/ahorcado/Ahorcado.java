package ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	// Método que comprueba que la partida se ha terminado
	// O pierdo las vidas o gano la partida

	
	public static boolean Pierdes(String vFallos[]) {
		boolean acaba=true;
		for(int j= 0;j<vFallos.length;j++) {
			if(vFallos[j] == null) {
				acaba = false;
				break;
			}
		}
		if(acaba) {
			System.out.println("Pierdes");
		}
		return acaba;
	}
	
	public static boolean Ganas(String vHuecos[]) {
		boolean acaba=true;
		for(int i = 0; i<vHuecos.length; i++) {
			if(vHuecos[i].equalsIgnoreCase("_")) {
				acaba=false;
				break;
			}
		}
		if(acaba) {
			System.out.println("Ganas");
		}
		return acaba;
	}

	public static void inicializarVectores(String vHuecos[], String vSolucion[], String palabra) {
		for (int i = 0; i < vSolucion.length; i++) {
			vHuecos[i] = "_";
			vSolucion[i] = palabra.substring(i, i + 1);
			// Compruebo que todo este bien
			// System.out.print(vHuecos[i] + " ");
			// System.out.print(vSolucion[i] + " ");
		}
	}

	public static void pintaMuñeco(String vFallos[],String vHuecos[]) {
		int fallos = 0;

		// Calculo cuantos fallos llevo
		for (int i = 0; i < vFallos.length; i++) {
			if (vFallos[i]!=null) {
				fallos++;
			}
		}
			
		// Pinto muñeco
		switch (fallos) {
		case 1:
			System.out.println("______________________");
			break;
			
		case 2:
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________________");
			break;
			
		case 3:
			System.out.println("_____________");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________________");

			break;
			
		case 4:
			System.out.println("_____________");
			System.out.println("|            |");
			System.out.println("|            |");
			System.out.println("|           <O>");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________________");
			break;
			
		case 5:
			System.out.println("_____________");
			System.out.println("|            |");
			System.out.println("|            |");
			System.out.println("|           <O>");
			System.out.println("|            |");
			System.out.println("|            |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________________");
			break;
			
		case 6:
			System.out.println("_____________");
			System.out.println("|            |");
			System.out.println("|            |");
			System.out.println("|           <O>");
			System.out.println("|           /|\\");
			System.out.println("|            |");
			System.out.println("|           / \\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|_____________________");
			break;
		}
		
		System.out.println();
		System.out.println();
		for (int i = 0; i < vHuecos.length; i++) {
			System.out.print(vHuecos[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Fallos:");
		for (int i = 0; i < vFallos.length; i++) {
			if (vFallos[i]!=null)
				System.out.print(vFallos[i] + " ");
		}
		
	}
	
	//Pregunta la letra y actualiza los vectores
	//Si se encuentra actualiza vHuecos
	//Si fallo actualiza vFallos
	public static void preguntarLetra(String vHuecos[], String vSolucion[], String vFallos[]) {
		Scanner leer = new Scanner(System.in);
		String letra ="";
		System.out.println("dime una letra");
		letra=leer.nextLine();
		boolean encontrado=false;
		
		for (int i=0;i<vSolucion.length;i++) {
			if(letra.equalsIgnoreCase(vSolucion[i])) {
				vHuecos[i]=letra;
				encontrado=true;
			}
		}
		if(!encontrado) {
			for (int i = 0; i < vFallos.length; i++) {
				if(vFallos[i]==null) {
					vFallos[i]=letra;
					break;
				}
			}
		}
	}
	
	public static String alearotio() {
	
		String[] lista= {"PERRO", "LAPIZ", "ORDENADOR", "TECLADO", "PROCESADOR", "SISTEMA"};
		Random azar =new Random();
		
		
		return lista[azar.nextInt(5)];
	}
	

	public static void main(String[] args) {
		String palabraSolucion = alearotio();
		String vFallos[], vSolucion[], vHuecos[];
		Scanner leer = new Scanner(System.in);

		// Tamaño 6 porque son 6 vidas máximo
		vFallos = new String[6];
		vHuecos = new String[palabraSolucion.length()];
		vSolucion = new String[palabraSolucion.length()];
		inicializarVectores(vHuecos, vSolucion, palabraSolucion);

		do {
			pintaMuñeco(vFallos,vHuecos);
			preguntarLetra(vHuecos, vSolucion, vFallos);
		} while(!Pierdes(vFallos) && !Ganas(vHuecos));

	}

}
	
	


