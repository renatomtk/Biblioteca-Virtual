import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Collections;

public class Dijkstra {

    // método que implementa o algoritmo de Dijkstra para encontrar os caminhos mais curtos
    public static Map<Livro, Integer> dijkstra(HashMap<Livro, Map<Livro, Integer>> grafo, Livro origem) { // recebe o grafo e o livro de origem como parâmetros
        Map<Livro, Integer> distancias = new HashMap<>();
        PriorityQueue<Node> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(node -> node.distancia));
        Set<Livro> visitados = new HashSet<>();

        // inicializando as distâncias para todos os livros no grafo
        for (Livro livro : grafo.keySet()) {
            distancias.put(livro, Integer.MAX_VALUE); // inicializando com o valor infinito
        }
        distancias.put(origem, 0); // a distância do livro de origem para ele mesmo é 0

        // adicionando o livro de origem na fila de prioridade
        filaPrioridade.add(new Node(origem, 0));

        while (!filaPrioridade.isEmpty()) {
            Livro atual = filaPrioridade.poll().livro; // pegando o livro com a menor distância

            // pulamos para o próximo se o livro já foi visitado
            if (visitados.contains(atual)) {
                continue;
            }

            visitados.add(atual); // adiciona o livro como visitado
            int distanciaAtual = distancias.get(atual); // pegando a distância atual até este livro

            // explorando os vizinhos do livro atual
            for (Map.Entry<Livro, Integer> vizinhoEntry : grafo.getOrDefault(atual, Collections.emptyMap()).entrySet()) {
                Livro vizinho = vizinhoEntry.getKey();
                int peso = vizinhoEntry.getValue();

                if (!visitados.contains(vizinho)) { // caso o vizinho ainda não foi visitado
                    int novaDistancia = distanciaAtual + peso; // calculando a nova distância

                    if (novaDistancia < distancias.get(vizinho)) { // caso a nova distância for menor que a distância atual
                        distancias.put(vizinho, novaDistancia); // atualizando a distância
                        filaPrioridade.add(new Node(vizinho, novaDistancia)); // adiciona o vizinho na fila
                    }
                }
            }
        }

        return distancias; // retorna com as menores distâncias
    }

    // método para obter recomendações baseadas no algoritmo de Dijkstra
    public static List<Livro> obterRecomendacoesDijkstra(HashMap<Livro, Map<Livro, Integer>> grafo, Livro origem, int maxRecomendacoes) {
        // calculando as distâncias usando o algoritmo de Dijkstra
        Map<Livro, Integer> distancias = dijkstra(grafo, origem);
        List<Map.Entry<Livro, Integer>> sortedEntries = new ArrayList<>(distancias.entrySet());

        // removendo o próprio livro de origem da lista de recomendações
        sortedEntries.removeIf(entry -> entry.getKey().equals(origem));

        // ordenando as entradas pela distância (menor para maior)
        sortedEntries.sort(Comparator.comparingInt(Map.Entry::getValue));

        // criando uma lista com até n livros (depende do que passamos como parâmetro em maxRecomendacoes)
        List<Livro> recomendacoes = new ArrayList<>();
        for (int i = 0; i < Math.min(maxRecomendacoes, sortedEntries.size()); i++) {
            recomendacoes.add(sortedEntries.get(i).getKey());
        }

        return recomendacoes; // retorna a lista de livros recomendados
    }

    // classe auxiliar para a fila de prioridade (PriorityQueue)
    private static class Node {
        Livro livro;
        int distancia;

        Node(Livro livro, int distancia) {
            this.livro = livro;
            this.distancia = distancia;
        }
    }
}