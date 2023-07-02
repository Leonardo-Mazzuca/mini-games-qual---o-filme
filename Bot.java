package metodos;

import java.util.*;


public class Bot extends Player{
	
	

	private Random random;
	int indexFilme;

	
	
	public Bot() {
		super();
		
	}
	
	
	@Override
	public String comparador(String nomeDoFilme, String tentativa) {
	    String nomeFilmeTrim = nomeDoFilme.trim();
	    String tentativaTrim = tentativa.trim();

	    if (nomeFilmeTrim.equalsIgnoreCase(tentativaTrim)) {
	        return "Acertou!";
	    } 

	    return super.comparador(nomeFilmeTrim, tentativaTrim);
	}

	
	public String escolheFilme() {
		random = new Random();
		indexFilme = random.nextInt(ListaFilmes.filmes.length);
		String filmes = ListaFilmes.filmes[indexFilme];
		return filmes;
		
//		System.out.println("Peguei um filme aleatorio: " + filmes);
		
		
	}
	
	
	
	public String[] mostraPistas(int index, int qntdMostrar) {
	    String[] caracteristicas = ListaFilmes.caracteristicas[index];
	    String[] pistas = new String[qntdMostrar];

	    for (int i = 0; i < qntdMostrar; i++) {
	        pistas[i] = caracteristicas[i];
	    }

	    return pistas;
	}

	
	
	

	
	}

	
	
	
	
	
	
	
	
