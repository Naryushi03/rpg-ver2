import java.util.Random;

public class Rpg{
    int passos = 0, tentativa;
    boolean dentro = false, emBatalha = false, vivo = true;
		
    public void dungeon(){
        System.out.println("\nEntrou em uma dungeon\n");
        dentro = true;
    }
    
    public void andar(Monstro monstro){
        passos += aleatorio();
        System.out.println("\nAndou "+passos+" passos\n");
        if (passos >= 6){
            passos = 0;
            System.out.println("\nEncontrou um monstro\n");
            emBatalha = true;
            monstro.slime();
        } else {
            System.out.println("\nNão encontrou nada, tente novamente\n");
        }
    }
    
    public int aleatorio(){
        Random random = new Random();
        return random.nextInt(10);
    }

    public void pessoaAtaca(Pessoa pessoa, Monstro monstro){
        //melhorar pra próxima atividade
        System.out.println("\nDeu "+pessoa.forca+" de dano\n");
        monstro.vida -= pessoa.forca;

        if (monstro.vida <= 0){
            System.out.println("Você matou o "+monstro.nome+"\n");
            emBatalha = false;
        } else {
            monstroAtaca(pessoa, monstro);
            System.out.print("Vida do monstro = "+monstro.vida+"\n");
        }
    }

    public void monstroAtaca(Pessoa pessoa, Monstro monstro){
        //melhorar pra próxima atividade
        System.out.println("\nMonstro deu "+monstro.forca+" de dano em você\n");
        pessoa.vida -= monstro.forca;
        System.out.print("Vida restante = "+pessoa.vida+"\n\n");

        if (pessoa.vida <= 0){
            System.out.println(pessoa.nome+" morreu para "+monstro.nome+"\n");
            vivo = false;
        }
    }

    public void fugir(Pessoa pessoa, Monstro monstro){
        if (pessoa.nivel > monstro.nivel * 2){
            System.out.println("\nVocê fugiu com facilidade\n");
            emBatalha = false;
        } else if (pessoa.nivel < monstro.nivel){
             tentativa = aleatorio();
             if (tentativa >= 8){
                System.out.println("\nVocê conseguiu fugir com sorte\n");
                emBatalha = false;
             } else {
                System.out.println("\nNão conseguiu fugir\n");
                monstroAtaca(pessoa, monstro);
             }
        } else {
            tentativa = aleatorio();
            if (tentativa >= 6){
                System.out.println("\nVocê conseguiu fugir\n");
                emBatalha = false;
             } else {
                System.out.println("\nNão conseguiu fugir\n");
                monstroAtaca(pessoa, monstro);
             }
        }
    }
}