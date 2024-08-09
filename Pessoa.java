import java.util.Scanner;

public class Pessoa{
    String nome;
    int idade, nivel = 1;
    float forca = 3, vida = 8;
    
    Scanner entrada = new Scanner(System.in);
    
    public int acao(Rpg rpg, Scanner entrada){
        
        System.out.println("Escolha sua ação: \n"+
        "[ 1 ] Mostar Status\n"+
        "[ 2 ] Entrar Dungeon");

        if (rpg.dentro){
        System.out.println("[ 3 ] Andar\n"+"[ 4 ] Atacar\n"+"[ 5 ] Fugir\n"+
        "[ 6 ] Sair da Dungeon\n"+"[ 7 ] Sair do jogo\n");
        }
        return entrada.nextInt();
	}
	
    public void status(){
        System.out.println("\nNome: "+nome+"\nIdade: "+idade+"\n\nNivel: "+nivel+"\nVida: "+vida+"\nForça: "+forca+"\n");
    }
}