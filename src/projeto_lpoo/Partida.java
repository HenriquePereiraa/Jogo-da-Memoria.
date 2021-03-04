package projeto_lpoo;

import java.util.Scanner;

public class Partida {
	
	public Tabuleiro tabuleiro = new Tabuleiro(4);
	Scanner scan = new Scanner(System.in);
	int jogadorVez = 1;
	int numeroJogadas = 1;
	
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
			System.out.println("Jogador " + jogadorVez + " indique a posição da jogada " + numeroJogadas);
			linha = scan.nextInt();
			coluna = scan.nextInt();
			if(validarJogada(linha, coluna))
			{
				
			} else {
				System.out.println("Valor maior que o tabuleiro, jogue novamente!");
				linha = scan.nextInt();
				coluna = scan.nextInt();
				while(!validarJogada(linha, coluna))
				{
					System.out.println("Valor maior que o tabuleiro, jogue novamente!");
					linha = scan.nextInt();
					coluna = scan.nextInt();
				}
			}
			
			System.out.println("Jogador " + jogadorVez + " jogou, X: " + linha + " Y: " + coluna);
			numeroJogadas++;
		}	
		
		jogadorVez++;
		numeroJogadas = 1;
		if(jogadorVez == 3)
		{
			jogadorVez = 1;
		}
			
	}
}
