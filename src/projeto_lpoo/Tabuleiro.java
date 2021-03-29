package projeto_lpoo;

import java.util.Random;

public class Tabuleiro {
	
		private String[][] tabuleiro;
		
		public Tabuleiro(int tamanho)
		{
			this.tabuleiro = new String[tamanho][tamanho];
			this.preencherTabuleiro();
		}
		
		public void fazerJogada(int x, int y)
		{
	
		}
		
		
		public void preencherTabuleiro()
		{
			Random random = new Random();
			String[] pecas = {"A","B","C","D","E","F","G","H"};
			String peca;

			for(int i = 0; i < this.tabuleiro.length; i++)
			{
				for(int j = 0; j < this.tabuleiro.length; j++)
				{	
					peca = pecas[random.nextInt(8)];
									
					if(this.tabuleiro[i][j] == null && pecasRepitidas(peca) < 2)
					{
						this.tabuleiro[i][j] = peca;
					}
				}	
			}
			
			for(int i = 0; i < this.tabuleiro.length; i++)
			{
				for(int j = 0; j < this.tabuleiro.length; j++)
				{
					if(this.tabuleiro[i][j] == null)
					{
						this.tabuleiro[i][j] = pecaValida();
					}
				}
			}
		}
		
		public int pecasRepitidas(String peca)
		{
			int count = 0;
			
			for(int i = 0; i < this.tabuleiro.length; i++)
			{
				for(int j = 0; j < this.tabuleiro.length; j++)
				{
					if(this.tabuleiro[i][j] == peca )
					{
						
						count++;
					}
				}
			}
			
			return count;
		}
		
		public String pecaValida()
		{
			String[] pecas = {"A","B","C","D","E","F","G","H"};
			
			for(int i = 0; i < this.tabuleiro.length; i++)
			{
				for(int j = 0; j < this.tabuleiro.length; j++)
				{
					if(this.tabuleiro[i][j] != null)
					{
						continue;
					} else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[0]) < 2)
					{
						return pecas[0];
					}  else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[1]) < 2)
					{
						return pecas[1];
					}  else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[2]) < 2)
					{
						return pecas[2];
					}  else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[3]) < 2)
					{
						return pecas[3];
					}  else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[4]) < 2)
					{
						return pecas[4];
					}  else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[5]) < 2)
					{
						return pecas[5];
					}  else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[6]) < 2)
					{
						return pecas[6];
					}  else if(this.tabuleiro[i][j] == null && pecasRepitidas(pecas[7]) < 2)
					{
						return pecas[7];
					}
				}
			}
			return "";
		}
		
		
		
		public void printTabuleiro()
		{
			for(int i = 0; i < this.tabuleiro.length; i++)
			{
				for(int j = 0; j < this.tabuleiro.length; j++)
				{
					System.out.print("|" + this.tabuleiro[i][j] + "|");
				}
				System.out.println("\n");
				
			}
		}
		
}
