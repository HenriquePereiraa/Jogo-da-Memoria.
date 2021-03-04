package projeto_lpoo;

public class Tabuleiro {
	//-- A classe Tabuleiro deve conter um atributo do tipo array bidimensional de Strings
		//-- No construtor da classe Tabuleiro inicialize o array bidimensional com tamanho 4 x 4
		
		private String[][] tabuleiro;
		
		public Tabuleiro(int tamanho)
		{
			this.tabuleiro = new String[tamanho][tamanho];
		}
		
		public void fazerJogada(int x, int y)
		{
			
		}
}
