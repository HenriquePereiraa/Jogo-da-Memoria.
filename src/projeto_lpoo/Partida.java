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
		int numeroJogadasUser = 1;
		String peca1 = "";
		String peca2 = "";
		int linhaInformada = 0, colunaInformada = 0;
		
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
			
			for(int i = 0; i < this.tabuleiro.getTabuleiro().length; i++)
			{
				for(int  j= 0; j < this.tabuleiro.getTabuleiro().length; j++)
				{
					if((i == linhaInformada && j == colunaInformada) && numeroJogadasUser == 2)
					{//imprime a primeira peça revelada na jogada do player
						System.out.print("|"+this.tabuleiro.getTabuleiro()[linhaInformada][colunaInformada]+" |");
					} else if(i == linha && j == coluna)//confere se se as posições são iguais para poder poder imprimir a matriz com a peça revelada na determinada posição
					{
						if(numeroJogadasUser == 1 && numeroJogadas == 1)//verifica se é a primeira jogada do user
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							linhaInformada = linha;//pegar a posição
							colunaInformada = coluna;//pegar posição da primeira jogada
							numeroJogadasUser++;
							peca1 = this.tabuleiro.getTabuleiro()[linha][coluna];//pegando peca para verificar se forma par com a segunda
						} else if(numeroJogadasUser == 2 && numeroJogadas == 2)//verifica se é a segunda jogada do user
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							peca2 = this.tabuleiro.getTabuleiro()[linha][coluna];//pegando peca para verificar se forma par com a primeira
						}
						
					} else {
						System.out.print("|  |");
					}
				}
				System.out.print("\n");
			}
			
			System.out.println("Jogador " + jogadorAtualControle + " jogou, X: " + linha + " Y: " + coluna);
			numeroJogadas++;
			
			if(tabuleiro.fazerJogada(peca1, peca2) && numeroJogadas >= 2)
			{
				numeroJogadas--;
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
