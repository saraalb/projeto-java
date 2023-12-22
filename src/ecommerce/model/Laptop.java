package ecommerce.model;

public class Laptop extends Produto {
	private String tipoOS;
	
	
	public Laptop(int codigo, String nome, int categoria, float valor, String tipoOS) {
		super(codigo, nome, categoria, valor);
		this.tipoOS = tipoOS;
	}
	
	public Laptop() {
		
	}
	
	public String getTipoOS() {
		return tipoOS;
	}

	public void setTipoOS(String tipoOS) {
		this.tipoOS = tipoOS;
	}
	
	public void visualizar() {
		super.visualizar();
		if (tipoOS == "iOS") {
			System.out.println("Parabéns! Você acabou de adquirir um MacBook!");
		}
	}


}
