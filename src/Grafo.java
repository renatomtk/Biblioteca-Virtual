import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Grafo {
    private HashMap<Livro, Map<Livro, Integer>> grafo;

    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public HashMap<Livro, Map<Livro, Integer>> getGrafo() {
        return grafo;
    }

    // método para adicionar um livro ao grafo
    public void adicionarLivro(Livro livro) {
        grafo.putIfAbsent(livro, new HashMap<>()); // o método .putIfAbsent valida se o livro já existe no grafo, caso exista, o livro não é sobrescrito
    }

    // método para adicionar uma recomendação entre dois livros com peso (grafo bidirecional)
    public void adicionarRecomendacao(Livro livro1, Livro livro2, int peso) {
        grafo.putIfAbsent(livro1, new HashMap<>());
        grafo.putIfAbsent(livro2, new HashMap<>());
        grafo.get(livro1).put(livro2, peso);
        grafo.get(livro2).put(livro1, peso);
    }

    // método para adicionar uma recomendação com peso - padrão equivale a 1
    public void adicionarRecomendacao(Livro livro1, Livro livro2) {
        adicionarRecomendacao(livro1, livro2, 1);
    }

    // método para obter recomendações de um livro
    public Set<Livro> obterRecomendacoes(Livro livro) {
        return grafo.getOrDefault(livro, Collections.emptyMap()).keySet(); // Collections.emptyMap() retorna um conjunto vazio caso o livro não exista
    }

    // método para exibir o grafo
    public void exibirGrafo() {
        for (Map.Entry<Livro, Map<Livro, Integer>> entry : grafo.entrySet()) { // o método entrySet() percorre todas as chaves e seus valores no grafo (neste caso, as chaves são os livros e os valores são as recomendações)
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}