package br.com.poli.badMemory;

import java.util.Random;
import java.util.Scanner;

import br.com.poli.badMemory.players.Jogador;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		String namePlayerOne;
		String namePlayerTwo;
		int modo = modoJogo();

		if(modo == 2)
		{
			System.out.print("Nome do player 1: ");
			 namePlayerOne = scan.next();
			System.out.print("\nNome do player 2: ");
			 namePlayerTwo = scan.next();
		} else {
			System.out.print("Nome do player 1: ");
			 namePlayerOne = scan.next();
			 namePlayerTwo = "CPU";
		}



		int nivel = nivelDificuldade();
		Tabuleiro tb = new Tabuleiro(nivel);
		Jogador jogadorPlayerOne = new Jogador(namePlayerOne,1);
		Jogador jogadorPlayerTwo = new Jogador(namePlayerTwo,2);
		jogadorPlayerOne.toString();
		jogadorPlayerTwo.toString();
		tb.showTb();


		int linha = 0, coluna = 0;
		int jogadaPlayer = 0;
		int lCpu = 0, cCpu = 0, pecasCpu[];
		boolean encerrarPartida = false;
		Partida partida = new Partida(jogadorPlayerOne, jogadorPlayerTwo, nivel);


		while(!encerrarPartida)
		{
			while(partida.getNumeroJogadas() < 3 && !partida.verificarFimJogo())
			{
				if(partida.getJogadorAtualControle() == 1)
				{
					System.out.println("Jogador " + partida.getJogador1().getIdentPlayer() + ", " + partida.getJogador1().getNome() + ", pontuação " + partida.getJogador1().getScore() + " indique a posição da jogada " + partida.getNumeroJogadas());
				} else {
					System.out.println("Jogador " + partida.getJogador2().getIdentPlayer() + ", " + partida.getJogador2().getNome() + ", pontuação " + partida.getJogador2().getScore() + " indique a posição da jogada " + partida.getNumeroJogadas());
				}

				if(modo == 1)
				{
					if(partida.getJogadorAtualControle() == 2)//vez da cpu
					{
						do
						{
							if(partida.getNumeroJogadas() == 1)//jogada da primeira peça da cpu
							{
								linha = random.nextInt(nivel);
								coluna = random.nextInt(nivel);
								partida.memoriaCPU(linha, coluna);
								if(jogadaPlayer >= 2)
								{
									pecasCpu = partida.pegarPecaMemoria(linha, coluna);
									lCpu = pecasCpu[0];
									cCpu = pecasCpu[1];
								}
							} else if(partida.getNumeroJogadas() == 2 && jogadaPlayer >= 2)//jogada da segunda peça da cpu
							{
								linha = lCpu;
								coluna = cCpu;
								partida.memoriaCPU(linha, coluna);
								if(partida.validarJogada(linha, coluna))
								{
									
								} else {
									while(!partida.validarJogada(linha, coluna))
									{
										linha = random.nextInt(nivel);
										coluna = random.nextInt(nivel);
										partida.memoriaCPU(linha, coluna);
									}
								}
							}
						}while(!partida.validarJogada(linha, coluna));	
					} else {

						linha = scan.nextInt();
						coluna = scan.nextInt();
						jogadaPlayer++;
						partida.memoriaCPU(linha, coluna);//guardando posições na memoria da cpu
					}
				}

				if(modo == 2)
				{
					linha = scan.nextInt();
					coluna = scan.nextInt();
				}

				if(partida.validarJogada(linha, coluna))
				{

				} else {
					System.out.println("Valor inválido, jogue novamente!");
					linha = scan.nextInt();
					coluna = scan.nextInt();
					while(!partida.validarJogada(linha, coluna))
					{
						System.out.println("Valor inválido, jogue novamente!");
						linha = scan.nextInt();
						coluna = scan.nextInt();
					}
				}
				partida.fazerJogada(linha, coluna);
			}
			encerrarPartida = partida.verificarFimJogo();
			partida.ControleDeJogadas();
		}

		System.out.println("\n\n\n\n===================================");
		System.out.println("Fiiimm de jogo!");
		if(partida.getJogador1().getScore() > partida.getJogador2().getScore())
		{
			System.out.println("O magnífico ganhador do jogo, parabéns meu chapa,  " + partida.getJogador1().getNome());
			System.out.println("Pontuação desse fera: " + partida.getJogador1().getScore() + "pts");

			System.out.println("\nO pequeno loser do jogo, tu foi bad demais,  " + partida.getJogador2().getNome());
			System.out.println("Pontuação da decepção: " + partida.getJogador2().getScore() + "pts");

		} else if(partida.getJogador2().getScore() > partida.getJogador1().getScore())
		{
			System.out.println("O magnífico ganhador do jogo, parabéns meu chapa,  " + partida.getJogador2().getNome());
			System.out.println("Pontuação desse fera: " + partida.getJogador2().getScore() + "pts");

			System.out.println("\nO pequeno loser do jogo, tu foi bad demais,  " + partida.getJogador1().getNome());
			System.out.println("Pontuação da decepção: " + partida.getJogador1().getScore() + "pts");

		} else if(partida.getJogador1().getScore() == partida.getJogador2().getScore())
		{
			System.out.println("Jogo Empatado");
			System.out.println("A memória de vocês estão ruins em?");
			System.out.println("Pontuação: ");
			System.out.println(partida.getJogador1().getNome() + ": " + partida.getJogador1().getScore() + "pts");
			System.out.println(partida.getJogador2().getNome() + ": " + partida.getJogador2().getScore() + "pts");
		}

		System.out.println("===================================");
	}

	public static int nivelDificuldade()
	{
		int nivel = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Escola uma nivel de dificuldade ");
		System.out.println("1 - Facil");
		System.out.println("2 - Medio");
		System.out.println("3 - Dificil");
		int dificuldade = scan.nextInt();

		if(dificuldade == 1)
		{
			nivel = 4;
		} else if(dificuldade == 2)
		{
			nivel = 6;
		} else if(dificuldade == 3)
		{
			nivel = 8;
		} else {
			System.out.println("Nivel inválido!");
		}

		return nivel;
	}

	public static int modoJogo()
	{
		//TODO fazer um tratamento de exceção
		int modo = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Escola o modo de jogo");
		System.out.println("1 - contra CPU");
		System.out.println("2 - Dois jogadores");
		modo = scan.nextInt();

		return modo;
	}
}
