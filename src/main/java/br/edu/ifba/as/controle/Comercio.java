package br.edu.ifba.as.controle;


import br.edu.ifba.as.entidades.*;
import br.edu.ifba.as.util.HibernateUtil;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Comercio {
    private Session sessao = null;

    public Comercio(Session sessao) {
        this.sessao = sessao;
    }

    private Produto criarProdutoFilmeHobbit(){
        Categoria categoriaFilmes = new Categoria("Filmes", "Categoria de Filmes");
        sessao.save(categoriaFilmes);
        Produto produto = new Produto();
        produto.setDescricao("O Hobbit");
        produto.setPreco(29.99f);
        produto.setCategoria(categoriaFilmes);
        sessao.save(produto);
        return produto;
    }
    
    private Produto criarProdutoLivroPeregrino(){
        Categoria categoriaLivro = new Categoria("Livro", "Categoria de Livros");
        sessao.save(categoriaLivro);
        Produto produto = new Produto();
        produto.setDescricao("O Peregrino");
        produto.setPreco(15.75f);
        produto.setCategoria(categoriaLivro);
        sessao.save(produto);
        return produto;
    }
    private Produto criarProdutoAlimentoMistoQuente(){
        Categoria categoriaAlimento = new Categoria("Alimento", "Categoria de Alimentos");
        sessao.save(categoriaAlimento);
        Produto produto = new Produto();
        produto.setDescricao("Misto Quente");
        produto.setPreco(1.99f);
        produto.setCategoria(categoriaAlimento);
        sessao.save(produto);
        return produto;
    }
    private Cliente criarClienteBeltrano(){
        Cliente cliente = new Cliente();
        cliente.setNome("Beltrano");
        Endereco endereco = new Endereco();
        endereco.setRua("Rua dos Beltranos, 60");
        endereco.setCidade("Blumenau");
        endereco.setCliente(cliente);
        cliente.setEndereco(endereco);
        sessao.save(cliente);
        return cliente;
    }
    private Cliente criarClienteFulano(){
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        cliente.setNome("Fulano");
        cliente.setEndereco(endereco);
        endereco.setRua("Rua dos Fulanos, 6");
        endereco.setCidade("Florianópolis");
        endereco.setCliente(cliente);
        sessao.save(cliente);
        return cliente;
    }
    private Empregado criarEmpregadoMelo(){
        Empregado chefe = new Empregado();
        chefe.setNome("Chefe");
        sessao.save(chefe);
        Empregado empregado1 = new Empregado();
        empregado1.setNome("Melo");
        empregado1.setChefe(chefe);
        sessao.save(empregado1);
        return empregado1;
    }
    private Empregado criarEmpregadoLuckow(){
        Empregado empregado = new Empregado();
        empregado.setNome("Luckow");
        sessao.save(empregado);
        return empregado;
    }
    public void criarPedidos(){
        Produto filmeHobbit = criarProdutoFilmeHobbit();
        Produto livroPeregrino = criarProdutoLivroPeregrino();
        Produto alimentoMistoQuente = criarProdutoAlimentoMistoQuente();
        Empregado empregadoLuckow = criarEmpregadoLuckow();
        Empregado empregadoMelo = criarEmpregadoMelo();
        
        // Pedido de Fulano
        Cliente clienteFulano = criarClienteFulano();
        Pedido pedido = new Pedido();
        pedido.setCliente(clienteFulano);
        pedido.setEmpregado(empregadoLuckow);
        pedido.setDescricao("Pedido do Sr Fulano");
        pedido.setDataPedido(new Date(System.currentTimeMillis()));
        pedido.setHoraPedido(new Time(System.currentTimeMillis()));
        Set<Produto> produtos = new HashSet<Produto>();
        pedido.setProduto(produtos);
        produtos.add(livroPeregrino);
        sessao.save(pedido);
        
        // Pedido Beltrano
        Cliente clienteBeltrano = criarClienteBeltrano();
        pedido = new Pedido();
        pedido.setCliente(clienteBeltrano);
        pedido.setEmpregado(empregadoMelo);
        pedido.setDescricao("Pedido do Sr Beltrano");
        pedido.setDataPedido(new Date(System.currentTimeMillis()));
        pedido.setHoraPedido(new Time(System.currentTimeMillis()));
        produtos = new HashSet<Produto>();
        pedido.setProduto(produtos);
        produtos.add(filmeHobbit);
        produtos.add(alimentoMistoQuente);
        sessao.save(pedido);
    }

    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Comercio comercio = new Comercio(sessao);
        Transaction transacao = sessao.beginTransaction();
        comercio.criarPedidos();
        transacao.commit();
        System.out.println("Cadastrou!");
    }
    
}
