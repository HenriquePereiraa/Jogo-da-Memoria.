package br.com.poli.badMemory;

import br.com.poli.badMemory.players.Jogador;

public class Partida {
	
	private Tabuleiro tabuleiro;
	private Jogador jogador1;
	private Jogador jogador2;
	private int jogadorAtualControle = 1;
	private int numeroJogadas = 1;
	private int tam;
	private String[][] pecaRevelada;
	
	private int linha = 0, coluna = 0;
	private int numeroJogadasUser = 1;
	private String peca1 = "";
	private String peca2 = "";
	private int linhaInformada = 0, colunaInformada = 0;

	public Partida(Jogador player1, Jogador player2, int dificuldade)
	{
		this.jogador1 = player1;
		this.jogador2 = player2;
		this.tabuleiro = new Tabuleiro(dificuldade);
		this.tam = this.tabuleiro.getTabuleiro().length;
		this.pecaRevelada = new String[tam][tam];
	}
	
	public boolean validarJogada(int linha, int coluna)
	{
		boolean isCorrect = false; 
		while(!isCorrect)
		{
			if(((linha>=0&&linha<tam) && (coluna>=0 && coluna<tam)) && (this.tabuleiro.getTabuleiro()[linha][coluna] != pecaRevelada[linha][coluna]))
			{
				isCorrect = true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void fazerJogada(int x, int y)
	{
			linha = x;
			coluna = y;
			
			for(int i = 0; i < this.tabuleiro.getTabuleiro().length; i++)
			{
				for(int  j= 0; j < this.tabuleiro.getTabuleiro().length; j++)
				{
					if(this.tabuleiro.getTabuleiro()[i][j] == this.getPecaRevelada()[i][j])//imprime os pares revelados
					{
						System.out.print("|"+this.getPecaRevelada()[i][j]+" |");
					}else if((i == this.getLinhaInformada() && j == this.getColunaInformada()) && this.getNumeroJogadasUser() == 2)
					{//imprime a primeira pe�a revelada na jogada do player
						System.out.print("|"+this.tabuleiro.getTabuleiro()[this.getLinhaInformada()][this.getColunaInformada()]+" |");
					} else if(i == linha && j == coluna)//confere se as posi��es s�o iguais para poder poder imprimir a matriz com a pe�a revelada na determinada posi��o
					{	
						if(this.getNumeroJogadasUser() == 1 && this.getNumeroJogadas() == 1)//verifica se � a primeira jogada do player
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							this.setLinhaInformada(linha);//pegar a posi��o da primeira jogada
							this.setColunaInformada(coluna);//pegar posi��o da primeira jogada
							numeroJogadasUser++;
							//this.setNumeroJogadasUser(1);//++;
							this.setPeca1(this.tabuleiro.getTabuleiro()[linha][coluna]);//pegando peca para verificar se forma par com a segunda
						} else if(this.getNumeroJogadasUser() == 2 && this.getNumeroJogadas() == 2)//verifica se � a segunda jogada do player
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							this.setPeca2(this.tabuleiro.getTabuleiro()[linha][coluna]);//pegando peca para verificar se forma par com a primeira
							
							if(this.tabuleiro.getTabuleiro()[this.getLinhaInformada()][this.getColunaInformada()] == this.tabuleiro.getTabuleiro()[i][j])
							{
								pecaRevelada[this.getLinhaInformada()][this.getColunaInformada()] = this.tabuleiro.getTabuleiro()[this.getLinhaInformada()][this.getColunaInformada()];
								pecaRevelada[linha][coluna] = this.tabuleiro.getTabuleiro()[linha][coluna];
								
							}
						}
						
					} else {
						System.out.print("|  |");
					}
				}
				System.out.print("\n");
			}
			
			if(this.getJogadorAtualControle() == 1)
			{
				System.out.println("Jogador " + jogador1.getNome() + " jogou, X: " + linha + " Y: " + coluna);
			} else {
				System.out.println("Jogador " + jogador2.getNome() + " jogou, X: " + linha + " Y: " + coluna);
			}
			
			if(tabuleiro.fazerJogada(this.getPeca1(), this.getPeca2()) && this.getNumeroJogadas() >= 2)
			{//verificar se o jogador acertou os pares e poder continuar jogando
				//E atribuir pontua��o
				
				numeroJogadas--;
				numeroJogadasUser--;
				if(jogador1.getIdentPlayer() == this.getJogadorAtualControle())
				{
					jogador1.setScore(1);
				} else if(jogador2.getIdentPlayer() == this.getJogadorAtualControle())
				{
					jogador2.setScore(1);
				}
			} else {
				numeroJogadas++;
			}
	}
	
	public void ControleDeJogadas()
	{	
		//so pode chegar aqui depois que for jogado duas pe�as 
		//this.setNumeroJogadasUser(1);// = 1;
		numeroJogadasUser = 1;
		jogadorAtualControle++;
		numeroJogadas = 1;
		if(this.getJogadorAtualControle() == 3)
		{
			jogadorAtualControle = 1;
		}
	}
	
	public boolean verificarFimJogo()
	{
		for(int i = 0; i < this.tabuleiro.getTabuleiro().length; i++)
		{
			for(int j = 0; j < this.tabuleiro.getTabuleiro().length; j++)
			{
				if(this.pecaRevelada[i][j] == null)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public int getNumeroJogadas() {
		return numeroJogadas;
	}
	public Jogador getJogador1() {
		return jogador1;
	}
	public Jogador getJogador2() {
		return jogador2;
	}
	public int getJogadorAtualControle() {
		return jogadorAtualControle;
	}
	
	public String[][] getPecaRevelada() {
		return pecaRevelada;
	}
	
	public int getColunaInformada() {
		return colunaInformada;
	}
	
	public int getNumeroJogadasUser() {
		return numeroJogadasUser;
	}

	public String getPeca1() {
		return peca1;
	}

	public String getPeca2() {
		return peca2;
	}
	
	public int getLinhaInformada() {
		return linhaInformada;
	}

	public void setPeca1(String peca1) {
		this.peca1 = peca1;
	}

	public void setPeca2(String peca2) {
		this.peca2 = peca2;
	}
	
	public void setLinhaInformada(int linhaInformada) {
		this.linhaInformada = linhaInformada;
	}
	
	public void setColunaInformada(int colunaInformada) {
		this.colunaInformada = colunaInformada;
	}
	
}















