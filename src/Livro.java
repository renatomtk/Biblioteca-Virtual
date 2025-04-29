public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String toString() { // este método serve para representar o objeto como uma string legível
        return "Livro [" + "Título: '" + titulo + '\'' + ", Autor: '" + autor + '\'' + ", Ano de Publicação: " + anoPublicacao + ']';
    }
}