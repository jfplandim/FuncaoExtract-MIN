import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AlgoritmoPrim {
    public void executarPrim(Grafo grafo, String verticeInicial) {
        MinHeap minHeap = new MinHeap();
        Set<String> visitados = new HashSet<>();
        List<String> resultadoMST = new ArrayList<>();
        int custoTotal = 0;

        // 1. Configuração Inicial (Slide 10)
        // Inserimos o vértice inicial com custo 0
        Vertice inicio = new Vertice(verticeInicial, 0);
        inicio.setPai(null);
        minHeap.inserir(inicio);

        System.out.println("Iniciando Prim a partir de: " + verticeInicial);
        System.out.println("------------------------------------------------");

        while (!minHeap.isEmpty()) {
            // 2. Extrai o menor (Extract-MIN)
            Vertice u = minHeap.extractMin();
            String uId = u.getId();

            // Se já visitamos esse vértice, ignoramos (estratégia para lidar com duplos no Heap)
            if (visitados.contains(uId)) {
                continue;
            }

            // Marca como visitado (Adiciona à árvore A)
            visitados.add(uId);
            custoTotal += u.getChave();

            // Adiciona ao relatório final (se tiver pai, mostra a aresta)
            if (u.getPai() != null) {
                resultadoMST.add(u.getPai() + " - " + uId + " (Peso: " + u.getChave() + ")");
            }

            // 3. Explora os vizinhos (Adj[u])
            for (Aresta aresta : grafo.getVizinhos(uId)) {
                String v = aresta.destino;
                int peso = aresta.peso;

                // Se v não foi visitado, inserimos no Heap como candidato
                if (!visitados.contains(v)) {
                    Vertice novoCandidato = new Vertice(v, peso);
                    novoCandidato.setPai(uId); // Definimos u como pai de v
                    minHeap.inserir(novoCandidato);
                }
            }
        }

        // Exibe o resultado final
        System.out.println("Arestas da Árvore Geradora Mínima (MST):");
        for (String linha : resultadoMST) {
            System.out.println(linha);
        }
        System.out.println("------------------------------------------------");
        System.out.println("Custo Total da MST: " + custoTotal);
    }
}