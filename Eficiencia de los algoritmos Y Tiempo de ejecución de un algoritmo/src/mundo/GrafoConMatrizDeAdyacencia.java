package mundo;
import java.util.*;
public class GrafoConMatrizDeAdyacencia {
	
	private int vertices;
	// Número de vértices en el grafo
	private boolean[][] matrizAdyacencia; 
	// Matriz de adyacencia para almacenar las conexiones entre vértices

	public GrafoConMatrizDeAdyacencia(int vertices) {
	    this.vertices = vertices; 
	    // Inicializa el número de vértices
	    matrizAdyacencia = new boolean[vertices][vertices]; 
	    // Crea la matriz de adyacencia
	}

	public void agregarArista(int origen, int destino) {
	    matrizAdyacencia[origen][destino] = true; 
	    // Marca la conexión entre el vértice origen y destino
	    matrizAdyacencia[destino][origen] = true;
	    // Para grafos no dirigidos, marca la conexión en ambas direcciones
	}

	public void imprimirMatrizAdyacencia() {
	    for (int i = 0; i < vertices; i++) {
	        for (int j = 0; j < vertices; j++) {
	            // Imprime "1" si hay conexión entre los vértices 
	        	//i y j, de lo contrario imprime "0"
	            System.out.print(matrizAdyacencia[i][j] ? "1 " : "0 ");
	        }
	        System.out.println(); 
	        // Salto de línea al final de cada fila
	    }
	}

	// Implementación del algoritmo BFS
	public void bfs(int inicio) {
	    boolean[] visitado = new boolean[vertices]; 
	    // Arreglo para marcar los vértices visitados
	    Queue<Integer> cola = new LinkedList<>(); 
	    // Cola para realizar el recorrido BFS

	    visitado[inicio] = true; 
	    // Marca el vértice de inicio como visitado
	    cola.offer(inicio); 
	    // Agrega el vértice de inicio a la cola

	    System.out.println("\nRecorrido BFS a partir del vértice " + inicio + ":");
	    while (!cola.isEmpty()) {
	        int actual = cola.poll();
	        // Obtiene y elimina el vértice actual de la cola
	        System.out.print(actual + " ");
	        // Imprime el vértice actual

	        // Explora los vértices vecinos
	        for (int i = 0; i < vertices; i++) {
	            if (matrizAdyacencia[actual][i] && !visitado[i]) {
	                visitado[i] = true;
	                // Marca el vértice vecino como visitado
	                cola.offer(i); 
	                // Agrega el vértice vecino a la cola para exploración posterior
	            }
	        }
	    }
	    System.out.println();
	    // Salto de línea al final del recorrido BFS
	}
	// Implementación del algoritmo DFS
    public void dfs(int inicio) {
        boolean[] visitado = new boolean[vertices];
        Stack<Integer> pila = new Stack<>();

        pila.push(inicio);

        System.out.println("\nRecorrido DFS a partir del vértice " + inicio + ":");
        while (!pila.isEmpty()) {
            int actual = pila.pop();
            if (!visitado[actual]) {
                System.out.print(actual + " ");
                visitado[actual] = true;
            }

            for (int i = 0; i < vertices; i++) {
                if (matrizAdyacencia[actual][i] && !visitado[i]) {
                    pila.push(i);
                }
            }
        }
        System.out.println();
    }
    
    
    // Implementación de la búsqueda secuencial
    public int busquedaSecuencial(int verticeBuscado) {
        for (int i = 0; i < vertices; i++) {
            if (i == verticeBuscado) {
                return i;
            }
        }
        return -1;
        // Complejidad de tiempo en el peor caso: O(n) (Big-O), Theta(n) (Theta), Omega(1) (Omega)
    }

    public int busquedaBinaria(int verticeBuscado) {
        int izquierda = 0;
        int derecha = vertices - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (medio == verticeBuscado) {
                return medio;
            } else if (medio < verticeBuscado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
        // Complejidad de tiempo en el peor caso: O(log n) (Big-O), Theta(log n) (Theta), Omega(1) (Omega)
    }
}
