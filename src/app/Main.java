package app;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> votos = new HashMap<>();
        System.out.println("Digite o caminho do arquivo: ");
        String arquivo = sc.nextLine();

        try{
         BufferedReader br = new BufferedReader(new FileReader(arquivo));
         String linha = br.readLine();
         while (linha != null) {
             String[] linhas = linha.split(",");
             String nome = linhas[0];
             int contagem = Integer.parseInt(linhas[1]);

             if(votos.containsKey(nome)){
                 votos.put(nome, votos.get(nome)+contagem);
             }
             else {
                 votos.put(nome, contagem);
             }
             linha = br.readLine();
         }
            for(String nome: votos.keySet()){
                System.out.println(nome + " - " + votos.get(nome));
            }



        }catch (IOException e){
            System.out.println("Erro ao abrir arquivo " + e.getMessage());
        }
    }
}