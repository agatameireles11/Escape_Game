/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escape_game;

/**
 *
 * @author agata
 */
import java.util.Scanner;
public class Escape_Game {
   public static void main(String[] args) {
		//Tabuleiro tab = new Tabuleiro(5);
		//tab.imprimeTabuleiro();
		int opcao;
		Scanner ler = new Scanner(System.in);
		Jogo jogo = new Jogo();
		System.out.println("Se deseja jogar de novo pressione 1, senao, pressione outra tecla");
		opcao = ler.nextInt();
		while(opcao ==1) {
			jogo = new Jogo();
		}
		System.out.println("Encerrando...");
		//jogo.verificaEntrada(entrada);

	}
    
}
