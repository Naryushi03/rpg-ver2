import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    
	    int escolha = 0;
	    
	    Scanner entrada = new Scanner(System.in);
	    Pessoa pessoa = new Pessoa();
	    Monstro monstro = new Monstro();
	    Rpg rpg = new Rpg();
	    
	    System.out.println("Digite seu nome: ");
		pessoa.nome = entrada.nextLine();
		System.out.println("Digite sua idade: ");
		pessoa.idade = entrada.nextInt();
		
		entrada.nextLine();

		while (escolha != 7 && rpg.vivo) {
		    escolha = pessoa.acao(rpg, entrada);
		    
		    switch (escolha){
            case 1:
                pessoa.status();
				break;
            case 2:
				if (rpg.dentro){
					System.out.println("\nVocê já está em um dungeon. Tente outra ação\n");
					break;
				} else {
                	rpg.dungeon();
					break;
				}
            case 3:
				if (rpg.dentro && rpg.emBatalha == false) {
					rpg.andar(monstro);
					break;
				} else {
					System.out.println("\nVocê não está em condições de sair da dungeon.\n");
					break;
				}
			case 4:
				if (rpg.emBatalha) {
					rpg.pessoaAtaca(pessoa, monstro);
					break;
				} else {
					System.out.println("\nVocê não está em uma batalha. Tente novamente\n");
					break;
				}
			case 5:
				if (rpg.emBatalha){
					rpg.fugir(pessoa, monstro);
					break;
				} else {
					System.out.println("\nVocê não está em uma batalha. Tente novamente\n");
					break;
				}
            case 6:
				if (rpg.dentro && rpg.emBatalha == false) {
					rpg.dentro = false;
					System.out.println("\nVocê saiu da dungeon.\n");
					break;
				} else {
					System.out.println("\nVocê não está em condições de sair da dungeon.\n");
					break;
				}
			case 7:
				System.out.println("Saiu do jogo");
				break;
			default:
				System.out.println("\nEscolha inválida. Tente novamente\n");
				break;
        	}
		}
	}
}
