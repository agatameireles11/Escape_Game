/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escape_game;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agata
 */
public class Jogo {
	private int qtdeBombas;
	Scanner ler = new Scanner(System.in);
	List<String> entradas = new ArrayList<>();
	Tabuleiro tabuleiro;
	int linhaAtual = 0, colunaAtual = 0;
	
	public Jogo() {
		String entrada;
		System.out.println("BEM VINDO AO ESCAPE GAME");
		System.out.println("Quantas bombas deseja sortear? ");
		qtdeBombas = ler.nextInt();
		while(qtdeBombas>30 || qtdeBombas<=0) {
			qtdeBombas = ler.nextInt();
		}
		tabuleiro = new Tabuleiro(qtdeBombas);
		System.out.println("A entrada deve ser do tipo: \"(sentido,quantidade)\" ");
		
		do {
			System.out.println("Entrada: ");
			entrada = ler.next();
			while(!(verificaEntrada(entrada))) {
				System.out.println("Entrada invalida digite novamente:");
				entrada = ler.next();
					
				
			}
			entradas.add(entrada);
		}while(jogada(entrada));
		
		
		
	}
	
	public boolean verificaEntrada(String entrada) {
		char[] arrayEntrada = entrada.toCharArray();
	
		if(arrayEntrada[0]!='(') {
			return false;
		}
		if(arrayEntrada[1]!='e' && arrayEntrada[1]!='d' && arrayEntrada[1]!='c' && arrayEntrada[1]!='b') {
			return false;
		}
		if(arrayEntrada[2] != ',') {
			return false;
		}
		//if(arrayEntrada[3] != ' ') {
			//return false;
		//}
		if(arrayEntrada[3] < '1' || arrayEntrada[3] > '9') {
			return false;
		}
		//if(arrayEntrada[3] == '1') {
			//if(arrayEntrada[4]!='0' || arrayEntrada[4]!=')') {
				//return false;
			//}
		//}
		//if(arrayEntrada[4]=='0') {
			//if(arrayEntrada[5]!=')') {
				//return false;
			//}
		//}
		if(arrayEntrada[4]!=')') {
			return false;
		}
		return true;
	}
	
	
	
	
	public boolean jogada(String entrada) {
		int numeroConvertido = entrada.charAt(3) - '0';
		char direcao = entrada.charAt(1);
		
		//int numeroConvertido = Integer.parseInt(num);
		//numeroConvertido--;

		if(direcao == 'd') {
			for(int i = 0; i<numeroConvertido; i++) {
				colunaAtual++;
				if(colunaAtual>9) {
					System.out.println("Caiu do mapa!!\nGAME OVER!!");
					return false;
				}
				if(tabuleiro.retornaPos(linhaAtual, colunaAtual)=='B') {
					System.out.println("BOMBA!!\nGAME OVER!!");
					return false; //para
				}
			}if(tabuleiro.retornaPos(linhaAtual, colunaAtual) == 'S') {
				System.out.println("SAIDA!!\nPARABENS!!");
				return false; //para
			}
			
		}
		if(direcao == 'e') {
			for(int i = 0; i<numeroConvertido; i++) {
				colunaAtual--;
				if(colunaAtual<0) {
					System.out.println("Caiu do mapa!!\nGAME OVER!!");
					return false;
				}
				if(tabuleiro.retornaPos(linhaAtual, colunaAtual)=='B') {
					System.out.println("BOMBA!!\nGAME OVER!!");
					return false; //para
				}
			}if(tabuleiro.retornaPos(linhaAtual, colunaAtual) == 'S') {
				System.out.println("SAIDA!!\nPARABENS!!");
				return false; //para
			}
			
		}
		if(direcao == 'b') {
			for(int i = 0; i<numeroConvertido; i++) {
				linhaAtual++;
				if(linhaAtual>9) {
					System.out.println("Caiu do mapa!!\nGAME OVER!!");
					return false;
				}
				if(tabuleiro.retornaPos(linhaAtual, colunaAtual)=='B') {
					System.out.println("BOMBA!!\nGAME OVER!!");
					return false; //para
				}
			}if(tabuleiro.retornaPos(linhaAtual, colunaAtual) == 'S') {
				System.out.println("SAIDA!!\nPARABENS!!");
				return false; //para
			}
			
		}
		if(direcao == 'c') {
			for(int i = 0; i<numeroConvertido; i++) {
				linhaAtual--;
				if(linhaAtual<0) {
					System.out.println("Caiu do mapa!!\nGAME OVER!!");
					return false;
				}
				if(tabuleiro.retornaPos(linhaAtual, colunaAtual)=='B') {
					System.out.println("BOMBA!!\nGAME OVER!!");
					return false; //para
				}
			}if(tabuleiro.retornaPos(linhaAtual, colunaAtual) == 'S') {
				System.out.println("SAIDA!!\nPARABENS!!");
				return false; //para
			}
			
		}
		tabuleiro.novaPos(linhaAtual, colunaAtual);
		return true;
	}

}
