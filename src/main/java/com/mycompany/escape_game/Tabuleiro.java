/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escape_game;

/**
 *
 * @author agata
 */

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	
	private char[][] tabuleiro = new char[10][10]; //matriz pra cartela de bingo 10x10
	List<Integer> linhasSorteadas = new ArrayList<>();
	List<Integer> colunasSorteadas = new ArrayList<>();
	int linha, coluna, linhaSaida, colunaSaida;
	int linhaEnt = 0, colunaEnt = 0;
	public Tabuleiro(int qtdeBombas) {
		
		//preenchendo tudo
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				tabuleiro[i][j] = ' ';
				//System.out.print(tabuleiro[i][j]);
			}
			//System.out.println();
			
		}
		
		
		//ponto inicial
		tabuleiro[0][0] = 'P';
		
		//saida
		linhaSaida = (int) (Math.random() * 9) + 0;
		colunaSaida = (int) (Math.random() * 9) + 0;
		while(linhaSaida == 0 && colunaSaida == 0) {
			linhaSaida = (int) (Math.random() * 9) + 0;
			colunaSaida = (int) (Math.random() * 9) + 0;
		}
		tabuleiro[linhaSaida][colunaSaida] = 'S';
		
		//bombas
		for(int i=0; i<qtdeBombas; i++) {
			sorteiaBombas();
		}
		
		imprimeTabuleiro();
		
		
		
	}
	public boolean verificaRepeticao(int linha, int coluna) {
		for(int i = 0; i<linhasSorteadas.size(); i++) {
			int num = linhasSorteadas.get(i);
			int num2 = colunasSorteadas.get(i);
			if(linha == num && coluna == num2) {
				return false;
			}
		}
		return true;
	}
	
	public void sorteiaBombas() {
		linha = (int) (Math.random() * 9) + 0;
		coluna = (int) (Math.random() * 9) + 0;
		while((linha == 0 && coluna == 0) || (linha == linhaSaida && coluna == colunaSaida) || verificaRepeticao(linha, coluna) == false ) {
			linha = (int) (Math.random() * 9) + 0;
			coluna = (int) (Math.random() * 9) + 0;
		}
		tabuleiro[linha][coluna] = 'B';
	}
	
	public void imprimeTabuleiro() {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				System.out.print(tabuleiro[i][j] + "|");
			}
			System.out.println();
			
		}
	}
	public char retornaPos(int linha, int coluna) {
		return tabuleiro[linha][coluna];
	}
	public void novaPos(int linha, int coluna) {
		tabuleiro[linha][coluna] = 'P';
		tabuleiro[linhaEnt][colunaEnt] = ' ';
		linhaEnt = linha;
		colunaEnt = coluna;
		imprimeTabuleiro();
	}
	
}
