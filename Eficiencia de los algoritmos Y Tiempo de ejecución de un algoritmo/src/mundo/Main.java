package mundo;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese la cantidad de vértices: ");
	        int vertices = scanner.nextInt();
	        GrafoConMatrizDeAdyacencia grafo = new GrafoConMatrizDeAdyacencia(vertices);

	        System.out.print("Ingrese la cantidad de aristas: ");
	        int aristas = scanner.nextInt();

	        for (int i = 0; i < aristas; i++) {
	            System.out.print("Ingrese la arista " + (i + 1) + " (origen destino): ");
	            int origen = scanner.nextInt();
	            int destino = scanner.nextInt();
	            grafo.agregarArista(origen, destino);
	        }

	        // Medir tiempo de ejecución para DFS
	        System.out.print("Ingrese el vértice de inicio para DFS: ");
	        int inicioDFS = scanner.nextInt();
	        long tiempoInicioDFS = System.nanoTime();
	        grafo.dfs(inicioDFS);
	        long tiempoFinDFS = System.nanoTime();
	        long tiempoEjecucionDFS = tiempoFinDFS - tiempoInicioDFS;
	        
	     // Medir tiempo de ejecución para BFS
	        System.out.print("Ingrese el vértice de inicio para BFS: ");
	        int inicioBFS = scanner.nextInt();
	        long tiempoInicio = System.nanoTime();
	        grafo.bfs(inicioBFS);
	        long tiempoFin = System.nanoTime();
	        long tiempoEjecucionBFS = tiempoFin - tiempoInicio;
	        
	        System.out.print("Ingrese el vértice a buscar: ");
	        int verticeBuscado = scanner.nextInt();

	        // Medir tiempo de ejecución de la búsqueda secuencial
	        long tiempoInicioSecuencial = System.nanoTime();
	        int resultadoSecuencial = grafo.busquedaSecuencial(verticeBuscado);
	        long tiempoFinSecuencial = System.nanoTime();
	        long tiempoEjecucionSecuencial = tiempoFinSecuencial - tiempoInicioSecuencial;

	        // Medir tiempo de ejecución de la búsqueda binaria
	        long tiempoInicioBinaria = System.nanoTime();
	        int resultadoBinaria = grafo.busquedaBinaria(verticeBuscado);
	        long tiempoFinBinaria = System.nanoTime();
	        long tiempoEjecucionBinaria = tiempoFinBinaria - tiempoInicioBinaria;


	        System.out.println("\nMatriz de adyacencia:");
	        grafo.imprimirMatrizAdyacencia();

	       
	        System.out.println("\nTiempo de ejecución DFS: " + tiempoEjecucionDFS + " nanosegundos");
	        System.out.println("Tiempo de ejecución BFS: " + tiempoEjecucionBFS + " nanosegundos");
	        System.out.println("Búsqueda secuencial - Resultado: " + resultadoSecuencial + ", Tiempo de ejecución: " + tiempoEjecucionSecuencial + " nanosegundos");
	        System.out.println("Búsqueda binaria - Resultado: " + resultadoBinaria + ", Tiempo de ejecución: " + tiempoEjecucionBinaria + " nanosegundos");

	        scanner.close();
	    }
	}