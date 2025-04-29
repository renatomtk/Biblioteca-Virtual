// Atividade Formativa 2 - Métodos de Pesquisa e Ordenação em Estruturas de Dados
// Aluno: Renato Hideki Motikawa - Curso: Análise e Desenvolvimento de Sistemas

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Grafo grafo = new Grafo();

        // Criando 10 livros do autor H.P. Lovecraft
        Livro livro1 = new Livro("The Call of Cthulhu", "H.P. Lovecraft", 1928);
        Livro livro2 = new Livro("At the Mountains of Madness", "H.P. Lovecraft", 1936);
        Livro livro3 = new Livro("The Shadow over Innsmouth", "H.P. Lovecraft", 1936);
        Livro livro4 = new Livro("The Dunwich Horror", "H.P. Lovecraft", 1929);
        Livro livro5 = new Livro("The Colour Out of Space", "H.P. Lovecraft", 1927);
        Livro livro6 = new Livro("The Shadow Out of Time", "H.P. Lovecraft", 1936);
        Livro livro7 = new Livro("Dagon", "H.P. Lovecraft", 1919);
        Livro livro8 = new Livro("Pickman’s Model", "H.P. Lovecraft", 1927);
        Livro livro9 = new Livro("The Dreams in the Witch House", "H.P. Lovecraft", 1933);
        Livro livro10 = new Livro("The Shunned House", "H.P. Lovecraft", 1928);

        // LinkedLists - adicionando 10 livros na Biblioteca
        biblioteca.adicionarLivro(livro1.getTitulo(), livro1.getAutor(), livro1.getAnoPublicacao());
        biblioteca.adicionarLivro(livro2.getTitulo(), livro2.getAutor(), livro2.getAnoPublicacao());
        biblioteca.adicionarLivro(livro3.getTitulo(), livro3.getAutor(), livro3.getAnoPublicacao());
        biblioteca.adicionarLivro(livro4.getTitulo(), livro4.getAutor(), livro4.getAnoPublicacao());
        biblioteca.adicionarLivro(livro5.getTitulo(), livro5.getAutor(), livro5.getAnoPublicacao());
        biblioteca.adicionarLivro(livro6.getTitulo(), livro6.getAutor(), livro6.getAnoPublicacao());
        biblioteca.adicionarLivro(livro7.getTitulo(), livro7.getAutor(), livro7.getAnoPublicacao());
        biblioteca.adicionarLivro(livro8.getTitulo(), livro8.getAutor(), livro8.getAnoPublicacao());
        biblioteca.adicionarLivro(livro9.getTitulo(), livro9.getAutor(), livro9.getAnoPublicacao());
        biblioteca.adicionarLivro(livro10.getTitulo(), livro10.getAutor(), livro10.getAnoPublicacao());

        // Grafos - adicionando os 10 livros ao grafo
        grafo.adicionarLivro(livro1);
        grafo.adicionarLivro(livro2);
        grafo.adicionarLivro(livro3);
        grafo.adicionarLivro(livro4);
        grafo.adicionarLivro(livro5);
        grafo.adicionarLivro(livro6);
        grafo.adicionarLivro(livro7);
        grafo.adicionarLivro(livro8);
        grafo.adicionarLivro(livro9);
        grafo.adicionarLivro(livro10);

        // Grafos - adicionando relações entre os livros
        grafo.adicionarRecomendacao(livro1, livro2, 10);
        grafo.adicionarRecomendacao(livro1, livro4, 20);
        grafo.adicionarRecomendacao(livro2, livro3, 30);
        grafo.adicionarRecomendacao(livro2, livro5, 40);
        grafo.adicionarRecomendacao(livro3, livro6, 50);
        grafo.adicionarRecomendacao(livro4, livro7, 60);
        grafo.adicionarRecomendacao(livro5, livro8, 70);
        grafo.adicionarRecomendacao(livro6, livro9, 80);
        grafo.adicionarRecomendacao(livro7, livro10, 90);
        grafo.adicionarRecomendacao(livro8, livro1, 100);
        grafo.adicionarRecomendacao(livro9, livro5, 110);
        grafo.adicionarRecomendacao(livro10, livro3, 120);

        // LinkedLists - listando todos os livros da Biblioteca
        System.out.println("\nLista de livros na biblioteca:");
        biblioteca.listarLivros();

        // LinkedLists - removendo um livro da Biblioteca
        biblioteca.removerLivro("The Shadow over Innsmouth");

        // LinkedLists - listando todos os livros da Biblioteca após a remoção
        System.out.println("\nLista de livros na biblioteca após a remoção:");
        biblioteca.listarLivros();

        // Queues - adicionando usuários na fila de espera
        System.out.println();
        biblioteca.adicionarFilaEspera("João");
        biblioteca.adicionarFilaEspera("Maria");

        // Queues - atendendo usuários na fila de espera
        System.out.println();
        biblioteca.atenderFilaEspera();
        biblioteca.atenderFilaEspera();
        biblioteca.atenderFilaEspera();

        // Stacks - visualizando livros da Biblioteca
        System.out.println();
        biblioteca.visualizarLivro("The Call of Cthulhu");
        biblioteca.visualizarLivro("At the Mountains of Madness");
        biblioteca.visualizarLivro("The Shadow Out of Time");

        // Stacks - mostrando o histórico de navegação
        System.out.println();
        biblioteca.exibirHistoricoNavegacao();

        // Grafos - mostrando o mapa de recomendações
        System.out.println("\nMapa de Recomendações:");
        grafo.exibirGrafo();

        // Grafos - mostrando recomendações de um livro específico
        System.out.println("\nRecomendações do livro 'The Call of Cthulhu':");
        System.out.println(grafo.obterRecomendacoes(livro1));

        List<Livro> recomendacoes;

        // Dijkstra - mostrando recomendações de um livro específico usando Dijkstra
        System.out.println("\nRecomendações do livro 'The Call of Cthulhu' (usando Dijkstra):");
        recomendacoes = Dijkstra.obterRecomendacoesDijkstra(grafo.getGrafo(), livro1, 3);
        if (recomendacoes.isEmpty()) {
            System.out.println("Nenhuma recomendação encontrada.");
        } else {
            recomendacoes.forEach(System.out::println);
        }

        // Dijkstra - mostrando recomendações de um livro específico usando Dijkstra
        System.out.println("\nRecomendações do livro 'The Colour Out of Space' (usando Dijkstra):");
        recomendacoes = Dijkstra.obterRecomendacoesDijkstra(grafo.getGrafo(), livro5, 4);
        if (recomendacoes.isEmpty()) {
            System.out.println("Nenhuma recomendação encontrada.");
        } else {
            recomendacoes.forEach(System.out::println);
        }

        // Dijkstra - mostrando recomendações de um livro específico usando Dijkstra
        System.out.println("\nRecomendações do livro 'The Shunned House' (usando Dijkstra):");
        recomendacoes = Dijkstra.obterRecomendacoesDijkstra(grafo.getGrafo(), livro10, 5);
        if (recomendacoes.isEmpty()) {
            System.out.println("Nenhuma recomendação encontrada.");
        } else {
            recomendacoes.forEach(System.out::println);
        }
    }
}