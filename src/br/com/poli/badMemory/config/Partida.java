package br.com.poli.badMemory.config;
import java.util.Random;
import br.com.poli.badMemory.players.Jogador;

public class Partida {
	
	private Tabuleiro tabuleiro;
	private Jogador jogador1;
	private Jogador jogador2;
	private int jogadorAtualControle = 1;
	private int numeroJogadas = 1;
	private int tamanhoTabuleiro;
	private String[][] pecaRevelada;
	private String[][] memorioIA;
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
		this.tamanhoTabuleiro = this.tabuleiro.getTabuleiro().length;
		this.pecaRevelada = new String[tamanhoTabuleiro][tamanhoTabuleiro];
		this.memorioIA = new String[tamanhoTabuleiro][tamanhoTabuleiro];
	}
	
	public boolean validarJogada(int linha, int coluna)
	{
		boolean isCorrect = false; 
		
		while(!isCorrect)
		{
			try
			{
				if(!((linha>=0&&linha<tamanhoTabuleiro) && (coluna>=0 && coluna<tamanhoTabuleiro)) && (this.tabuleiro.getTabuleiro()[linha][coluna] != pecaRevelada[linha][coluna]))
				{
					throw new ValidacaoException(linha,coluna);
				}
				isCorrect = true;
			}catch(Exception e)
			{
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
					if(this.tabuleiro.getTabuleiro()[i][j] == this.getPecaRevelada()[i][j])
					{
						System.out.print("|"+this.getPecaRevelada()[i][j]+" |");
					}else if((i == this.getLinhaInformada() && j == this.getColunaInformada()) && this.getNumeroJogadasUser() == 2)
					{
						System.out.print("|"+this.tabuleiro.getTabuleiro()[this.getLinhaInformada()][this.getColunaInformada()]+" |");
					} else if(i == linha && j == coluna)
					{	
						if(this.getNumeroJogadasUser() == 1 && this.getNumeroJogadas() == 1)
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							this.setLinhaInformada(linha);
							this.setColunaInformada(coluna);
							numeroJogadasUser++;
							this.setPeca1(this.tabuleiro.getTabuleiro()[linha][coluna]);
						} else if(this.getNumeroJogadasUser() == 2 && this.getNumeroJogadas() == 2)
						{
							System.out.print("|"+this.tabuleiro.getTabuleiro()[i][j]+" |");
							this.setPeca2(this.tabuleiro.getTabuleiro()[linha][coluna]);
							
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
			
			if(tabuleiro.fazerJogada(this.getPeca1(), this.getPeca2()) && this.getNumeroJogadas() >= 2)
			{
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
	
	
	public void memoriaCPU(int linha, int coluna)
	{
		for(int i = 0; i<this.tabuleiro.getTabuleiro().length; i++)
		{
			for(int j = 0; j<this.tabuleiro.getTabuleiro().length; j++)
			{
				if(i == linha && j == coluna)
				{
					memorioIA[linha][coluna] = this.tabuleiro.getTabuleiro()[linha][coluna];
				}
			}
		}
	}
	
	public int[] pegarPecaMemoria(int linha, int coluna)
	{
		int[] pecas = new int[2];
		Random random = new Random();
		
		for(int i = 0; i<this.tabuleiro.getTabuleiro().length; i++)
		{
			for(int j = 0; j<this.tabuleiro.getTabuleiro().length; j++)
			{
				if(this.memorioIA[i][j] == this.memorioIA[linha][coluna] && (i != linha && j != coluna))
				{
					pecas[0] = i;
					pecas[1] = j;
					return pecas;
				} else {
					pecas[0] = random.nextInt(this.tabuleiro.getTabuleiro().length);
					pecas[1] = random.nextInt(this.tabuleiro.getTabuleiro().length);
				}
			}
		}
		return pecas;
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

	public String[][] getMemorioIA() {
		return memorioIA;
	}
}

