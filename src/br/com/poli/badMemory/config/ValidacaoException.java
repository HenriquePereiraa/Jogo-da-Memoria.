package br.com.poli.badMemory.config;

public class ValidacaoException extends Exception {
	
	private int linha;
	private int coluna;
	
	public ValidacaoException(int linha_, int coluna_)
	{
		super();
		this.linha = linha_;
		this.coluna = coluna_;
	}
}
