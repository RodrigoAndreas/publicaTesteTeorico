/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetopublica;

import java.util.Scanner;

/**
 *
 * @author Rodrigo & Lu
 */
public class Principal {

    public static void main(String[] args) {

        int quantidadeJogos;
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe a quantidade de jogos");
        quantidadeJogos = ler.nextInt();
        int[][] matrizGeral = new int[quantidadeJogos][6];

        for (int i = 0; i < quantidadeJogos; i++) {
            System.out.println("Qual foi a pontuação de Maria no jogo?");
            matrizGeral[i][0] = i + 1; //jogo
            matrizGeral[i][1] = ler.nextInt(); //placar
            if (i == 0) { // primeira vez o minimo e o maximo é o mesmo valor do placar
                matrizGeral[i][2] = matrizGeral[i][1];
                matrizGeral[i][3] = matrizGeral[i][1];
            }
        }
        
        int pontosAtual = 0;
        int menorAtual = 0;
        int maiorAtual = 0;
        int menorAnterior = 0;
        int maiorAnterior = 0;
        int pontosAnterior = 0;
        int contaMax = 0;
        int contaMin = 0;
        
        for (int i = 0; i < quantidadeJogos; i++) {
             contaMax = 0;
             contaMin = 0; 
             pontosAtual = matrizGeral[i][1];
             menorAtual = matrizGeral[i][2];
             maiorAtual = matrizGeral[i][3];
             
             if(pontosAnterior < menorAtual ||  menorAtual==0){
                 if (pontosAnterior < pontosAtual){
                     matrizGeral[i][2] = pontosAnterior;
                 } else{
                     matrizGeral[i][2] = pontosAtual;
                 }
                 if (menorAnterior<pontosAnterior){
                 contaMin = contaMin + 1;
                 }
                 matrizGeral[i][4] =contaMin;
             }
             
             if(pontosAtual > maiorAtual){
                 if (pontosAnterior > pontosAtual){
                     matrizGeral[i][3] = pontosAnterior;
                 } else{
                     matrizGeral[i][3] = pontosAtual;
                 }
                  contaMax = contaMax + 1;
                  matrizGeral[i][5] =contaMax;
             }
             
             pontosAnterior = pontosAtual;
             menorAnterior = menorAtual;
             maiorAnterior = maiorAtual;
        }
        
        
        
        imprimeTabela(matrizGeral);

    }

    public static void imprimeTabela(int[][] matrizGeral) {
        System.out.println("O Placar Geral: ");
        System.out.println("Jogos    |    Placar    |     Min     |       Max    |  Quant. Rec Min. | Quant. Rec Max. ");
        for (int i = 0; i < matrizGeral.length; i++) {
            for (int j = 0; j < matrizGeral[i].length; j++) {
                System.out.print(matrizGeral[i][j] + "              ");
            }
            System.out.println();
        }
    }
}
