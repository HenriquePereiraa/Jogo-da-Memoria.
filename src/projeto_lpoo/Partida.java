package projeto_lpoo;

import java.util.Scanner;



public class Partida {
	
	private Scanner scan = new Scanner(System.in);
	private Tabuleiro tabuleiro = new Tabuleiro(4);
	
	private Jogador jogador1 = new Jogador("Henrique",1);
	private Jogador jogador2 = new Jogador("Ronaldo",2);
	private int jogadorAtualControle = 1;
	private int numeroJogadas = 1;
	private int tam = this.tabuleiro.getTabuleiro().length;
	private String[][] pecaRevelada = new String[tam][tam];
	
	public void fazerJogada(int x, int y)
	{
		
		
	}
	
	public boolean validarJogada(int linha, int coluna)
	{
		boolean isCorrect = false; 
		while(!isCorrect)
		{
			if(((linha>=0&&linha<=tam) && (coluna>=0 && coluna<=tam)) && (this.tabuleiro.getTabuleiro()[linha][coluna] != pecaRevelada[linha][coluna]))
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
		int numeroJogadasUser = 1;
		int posicao = 0;
		String peca1 = "";
		String peca2 = "";
		int linhaInformada = 0, colunaInformada = 0;
		
		while(numeroJogadas < 3)
		{
			if(jogadorAtualControle == 1)
			{
				System.out.println("Jogador " + jogador1.getIdentPlayer() + ", " + jogador1.getNome() + ", pontua��o " + jogador1.getScore() + " indique a posi��o da jogada " + numeroJogadas);
			} else {
				System.out.println("Jogador " + jogador2.getIdentPlayer() + ", " + jogador2.getNome() + ", pontua��o " + jogador2.getScore() + " indique a posi��o da jogada " + numeroJogadas);
			}
			linha = scan.nextInt();
			coluna = scan.nextInt();
			if(validarJogada(linha, coluna))
			{
				
			} else {
				System.out.println("Valor inv�lido, jogue novamente!");
				linha = scan.nextInt();
				coluna = scan.nextInt();
				while(!validarJogada(linha, coluna))
				{
					System.out.println("Valor inv�lido, jogue novamente!");
					linha = scan.nextInt();
					coluna = scan.nextInt();
				}
			}
			
			for(int i = 0; i < this.tabuleiro.getTabuleiro().length; i++)
			{
				for(int  j= 0; j < this.tabuleiro.getTabuleiro().length; j++)
				{
					if(this.tabuleiro.getTabuleiro()[i][j] == pecaRevelada[i][j])//imprime os pares revelados
					{
						System.out.print("|"+pecaRevelada[i][j]+" |");
					}else if((i == linhaInformada && j == colunaInformada) && numeroJogadasUser == 2)
					{//imprime a primeira pe�a revelada na jogada do player
						System.out.print("|"+this.tabuleiro.getTabuleiro()[linhaInformada][colunaInformada]+" |");
					} else if(i == linha && j == coluna)//confere se as posi��es s�o iguais para poder poder imprimir a matriz com a pe�a revelada na determinada posi��o
					{	
						if(numeroJogadasUser == 1 && numeroJogadas == 1)//verifica se � a primeira jogada do player
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							linhaInformada = linha;//pegar a posi��o da primeira jogada
							colunaInformada = coluna;//pegar posi��o da primeira jogada
							numeroJogadasUser++;
							peca1 = this.tabuleiro.getTabuleiro()[linha][coluna];//pegando peca para verificar se forma par com a segunda
						} else if(numeroJogadasUser == 2 && numeroJogadas == 2)//verifica se � a segunda jogada do player
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							peca2 = this.tabuleiro.getTabuleiro()[linha][coluna];//pegando peca para verificar se forma par com a primeira
							
							if(this.tabuleiro.getTabuleiro()[linhaInformada][colunaInformada] == this.tabuleiro.getTabuleiro()[i][j])
							{
								pecaRevelada[linhaInformada][colunaInformada] = this.tabuleiro.getTabuleiro()[linhaInformada][colunaInformada];
								pecaRevelada[linha][coluna] = this.tabuleiro.getTabuleiro()[linha][coluna];
							}
						}
						
					} else {
						System.out.print("|  |");
					}
				}
				System.out.print("\n");
			}
			
			if(jogadorAtualControle == 1)
			{
				System.out.println("Jogador " + jogador1.getNome() + " jogou, X: " + linha + " Y: " + coluna);
			} else {
				System.out.println("Jogador " + jogador2.getNome() + " jogou, X: " + linha + " Y: " + coluna);
			}
			
	
			if(tabuleiro.fazerJogada(peca1, peca2) && numeroJogadas >=2)
			{
				numeroJogadas--;
				numeroJogadasUser--;
				if(jogador1.getIdentPlayer() == jogadorAtualControle)
				{
					jogador1.setScore(1);
				} else if(jogador2.getIdentPlayer() == jogadorAtualControle)
				{
					jogador2.setScore(1);
				}
			} else {
				numeroJogadas++;
			}
		}	
		numeroJogadasUser = 1;
		jogadorAtualControle++;
		numeroJogadas = 1;
		if(jogadorAtualControle == 3)
		{
			jogadorAtualControle = 1;
		}
	}
}
















