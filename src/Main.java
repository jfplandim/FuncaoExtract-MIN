public class Main {
    public static void main(String[] args) {
        // 1. Instancia nossa estrutura de dados
        MinHeap heap = new MinHeap();

        System.out.println("--- Simulação do Grafo ---");
        System.out.println("Inserindo vértices com os pesos das arestas do desenho...");

        // Simulando a inserção dos vértices como se o Algoritmo de Prim
        // estivesse descobrindo as arestas a partir de um ponto inicial.


        heap.inserir(new Vertice("ab", 1));

        heap.inserir(new Vertice("ag", 2));


        heap.inserir(new Vertice("bg", 11));


        heap.inserir(new Vertice("bc", 3));

        // Aresta g -> h (peso 3)
        heap.inserir(new Vertice("ge", 12));

        // Aresta c -> e (peso 5)
        heap.inserir(new Vertice("gh", 3));

        // Aresta c -> d (peso 7)
        heap.inserir(new Vertice("ec", 5));

        // Aresta d -> f (peso 10) - Caminho por cima
        heap.inserir(new Vertice("ed", 9));

        // Aresta g -> e (peso 12) - Caminho mais custoso, só para teste
        heap.inserir(new Vertice("eh", 2));

        // Aresta h -> f (peso 14) - Caminho por baixo
        heap.inserir(new Vertice("cd", 7));
        heap.inserir(new Vertice("df", 10));
        heap.inserir(new Vertice("fh", 14));

        System.out.println("\n--- Resultado do Extract-MIN ---");
        System.out.println("O Heap deve devolver sempre o menor peso disponível:");

        while (!heap.isEmpty()) {
            Vertice removido = heap.extractMin();
            System.out.println("Vértice: " + removido.getId() + " | Peso: " + removido.getChave());
        }
    }
}