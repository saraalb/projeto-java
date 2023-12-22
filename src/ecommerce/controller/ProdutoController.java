package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Produto;
import ecommerce.pedido.Pedido;

public class ProdutoController implements Pedido {
	private ArrayList<Produto> listarProdutos = new ArrayList<Produto>();
	int codigo = 0;
	
	@Override
	public void procurarProduto(int codigo) {
		var produto = buscarNaCollection(codigo);
		
		if(produto != null) produto.visualizar();
		else System.out.println("O produto de código: "+codigo+" não foi encontrado!");

	}
	
	@Override
	public void listarProdutos() {
		if (!listarProdutos.isEmpty()) {
			for (var p: listarProdutos) {
				p.visualizar();
			} 
		} else {
			System.out.println("Não há produtos a serem exibidos.");
		}
	}
	
	@Override
	public void cadastrar(Produto produto) {
		listarProdutos.add(produto);
		System.out.println("O produto "+ produto.getNome() + " foi criado com sucesso!");
		
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getCodigo());
		
		if (buscaProduto != null) {
	        int index = listarProdutos.indexOf(buscaProduto);
	        System.out.println("Índice do produto na lista: " + index);
	        
	        listarProdutos.set(index, produto);
	        System.out.println("\nO produto foi atualizado com sucesso!");
	    } else {
	        System.out.println("\\nO produto não foi encontrado!");
	    }
		
	}
	
	@Override
	public void deletar(int codigo) {
		var produto = buscarNaCollection(codigo);
		boolean removido = listarProdutos.remove(produto);
		
        if (removido) {
            System.out.println("\nO produto de código " + produto.getCodigo() + " foi deletado com sucesso!");
        } else if (!removido) {
        	System.out.println("\nO produto de código " + produto.getCodigo() +" nao foi encontrado!");
    }
}
	
	public int gerarCodigo() {
		return ++codigo;
	}
	
	public Produto buscarNaCollection(int codigo) {
		for (var produto: listarProdutos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}
}
