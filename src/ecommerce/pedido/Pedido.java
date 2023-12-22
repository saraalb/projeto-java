package ecommerce.pedido;

import ecommerce.model.Produto;

public interface Pedido {
	
	//Metodos CRUD
	public void procurarProduto(int codigo);
	public void listarProdutos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int codigo);
}
