package br.com.poli.badMemory.players;

public class Pessoa {
public String nome;
	
	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "O nome do jogador é "+nome;
	}
}
