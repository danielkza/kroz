package org.ducking_robot.kroz;

import java.util.*;

public class Lugar extends Elemento {
    HashMap<String, Saida> Saidas;	// Conexoes para outros lugares
    boolean visitado;
	
    Lugar(String Nome) {
		this(Nome, "", "");
    }
	
    Lugar(String Nome, String C) {
		this(Nome, C, "");
    }
	
    Lugar(String Nome, String C, String L) {
		super(Nome, C, L);
		Saidas = new HashMap<String, Saida>();
		visitado = false;
    }
	
    public void Descreve() {
		if (!visitado) {
			Longa();
			visitado = true;
		} else {
			Curta();
		}
    }
	
    public void Longa() {
		Motor.Mostra(super.getLonga());
		Saidas();
		Objetos();
    }
	
    public void Curta() {
		Motor.Mostra(super.getCurta());
		Objetos();
    }
	
    // Adiciona uma saida
    void addSaida(String s, Saida l) {
		Saidas.put(s, l);
    }    
	
    // Retorna  uma saida
    Saida getSaida(String s) {
		return Saidas.get(s);
    }    
	
    // Modifica uma saida
    void setSaida(String s, Saida sa) {
		Saidas.put(s, sa);
    }    
	
    // Verifica a presenca da saida
    boolean hasSaida(String s) {
		return Saidas.containsKey(s);
    }
	
    // Verifica se um objeto e visivel
    boolean isVisivel(Objeto o) {
		return Contem(o) && o.visivel;
    }
		
    void Objetos() {
		HashSet<Objeto> v = ListaObjs();
		for (Objeto o : v) {
			Motor.Mostra("\t" + o.getCurta());
			o.Ativa();
			o.Conteudo("\t   ");
		}
    }
	
    void Saidas() {
    	Set<Saida> saidasUnicas = new HashSet<Saida>(Saidas.values());
    	
    	for(Saida s : saidasUnicas)
    		Motor.Mostra(s.getLonga());
    }
 }
