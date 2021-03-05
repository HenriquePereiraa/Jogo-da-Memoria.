package projeto_lpoo;

import java.util.Scanner;

public class Partida {
	
	private Scanner scan = new Scanner(System.in);
	private Tabuleiro tabuleiro = new Tabuleiro(4);
	
	private Jogador player1;
	private Jogador player2;
	private int jogadorAtualControle = 1;
	private int numeroJogadas = 1;
	
	public void fazerJogada(int x, int y)
	{
		
	}
	
	public boolean validarJogada(int linha, int coluna)
	{
		boolean isCorrect = false; 
		while(!isCorrect)
		{
			if((linha>=0&&linha<=3) && (coluna>=0 && coluna<=3))
			{
				isCorrect = true;
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	
	public void fazerPartida()
	{
		int linha = 0, coluna = 0;
		
		while(numeroJogadas < 3)
		{
			System.out.println("Jogador " + jogadorAtualControle + " indique a posição da jogada " + numeroJogadas);
			linha = scan.nextInt();
			coluna = scan.nextInt();
			if(validarJogada(linha, coluna))
			{
				
			} else {
				System.out.println("Valor fora do tabuleiro, jogue novamente!");
				linha = scan.nextInt();
				coluna = scan.nextInt();
				while(!validarJogada(linha, coluna))
				{
					System.out.println("Valor fora do tabuleiro, jogue novamente!");
					linha = scan.nextInt();
					coluna = scan.nextInt();
				}
			}
			
			System.out.println("Jogador " + jogadorAtualControle + " jogou, X: " + linha + " Y: " + coluna);
			numeroJogadas++;
		}	
		
		jogadorAtualControle++;
		numeroJogadas = 1;
		if(jogadorAtualControle == 3)
		{
			jogadorAtualControle = 1;
		}
			
	}
}
