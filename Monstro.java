public class Monstro{
    String nome;
    int nivel;
    float vida, forca;
		
    public void slime(){
        nome = "Slime azul";
        nivel = 1;
        vida = 5;
        forca = 2;
        
        System.out.println("Nome: "+nome+"\nNivel: "+nivel+"\nVida: "+vida+"\nforca: "+forca+"\n");
    }
}