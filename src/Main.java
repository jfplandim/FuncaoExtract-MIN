public class Main {
    public static void main(String[] args) {
        // 1. Criar e preencher o Grafo baseado na imagem enviada
        Grafo grafo = new Grafo();

        // Adicionando as arestas e pesos visualizados na imagem:
        grafo.adicionarAresta("a", "b", 1);
        grafo.adicionarAresta("a", "g", 2);

        grafo.adicionarAresta("b", "c", 3);
        grafo.adicionarAresta("b", "g", 11); // Linha vertical

        grafo.adicionarAresta("c", "d", 7);
        grafo.adicionarAresta("c", "e", 5); // Curva descendo para 'e'

        grafo.adicionarAresta("d", "f", 10);
        grafo.adicionarAresta("d", "e", 9); // Curva descendo para 'e'

        grafo.adicionarAresta("e", "h", 2);
        grafo.adicionarAresta("e", "g", 12); // Curva longa embaixo

        grafo.adicionarAresta("f", "h", 14);

        grafo.adicionarAresta("g", "h", 3);

        // 2. Executar o Algoritmo de Prim
        AlgoritmoPrim prim = new AlgoritmoPrim();

        // Começando do vértice 'a' (pode ser qualquer um)
        prim.executarPrim(grafo, "a");
    }
}