package ecommerce.model;

public class Acessorios extends Produto {
	private String nomeSubcategoria;


	public Acessorios(int codigo, String nome, int categoria, float valor, String nomeSubcategoria) {
		super(codigo, nome, categoria, valor);
		this.nomeSubcategoria = nomeSubcategoria;
	}
	
	public Acessorios() {
		
	}


	public String getNomeSubcategoria() {
		return nomeSubcategoria;
	}

	public void setNomeSubcategoria(String nomeSubcategoria) {
		this.nomeSubcategoria = nomeSubcategoria;
	}
	
	public void visualizar() {
		super.visualizar();
		if (!nomeSubcategoria.isEmpty()) {
			System.out.println("Parabéns! Você acabou de adquirir um produto da categoria: " + this.nomeSubcategoria);
		}
	}
	
	

}
