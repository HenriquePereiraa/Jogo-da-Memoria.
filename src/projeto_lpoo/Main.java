package projeto_lpoo;

public class Main {

	public static void main(String[] args) {
		
		Partida start = new Partida();
		Jogador player1 = new Jogador("Player1");
		Jogador player2 = new Jogador("Player2");

		
		for(int i = 0; i < 6; i++)
		{
			start.fazerPartida();
		}
		

	}

}
