public class Exercise1 {
    public static void main(String[] args) {

        Estoque estoque = new Estoque(3);
        Produto p1 = new Produto("Laptop", 2500.00, 10);
        Produto p2 = new Produto("Mouse", 50.00, 30);


        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        //estoque.removerProduto(p1);
        estoque.listarProdutos();

    }
}

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

class Estoque {
    Produto[] produtos;
    int quantidadeDeProdutos;

    public Estoque(int tamanho) {
        produtos = new Produto[tamanho];
        quantidadeDeProdutos = 0;
    }

    public void adicionarProduto(Produto produto) {
        if (quantidadeDeProdutos < produtos.length) {
            produtos[quantidadeDeProdutos] = produto;
            quantidadeDeProdutos++;
            System.out.println("Produto adicionado com sucesso! " + produto.getNome());
        } else {
            System.out.println("Estoque cheio!");
        }
    }

    public void removerProduto(Produto produto) {
        if (quantidadeDeProdutos > 0) {
            for (int i = 0; i < produtos.length; i++) {
                if (produtos[i] == produto) {
                    produtos[i] = null;
                    quantidadeDeProdutos--;
                    System.out.println("Produto removido com sucesso! " + produto.getNome());
                    break;
                }
            }
        } else {
            System.out.println("Estoque vazio!");
        }
    }

    public void listarProdutos() {
        System.out.println("---------- Listar Produtos ----------");
        if(quantidadeDeProdutos == 0){
            System.out.println("Estoque Vazio!");
            return;
        }

        for (int i = 0; i < quantidadeDeProdutos; i++) {
            if(quantidadeDeProdutos != null) {
                System.out.println(produtos[i].getNome());
            }
        }
    }

}