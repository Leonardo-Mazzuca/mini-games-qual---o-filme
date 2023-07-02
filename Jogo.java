package metodos;

import java.util.*;

public class Jogo {
	
	
	public String nomeDoFilme;
	public static String[] pistas = new String[5];
	public int pontos;
	
	
	public void leitorDePistas() {
		List<String> listaDePistas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int r = 0;
		for (int i = 0; i<pistas.length; i++) {
			if (i == 0) {
				r = 1;
			} else {
				r++;
			}
			System.out.println(r + "° Pista: ");
			String pista = scanner.nextLine();
			listaDePistas.add(pista);
			
		}
		
		pistas = listaDePistas.toArray(new String[listaDePistas.size()]);
		
	}
	
	public String[] mostraPistas(String pistas[], int qntPistas) {
		String[] pistasMostrar = new String[qntPistas];
		for (int i = 0; i < qntPistas; i++) {
			pistasMostrar[i] = pistas[i];

		}
		return pistasMostrar;
		
	}
	
	public String comparador(String nomeDoFilme, String filmeComparar) {

		if (nomeDoFilme.trim().equalsIgnoreCase(filmeComparar.trim())) {
			return "Acertou!";
		}
		return "Errou!";
	}
	
	//conta os pontos atravéz da quantidade de pistas exibidas
	public void contaPontos(int qntPistas) {
		if (qntPistas == 1) {
			  this.pontos += 480;
		} else if (qntPistas == 2) {
			  this.pontos += 360;
		} else if (qntPistas == 3) {
			  this.pontos += 240;
		} else if (qntPistas == 4) {
			  this.pontos += 120;
		} else {
			  this.pontos += 60;
		}
		
	}
	
	public int mostraPontos(){
		return this.pontos;
	}
		

	

}


class TestaJogo{
	
	public static void main(String[] args) {
		
		
		Player p = new Player();
		Player p2 = new Player();
		Bot b = new Bot();
		Scanner s = new Scanner(System.in);
		String[] pistasDoJogo = {};
		int quantidadeDePistasMostrar = 0, pontosPerdeu = 60, pontosSomar = 0;
		boolean acertou = false, jogarNovamente = false;
		char confirm, resp;

		
		do {
			
			
			acertou = false;
			quantidadeDePistasMostrar = 0;
			
			
			
			System.out.println("===QUAL É O FILME?===");
			System.out.println("Adivinhe qual é o nome do filme através das pistas!");
			System.out.println("Melhor pontuação: " + pontosSomar);
			System.out.println();
			System.out.println("Selecione 'S' para começar");
			resp = s.next().toUpperCase().charAt(0);
			while(resp != 'S') {
				System.out.println("Digite apenas 'S' : " );
				resp = s.next().toUpperCase().charAt(0);
			}
			
			System.out.println();
			System.out.println("Você esta jogando contra um bot.");
			System.out.println();
			
			System.out.println("Digite um nickname: ");
			String nickName = s.next();
			
			p = new Player(nickName);
			b = new Bot();
			System.out.println();
			
			String nomeFilme = b.escolheFilme();
			int indexDoFilmeEscolhido = b.indexFilme;
			
			String[] primeiraPista = b.mostraPistas(indexDoFilmeEscolhido, 1);
			System.out.println("1° pista; " + primeiraPista[0]);
			System.out.println(p.player + " , Qual o nome do filme: ");
			String tentativa = s.nextLine(); 
			
			while(!acertou) {
				
				quantidadeDePistasMostrar++;
				if (quantidadeDePistasMostrar > 5) {
					System.out.println("Perdeu!");
					System.out.println("Nome do filme: " + nomeFilme);
					pontosPerdeu -= p.pontos;
					if(p.pontos == 0) {
						pontosPerdeu = 0;
						pontosPerdeu -= p.pontos;
					}
					System.out.println("Você perdeu: " + pontosPerdeu);
					System.out.println("Pontuação atual: " + p.pontos);
					break;
				}
				
				
				
				String[] pistas =  b.mostraPistas(indexDoFilmeEscolhido, quantidadeDePistasMostrar);
				for(int i = 1; i < quantidadeDePistasMostrar; i++) {
					if(i == 1) {
						System.out.println(i +"° Pista: " + primeiraPista[0]);
					}
				    System.out.println((i + 1) + "° Pista: " + pistas[i]);
				}
				
				if(!(tentativa.isEmpty()))
				System.out.println(p.player + " , Qual o nome do filme: ");
				tentativa = s.nextLine(); 
				
				
				String resultado = b.comparador(nomeFilme, tentativa);
				
				if(resultado.equalsIgnoreCase("Acertou!")) {
					System.out.println(resultado);
					p.contaPontos(quantidadeDePistasMostrar);
					System.out.println("Sua pontuação: " + p.mostraPontos());
					acertou = true;
					
					System.out.println("Jogar novamente? S/N:");
					confirm = s.next().toUpperCase().charAt(0);
					while(confirm!='S' && confirm !='N') {
						System.out.println("S/N:");
						confirm = s.next().toUpperCase().charAt(0);
					}
					if(confirm == 'S') {
						jogarNovamente = true;
						pontosSomar += p.pontos;
						
					} else if (confirm == 'N') {
						jogarNovamente = false;
					}
					
					
				} else {
					System.out.println(resultado);
				}
				
				
				
				}
		
			}while(jogarNovamente);
		
		
		System.out.println("Pontuação final: " + pontosSomar);
		
		}
	}

	

