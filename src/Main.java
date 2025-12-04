public class Main {
    public static void main(String[] args) {
        System.out.println("=== Teste do Min-Heap com Extract-MIN ===\n");

        // Criando o Min-Heap
        MinHeap minHeap = new MinHeap();

        // Teste 1: Inserindo vértices
        System.out.println("--- Teste 1: Inserindo vértices ---");
        Vertice v1 = new Vertice("A", 15);
        Vertice v2 = new Vertice("B", 10);
        Vertice v3 = new Vertice("C", 20);
        Vertice v4 = new Vertice("D", 5);
        Vertice v5 = new Vertice("E", 8);
        Vertice v6 = new Vertice("F", 3);

        minHeap.inserir(v1);
        minHeap.inserir(v2);
        minHeap.inserir(v3);
        minHeap.inserir(v4);
        minHeap.inserir(v5);
        minHeap.inserir(v6);

        System.out.println("Vértices inseridos:");
        System.out.println("A(15), B(10), C(20), D(5), E(8), F(3)");
        System.out.println();

        // Teste 2: Extraindo o mínimo várias vezes
        System.out.println("--- Teste 2: Extraindo elementos (ordem crescente) ---");
        int count = 1;
        while (!minHeap.isEmpty()) {
            Vertice min = minHeap.extractMin();
            System.out.println(count + "º Extract-MIN: Vértice " + min.getId() +
                    " com chave " + min.getChave());
            count++;
        }
        System.out.println();

        // Teste 3: Tentando extrair de heap vazio
        System.out.println("--- Teste 3: Extraindo de heap vazio ---");
        try {
            minHeap.extractMin();
        } catch (RuntimeException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        System.out.println();

        // Teste 4: Teste com valores duplicados
        System.out.println("--- Teste 4: Teste com valores duplicados ---");
        MinHeap minHeap2 = new MinHeap();
        minHeap2.inserir(new Vertice("X", 7));
        minHeap2.inserir(new Vertice("Y", 7));
        minHeap2.inserir(new Vertice("Z", 3));
        minHeap2.inserir(new Vertice("W", 3));

        System.out.println("Inseridos: X(7), Y(7), Z(3), W(3)");
        System.out.println("Extraindo:");
        while (!minHeap2.isEmpty()) {
            Vertice min = minHeap2.extractMin();
            System.out.println("  -> " + min.getId() + "(" + min.getChave() + ")");
        }
        System.out.println();

        // Teste 5: Teste com um único elemento
        System.out.println("--- Teste 5: Heap com um único elemento ---");
        MinHeap minHeap3 = new MinHeap();
        minHeap3.inserir(new Vertice("UNICO", 42));
        Vertice unico = minHeap3.extractMin();
        System.out.println("Extraído: " + unico.getId() + "(" + unico.getChave() + ")");
        System.out.println("Heap vazio? " + minHeap3.isEmpty());
        System.out.println();

        // Teste 6: Teste de performance com muitos elementos
        System.out.println("--- Teste 6: Performance com 1000 elementos ---");
        MinHeap minHeap4 = new MinHeap();

        // Inserindo 1000 elementos aleatórios
        for (int i = 0; i < 1000; i++) {
            int chaveAleatoria = (int)(Math.random() * 10000);
            minHeap4.inserir(new Vertice("V" + i, chaveAleatoria));
        }

        System.out.println("1000 elementos inseridos");

        // Extraindo todos e verificando ordem
        int anterior = Integer.MIN_VALUE;
        boolean ordenado = true;
        while (!minHeap4.isEmpty()) {
            Vertice min = minHeap4.extractMin();
            if (min.getChave() < anterior) {
                ordenado = false;
                break;
            }
            anterior = min.getChave();
        }

        System.out.println("Todos extraídos em ordem crescente? " + ordenado);

        System.out.println("\n=== Testes concluídos ===");
    }
}