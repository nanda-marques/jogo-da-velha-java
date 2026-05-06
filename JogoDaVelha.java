package aula;

import java.util.*;

public class JogoDaVelha {

	    static char[][] matriz = new char[3][3];
	    static int pontosJogador = 0;
	    static int pontosComputador = 0;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        while (true) {
	            jogarPartida();
	            
	            System.out.println("Placar - Jogador: " + pontosJogador + " | Computador: " + pontosComputador);
	            System.out.println("Deseja jogar novamente? (S para Sim, qualquer outra tecla para sair)");
	            String resposta = scanner.next();
	            
	            if (!resposta.equalsIgnoreCase("S")) {
	                System.out.println("Obrigado por jogar! Placar final - Jogador: " + pontosJogador + " | Computador: " + pontosComputador);
	                break; // Encerra o loop se o jogador não quiser continuar
	            }
	        }
	    }

	    private static void jogarPartida() {
			// TODO Auto-generated method stub
	    	matriz = new char[3][3]; // Reinicia o tabuleiro
	        System.out.println("Iniciando nova partida!");

	        while (true) {
	            jogada();
	            System.out.println(exibirTabuleiro());

	            if (JogadorGanhador()) {
	                System.out.println("Você venceu a rodada! Parabéns!");
	                pontosJogador++;
	                break;
	            }

	            if (tabuleiroCheio()) {
	                System.out.println("Empate! A rodada terminou em empate.");
	                break;
	            }

	            jogadaComputador();
	            System.out.println(exibirTabuleiro());

	            if (ComputadorGanhador()) {
	                System.out.println("O computador venceu a rodada!");
	                pontosComputador++;
	                break;
	            }
	        }
		}

		static void jogada() {
	        Scanner s = new Scanner(System.in);
	        System.out.println("Informe a linha 0, 1 ou 2");
	        int linha = s.nextInt();
	        System.out.println("Informe a coluna 0, 1 ou 2");
	        int coluna = s.nextInt();
	        matriz[linha][coluna] = 'X';
	    }

	    static void jogadaComputador() {
	        Random gerador = new Random();

	        int linha, coluna;

	        do {
	            linha = gerador.nextInt(3);
	            coluna = gerador.nextInt(3);
	        } while (matriz[linha][coluna] == 'O' || matriz[linha][coluna] == 'X');

	        matriz[linha][coluna] = 'O';
	    }

	    static String exibirTabuleiro() {
	        String msg = " | 0 | 1 | 2 |\n ------------\n";
	        for (int x = 0; x < matriz.length; x++) {
	            msg += x + " | ";
	            for (int y = 0; y < matriz[x].length; y++) {
	                msg += matriz[x][y] + " | ";
	            }
	            msg += "\n ------------\n";
	        }
	        return msg;
	    }

	    static boolean JogadorGanhador() {
	        if (matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X' ||
	            matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X' ||
	            matriz[1][0] == 'X' && matriz[1][1] == 'X' && matriz[1][2] == 'X' ||
	            matriz[0][2] == 'X' && matriz[1][2] == 'X' && matriz[2][2] == 'X' ||
	            matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X' ||
	            matriz[0][1] == 'X' && matriz[1][1] == 'X' && matriz[2][1] == 'X' ||
	            matriz[2][0] == 'X' && matriz[2][1] == 'X' && matriz[2][2] == 'X' ||
	            matriz[0][2] == 'X' && matriz[1][1] == 'X' && matriz[2][0] == 'X') {
	            return true;            
	        }
	        return false;
	    }
	    static boolean ComputadorGanhador() {
	        if ((matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') ||
	                (matriz[0][0] == 'O' && matriz[1][1] == 'O' && matriz[2][2] == 'O') ||
	                (matriz[1][0] == 'O' && matriz[1][1] == 'O' && matriz[1][2] == 'O') ||
	                (matriz[0][2] == 'O' && matriz[1][2] == 'O' && matriz[2][2] == 'O') ||
	                (matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') ||
	                (matriz[0][1] == 'O' && matriz[1][1] == 'O' && matriz[2][1] == 'O') ||
	                (matriz[2][0] == 'O' && matriz[2][1] == 'O' && matriz[2][2] == 'O') ||
	                (matriz[0][2] == 'O' && matriz[1][1] == 'O' && matriz[2][0] == 'O')) {
	                return true;
	            }
	        return false;
	    }

	    static boolean tabuleiroCheio() {
	        for (int x = 0; x < matriz.length; x++) {
	            for (int y = 0; y < matriz[x].length; y++) {
	                if (matriz[x][y] != 'X' && matriz[x][y] != 'O') {
	                    return false; // Ainda existem espaços vazios
	                }
	            }
	        }
	        return true; // Tabuleiro está cheio
	    }

	    static void msg() {
	        while (true) {
	            jogada();
	            System.out.println(exibirTabuleiro());
	            if (JogadorGanhador()) {
	                System.out.println("Você venceu! Parabéns!");
	                break;
	            }

	            jogadaComputador();
	            System.out.println(exibirTabuleiro());
	            if (ComputadorGanhador()) {
	                System.out.println("O computador venceu! Tente novamente.");
	                break;
	            }

	            if (tabuleiroCheio()) {
	                System.out.println("Empate! O jogo terminou em empate.");
	                break;
	            }
	        }
	    }
	}