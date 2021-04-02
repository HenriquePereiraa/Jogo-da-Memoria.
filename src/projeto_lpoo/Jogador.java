package projeto_lpoo;

public class Jogador extends Pessoa {
	
private int identPlayer;
	
	private int score;
	
	public Jogador(String nome, int identPlayer) {
		super(nome);
		this.identPlayer = identPlayer;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public int getIdentPlayer() {
		return identPlayer;
	}

	public void setIdentPlayer(int identPlayer) {
		this.identPlayer = identPlayer;
	}

	@Override
	public String toString() {
		return " "+getIdentPlayer()+" - O nome do jogador eh "+getNome();
	}
}
