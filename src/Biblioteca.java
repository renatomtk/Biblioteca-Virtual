import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Biblioteca {
    private LinkedList<Livro> livros; // criando uma lista ligada/encadeada (LinkedList) chamada "livros"
    private Queue<String> filaEspera; // criando uma fila (queue) chamada "filaEspera"
    private Stack<Livro> historicoNavegacao; // criando uma pilha (stack) chamada "historicoNavegacao"

    public Biblioteca() {
        this.livros = new LinkedList<>(); // instanciando a lista ligada/encadeada (LinkedList)
        this.filaEspera = new LinkedList<>(); // instanciando a fila (queue)
        this.historicoNavegacao = new Stack<>(); // instanciando a pilha (stack)
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) { // método para adicionar um livro na Biblioteca
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public void removerLivro(String titulo) { // método para remover um livro da Biblioteca
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
    }

    public void listarLivros() { // método para listar todos os livros da Biblioteca
        if (livros.isEmpty()) {
            System.out.println("Não há livros na biblioteca.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    public void adicionarFilaEspera(String usuario) { // método para adicionar um usuário na fila de espera
        filaEspera.add(usuario); // adiciona um usuário no final da fila de espera
        System.out.println(usuario + " foi adicionado à fila de espera.");
    }

    public void atenderFilaEspera() { // método para remover pessoas da fila de espera
        if (!filaEspera.isEmpty()) { // caso existam pessoas na lista de espera
            System.out.println(filaEspera.poll() + " recebeu o livro."); // (if = true) o usuário recebe o livro || // o método .poll() pega o primeiro elemento da fila e o remove
        } else { // (if = false) não existem pessoas na lista de espera
            System.out.println("Não há usuários na fila de espera.");
        }
    }

    public void visualizarLivro(String titulo) { // método para visualizar um livro e armazenar na pilha de navegação
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                historicoNavegacao.push(livro); // adiciona o livro na pilha (stack)
                System.out.println("Visualizando: " + livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void exibirHistoricoNavegacao() { // método para exibir a pilha de navegação
        if (historicoNavegacao.isEmpty()) {
            System.out.println("Histórico de navegação vazio.");
        } else {
            System.out.println("Histórico de navegação:");
            while (!historicoNavegacao.isEmpty()) {
                System.out.println(historicoNavegacao.pop()); // o método .pop() remove o último elemento da pilha (stack)
            }
        }
    }
}