package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.io.IOException;

import ecommerce.controller.ProdutoController;
import ecommerce.model.Acessorios;
import ecommerce.model.Laptop;
import ecommerce.model.Produto;
import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		int opcao =0;
		int codigo, categoria;
		float valor;
		String nome, tipoOS, nomeSubcategoria;
		Scanner leia = new Scanner(System.in);
		
		ProdutoController produtos = new ProdutoController();
		
		//teste 1
		Produto p1 = new Laptop(123, "Macbook retina", 1, 40000.0f, "iOS");
		p1.visualizar();
		
		//teste 2
		Produto p2 = new Acessorios(45, "Mousepad", 2, 30.0f, "Mouse");
		p2.visualizar();
		

		while (true){
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "******************************************************" + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + "                                                      " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE +"                 ◣  E-COMMERCE  ◥                     " +Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + "                                                      " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "******************************************************" + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "                                                      " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "             1 - Cadastrar produto                    " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "             2 - Listar todos os produtos             " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "             3 - Buscar produto                       " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "             4 - Atualizar produto                    " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "             5 - Apagar produto                       " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "             6 - Sair                                 " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "                                                      " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "******************************************************" + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_WHITE + "Entre com a opção desejada:                           " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD + "                                                      " + Cores.RESET);

		try {
			opcao = leia.nextInt();
		}catch(InputMismatchException e){
			System.out.println("\nDigite valores inteiros!");
			leia.nextLine();
			opcao=0;
		}

		if (opcao == 6) {
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nObrigado"+ Cores.RESET);
            leia.close();
			System.exit(0);
		}

		switch (opcao) {
		case 1:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nCadastrar produto"+ Cores.RESET);
			System.out.println("Digite o código do produto: ");
			codigo = leia.nextInt();
			System.out.println("Digite o nome do produto: ");
			leia.skip("\\R?");
        	nome = leia.nextLine();
        
        	do {
        		System.out.println("Digite a categoria do produto (1 - Laptops ou 2 - Acessórios");
        		categoria = leia.nextInt();
        	} while (categoria<1 && categoria>2);
        	
        	System.out.println("Digite o valor do produto (R$): ");
        	valor = leia.nextFloat();			
        	
        	switch(categoria) {
        	case 1 -> {
        		System.out.println("Digite o modelo de SO"
        				+ "2 que você deseja para o seu Laptop:");
        		leia.skip("\\R?");
        		tipoOS = leia.nextLine();
        		produtos.cadastrar(new Laptop(produtos.gerarCodigo(), nome, categoria, valor, tipoOS));
        	}
        	case 2 -> {
        		System.out.println("Digite o nome da subcategoria do seu produto:");
        		leia.skip("\\R?");
        		nomeSubcategoria = leia.nextLine();
        		produtos.cadastrar(new Acessorios(produtos.gerarCodigo(), nome, categoria, valor, nomeSubcategoria));
        	}
        	}
        	keyPress();
        	break;
		case 2:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nListar todos os produtos"+ Cores.RESET);
			produtos.listarProdutos();
        	keyPress();
        	break;
		case 3:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nBuscar produto - por código:\n\n"+ Cores.RESET);
			
			System.out.println("Digite o código do produto: ");
			codigo = leia.nextInt();
        	produtos.procurarProduto(codigo);

			keyPress();
			break;
		case 4:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nAtualizar produto\n\n"+ Cores.RESET);
			
			System.out.println("Digite o código do produto: ");
			codigo = leia.nextInt();
			
			var buscaProduto = produtos.buscarNaCollection(codigo);
			
			if(buscaProduto != null) {
				categoria = buscaProduto.getCategoria();
				
				System.out.println("Digite o nome do produto:");
				leia.skip("\\R?");
				nome = leia.nextLine();
				System.out.println("Digite o valor do produto:");
				valor = leia.nextFloat();
			
				switch(categoria ) {
        			case 1 -> {
        				System.out.println("Digite o modelo de SO que você deseja para o seu Laptop:");
        				leia.skip("\\R?");
        				tipoOS = leia.nextLine();
        				produtos.cadastrar(new Laptop(produtos.gerarCodigo(), nome, categoria, valor, tipoOS));
        			}
        			case 2 -> {
        				System.out.println("Digite o nome da subcategoria do seu produto:");
        				leia.skip("\\R?");
        				nomeSubcategoria = leia.nextLine();
        				produtos.cadastrar(new Acessorios(produtos.gerarCodigo(), nome, categoria, valor, nomeSubcategoria));
        			}
        				default -> {
        					System.out.println("Opção inválida!");
        			}
        		}
        	} else {
        		System.out.println("A conta não foi encontrada!");
        	}
      
			keyPress();
			break;
		case 5:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nApagar produto"+ Cores.RESET);
			
			System.out.println("Digite o código do produto:");
        	codigo = leia.nextInt();
        	produtos.deletar(codigo);

			keyPress();
			break;
		default:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nOpção inválida. Tente novamente."+ Cores.RESET);
			
			keyPress();
			break;
		}
	}
}

	public static void keyPress() {
	    try {
	        Scanner Scanner = new Scanner(System.in);
	        System.out.println("\n\nPressione Enter para continuar ou 6 para finalizar");
	        
	        // Agora, ao invés de usar System.in.read(), vamos usar scanner.nextLine() para consumir a quebra de linha
	        Scanner.nextLine();
	    } catch (Exception e) {
	        System.out.println("Erro ao aguardar a tecla Enter: " + e.getMessage());
	    }
	}
}