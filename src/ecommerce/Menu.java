package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

import ecommerce.model.Acessorios;
import ecommerce.model.Laptop;
import ecommerce.model.Produto;
import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		int opcao =0;
		Scanner leia = new Scanner(System.in);
		
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
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "             6 - Repor produto                        " + Cores.RESET);
        System.out.println(Cores.ANSI_BLACK_BACKGROUND +Cores.TEXT_CYAN_BOLD +  "             7 - Sair                                 " + Cores.RESET);
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

		if (opcao == 7) {
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nObrigado"+ Cores.RESET);
            leia.close();
			System.exit(0);
		}

		switch (opcao) {
		case 1:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nCadastrar produto"+ Cores.RESET);

			keyPress();
			break;
		case 2:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nListar todos os produtos"+ Cores.RESET);

			keyPress();
			break;
		case 3:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nBuscar produto"+ Cores.RESET);

			keyPress();
			break;
		case 4:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nAtualizar produto"+ Cores.RESET);

			keyPress();
			break;
		case 5:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nApagar produto"+ Cores.RESET);

			keyPress();
			break;
		case 6:
			System.out.println(Cores.TEXT_CYAN_BOLD +"\nRepor produto"+ Cores.RESET);

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

		System.out.println( "\n\nPressione Enter para continuar ou 7 para finalizar");
		System.in.read();

	} catch (IOException e) {

		System.out.println("Você pressionou uma tecla diferente de enter!");

	}
}
}