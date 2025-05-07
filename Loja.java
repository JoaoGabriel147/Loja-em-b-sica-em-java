import java.util.ArrayList;

// Classe base Produto
class Produto {
    private String nome;
    private double preco;
    
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public String descricao() {
        return "Produto: " + nome + ", Preço: R$ " + preco;
    }
}

// Classe Livro, herda de Produto
class Livro extends Produto {
    private String autor;
    
    public Livro(String nome, double preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }
    
    @Override
    public String descricao() {
        return super.descricao() + ", Autor: " + autor;
    }
}

// Classe DVD, herda de Produto
class DVD extends Produto {
    private int duracao; // Duração em minutos
    
    public DVD(String nome, double preco, int duracao) {
        super(nome, preco);
        this.duracao = duracao;
    }
    
    @Override
    public String descricao() {
        return super.descricao() + ", Duração: " + duracao + " minutos";
    }
}

// Classe CD, herda de Produto
class CD extends Produto {
    private String artista;
    
    public CD(String nome, double preco, String artista) {
        super(nome, preco);
        this.artista = artista;
    }
    
    @Override
    public String descricao() {
        return super.descricao() + ", Artista: " + artista;
    }
}

// Classe Estoque (Composição de produtos)
class Estoque {
    private ArrayList<Produto> produtos;
    
    public Estoque() {
        produtos = new ArrayList<>();
    }
    
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Produtos no estoque:");
            for (Produto produto : produtos) {
                System.out.println(produto.descricao());
            }
        }
    }
    
    public void exibirDetalhesProduto(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            Produto produto = produtos.get(indice);
            System.out.println("Detalhes do produto: " + produto.descricao());
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }
}

// Classe Principal
public class Loja {
    public static void main(String[] args) {
        // Criando alguns produtos
        Livro livro1 = new Livro("Java para Iniciantes", 39.90, "Autor Exemplo");
        DVD dvd1 = new DVD("Vingadores", 29.90, 150);
        CD cd1 = new CD("Rock Clássico", 19.90, "Artista Exemplo");

        // Criando o estoque
        Estoque estoque = new Estoque();
        
        // Adicionando produtos ao estoque
        estoque.adicionarProduto(livro1);
        estoque.adicionarProduto(dvd1);
        estoque.adicionarProduto(cd1);
        
        // Listando produtos no estoque
        estoque.listarProdutos();
        
        // Exibindo detalhes de um produto específico
        System.out.println("\nDetalhes do produto no índice 1:");
        estoque.exibirDetalhesProduto(1);
    }
}
