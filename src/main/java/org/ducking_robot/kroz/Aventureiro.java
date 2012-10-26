package org.ducking_robot.kroz;

import java.util.*;

public class Aventureiro extends Objeto {
    Aventureiro() {
		super("mim");
		ativo=false;
    }

    void Move(Elemento l) {
		// O aventureiro nunca se inclui de fato nas listas
		
		// Arruma os locais
		if (l instanceof Lugar)
			Reposiciona((Lugar) l);
		else if (l instanceof Objeto)
			Reposiciona(((Objeto) l).local);
		else Reposiciona(null);
    }
	
    Elemento Pos() {
		return local;
    }
	
    Lugar Local() {
		return local;
    }
    
    void DescreveLocal() {
		if (local != null) 
			local.Descreve();
    }
	
    boolean Carrega(Objeto o) {
		return Contem(o);
    }
	
    boolean Visivel(Objeto o) {
		if (Contem(o)) return true;
		if (local != null) 
			return (o.visivel && local.Contem(o));
		return false;
    }

    void Conteudo() { Conteudo("");}

    void Conteudo(String tab) {
    	HashSet<Objeto> objetos = ListaObjs();
    	
    	if(!objetos.isEmpty())
    		Motor.Mostra("Você tem:");
		
    	for(Objeto o : objetos) {
			Motor.Mostra(tab + "  " + o.getCurta() + ".");
			o.Conteudo(tab);
		}
    }
    
    String Listagem() { return Listagem("");}

    String Listagem(String tab) {
		String s = "";
		HashSet<Objeto> objetos = ListaObjs();
		
		for(Objeto o : objetos) {
			s += tab + "  " + o.getCurta() + ".\n";
			s += o.Listagem(tab + "   ");
		}
		return s;
    }
}
