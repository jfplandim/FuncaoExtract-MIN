import java.util.*;

// Representa uma conexão entre dois vértices
class Aresta {
    String destino;
    int peso;

    public Aresta(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

// Representa o Grafo (Lista de Adjacência)
class Grafo {
    // Mapa: Nome do Vértice -> Lista de Arestas que saem dele
    Map<String, List<Aresta>> adjacencias = new HashMap<>();

    public void adicionarAresta(String origem, String destino, int peso) {
        // Adiciona aresta origem -> destino
        adjacencias.putIfAbsent(origem, new ArrayList<>());
        adjacencias.get(origem).add(new Aresta(destino, peso));

        // Como o grafo não é direcionado, adiciona também destino -> origem
        adjacencias.putIfAbsent(destino, new ArrayList<>());
        adjacencias.get(destino).add(new Aresta(origem, peso));
    }

    public List<Aresta> getVizinhos(String vertice) {
        return adjacencias.getOrDefault(vertice, new ArrayList<>());
    }
}