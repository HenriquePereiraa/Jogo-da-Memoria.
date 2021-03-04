package projeto_lpoo;

import java.util.Scanner;

public class Partida {
	
	public Tabuleiro tabuleiro = new Tabuleiro(4);
	Scanner scan = new Scanner(System.in);
	int jogadorVez = 1;
	
	public void fazerJogada(int x, int y)
	{
		
	}
	
	
	public void fazerPartida()
	{
		int linha = 0, coluna = 0;
		boolean isCorrect = false; 
		
		System.out.println("Vez do jogador " + jogadorVez + " indique a posição das pesças:");
		
		while(!isCorrect)
		{
			linha = scan.nextInt();
			coluna = scan.nextInt();
			if((linha>=0&&linha<=3) && (coluna>=0 && coluna<=3))
			{
				isCorrect = true;
			} else {
				System.out.println("Valor maior que o tabuleiro, jogue novamente!");
			}
		}
		
		System.out.println("Jogador " + jogadorVez + " jogou, X: " + linha + " Y: " + coluna);
		
		jogadorVez++;
		if(jogadorVez == 3)
		{
			jogadorVez = 1;
		}
		
		
	}
}
