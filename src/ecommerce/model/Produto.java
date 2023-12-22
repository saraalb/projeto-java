package ecommerce.model;

import ecommerce.util.Cores;

public abstract class Produto {
	private int codigo;
	private String nome;
	private int categoria;
	private float valor;
	
	
	
	public Produto(int codigo, String nome, int categoria, float valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
	}
	
	public Produto() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void visualizar() {
		//tipo de produto
			String tipo = "";
			switch(this.categoria) {
			case 1:
				tipo = "Laptop";
				break;
			case 2:
				tipo = "Acessórios";
				break;
			}
				
		System.out.println(Cores.TEXT_CYAN_BOLD +"\n----------------------------"+Cores.RESET);
	    System.out.println("E-commerce:");
	    System.out.println(Cores.TEXT_CYAN_BOLD +"----------------------------"+Cores.RESET);
	    System.out.printf("Código do produto: "+ this.codigo);
	    System.out.printf("\nNome: "+ this.nome);
	    System.out.printf("\nCategoria: "+ tipo);
	    System.out.printf("\nValor: R$ %.2f", this.valor);
	    System.out.println(Cores.TEXT_CYAN_BOLD+"\n----------------------------\n"+Cores.RESET);
	}
	
}
