package br.com.poli.badMemory.config;
import java.util.Random;

public class Tabuleiro {
	
		private String[][] tabuleiro;
		private String[] pecas;
		

		public Tabuleiro(int tamanho)
		{
			this.tabuleiro = new String[tamanho][tamanho];
			this.preencher();
		}
		
	
		public boolean fazerJogada(String x, String y)
		{
			if(x.equals(y))
			{
				return true;
			} else {
				return false;
			}
		}
		
		Random random = new Random();
		int linha = 0;
		int coluna = 0;
		
		public String[][] getTabuleiro() {
			return this.tabuleiro;
		}
		
		
		public void preencher()
		{
			boolean cheio = false;
			boolean sbCheio = false;
			int count = 0;
			int index = 0;
			
			if(this.tabuleiro.length == 4)
			{
				pecas = new String[] {"A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H"};
				index = 4;
			} else if(this.tabuleiro.length == 6)
			{
				pecas = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R"};
				index = 6;
			}  else if(this.tabuleiro.length == 8)
			{
			pecas = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","$","&","#","@","%","*","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","$","&","#","@","%","*"};
				index = 8;
			}
			
			while(!cheio)
			{
				int linha = random.nextInt(index);
				int coluna = random.nextInt(index);
				if(tabuleiro[linha][coluna] == null)
				{
					tabuleiro[linha][coluna] = pecas[count];
				} else {
					do
					{
						linha = random.nextInt(index);
						coluna = random.nextInt(index);
						if(tabuleiro[linha][coluna] == null)
						{
							sbCheio = true;
						}
						
					}while(!sbCheio);
					tabuleiro[linha][coluna] = pecas[count];
					sbCheio = false;
				}
				cheio = tbCheio();
				if(cheio == false)
				{
					count++;
				}
			}
		}
		
		public boolean tbCheio()
		{
			for(int i = 0; i < this.tabuleiro.length; i++)
			{
				for(int j = 0; j < this.tabuleiro.length; j++)
				{
					if(this.tabuleiro[i][j] == null)
					{
						return false;
					}
				}
			}
			
			return true;
		}
		
		public void showTb()
		{
			for(int i = 0; i < this.tabuleiro.length; i++)
			{
				for(int j = 0; j < this.tabuleiro.length; j++)
				{
					System.out.print("| " + " |");
				}
				System.out.println();
			}	
		}
}
