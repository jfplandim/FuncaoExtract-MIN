import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    List<Vertice> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    private int pai(int i){
        return (i - 2)/2;
    }

    private int esquerda(int i){
        return 2 * i + 1;
    }

    private int direita(int i){
        return 2 * i + 2;
    }

    public Vertice extractMin(){
        //verifica se o vetor esta vazio
        if (this.heap.isEmpty()){
            throw new RuntimeException("Heap vazio");
        }
        //armazena o primeiro elemento numa variavel
        Vertice min = this.heap.get(0);
        //armazena o ultimo elemento numa variavel
        Vertice ult = this.heap.remove(this.heap.size() - 1);
        //verifica se a lista n esta vazia
        if (!this.heap.isEmpty()){
            //leva o ultimo para a raiz
            this.heap.set(0, ult);
            minHeapify(0);
        }

        return min;
    }

    public void inserir(Vertice vertice){
        //adiciona um novoVertice vertice
        this.heap.add(vertice);
        //pegando o indice do novoVertice vertice
        int novoVertice = this.heap.size() - 1;
        //enquanto o novo vertice for menor que o pai
        while (novoVertice > 0 && this.heap.get(novoVertice).getChave()
                < this.heap.get(pai(novoVertice)).getChave()) {
            Vertice temp2 = this.heap.get(novoVertice);
            this.heap.set(novoVertice, this.heap.get(pai(novoVertice)));
            this.heap.set(pai(novoVertice), temp2);
            novoVertice = pai(novoVertice);
        }

    }

    private void minHeapify(int i){
        int esquerda = esquerda(i);
        int direita = direita(i);
        int menor = i;
        //verifica o filho da esquerda
        if (esquerda < this.heap.size() && this.heap.get(esquerda).getChave()
                < this.heap.get(menor).getChave()) {
            menor = esquerda;
        }
        //verifica o filho da direita
        if (direita < this.heap.size() && this.heap.get(direita).getChave() < this.heap.get(menor).getChave()){
            menor = direita;
        }
        //se o pai nao for o menor, troca
        if (menor != i){
            Vertice temp = this.heap.get(i);
            this.heap.set(i, this.heap.get(menor));
            this.heap.set(menor, temp);

            //recursao
            minHeapify(menor);
        }
    }

    public boolean isEmpty() {
        return this.heap.isEmpty();
    }
}
