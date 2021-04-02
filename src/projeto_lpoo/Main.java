package projeto_lpoo;

public class Main {

	public static void main(String[] args) {
		
		Partida start = new Partida();
		Tabuleiro tb = new Tabuleiro(4);
		Jogador player1 = new Jogador("Player1");
		Jogador player2 = new Jogador("Player2");

		for(int i = 0; i < 20; i++)
		{
			start.fazerPartida();
		}
		
		
		

	}

}
