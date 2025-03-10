public class Exercise2 {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(2);
        biblioteca.listarLivros();
        Livro l1 = new Livro("Livro 1", "Laura", 2019);
        Livro l2 = new Livro("Livro 2", "Eduardo", 2023);

        biblioteca.adicionarLivros(l1);
        biblioteca.adicionarLivros(l2);
        biblioteca.listarLivros();

        biblioteca.buscarLivros("Livro 1");
    }

}

class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}

class Biblioteca {

    Livro[] livros;
    int quantidadeDeLivros;

    public Biblioteca(int tamanho) {
        livros = new Livro[tamanho];
        int quantidadeDeLivros = 0;
    }

    public void buscarLivros(String livro) {
        boolean encontrado = false;
        for (int i = 0; i < quantidadeDeLivros; i++) {
            if (livros[i].getTitulo().equals(livro)) {
                encontrado = true;
            }
        }
        if (encontrado == true) {
            System.out.println("Livro foi encontrado!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public void adicionarLivros(Livro livro) {
        livros[quantidadeDeLivros] = livro;
        quantidadeDeLivros++;
        System.out.println("Livro adicionado:  " + livro.getTitulo());
    }

    public void listarLivros() {
        if (quantidadeDeLivros == 0) {
            System.out.println("Biblioteca Vazia!");
            return;
        }
        System.out.println("");
        System.out.println("---------- Listar Livros ----------");
        for (int i = 0; i < quantidadeDeLivros; i++) {
            System.out.println("Titulo: " + livros[i].getTitulo() + " -- Autor: " + livros[i].getAutor());
        }

    }
}



