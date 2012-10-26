package org.ducking_robot.kroz;

import java.util.*;

public class Objeto extends Elemento {
    ArrayList<String> Adjs;        // Adjetivos
    boolean   ativo;            // Existência ou conhecimento
    boolean   visivel;
    
    // Localização
    Elemento  lugar;        // pode ser outro objeto
    Lugar     local;
    
    Objeto(String Nome) {
        this(Nome, "", "");
    }
    
    Objeto(String Nome, String C) {
        this(Nome, C,"");
    }
    
    Objeto(String Nome, String C, String L) {
        super(Nome, C, L);
        Adjs  = new ArrayList<String>();
        
        visivel  = true;
        ativo    = true;
    }
    
    // Adiciona um adjetivo
    void addAdj(String A) {
        Adjs.add(A);
    }    
    
    // Verifica se existe o adjetivo para este objeto
    boolean hasAdj(String A) {
        return Adjs.contains(A);
    }    
    
    // Lista de adjetivos
    ArrayList<String> getAdjs() {
        return this.Adjs;
    }
    
    // Retorna uma String com todos os adjetivos
    String ListAdjs() {
        String s = new String("");
        for(String adj : Adjs) {
            s += adj;
            s += " ";
        }
        
        return s;
    }
    
    Elemento Pos() {
        return lugar;
    }
    
    void Ativa() {
        ativo = true;
    }
    
    void Destiva() {
        ativo = false;
        // retira do mundo..
        Move(null);
    }
    
    // Coloca em outro lugar
    void Move(Elemento l) {
        // retira se estiver em algum lugar
        if (lugar != null) {
            lugar.Retira(this);
        }
        else if (local != null) {
            local.Retira(this);
        }
        
        // Se exisir onde mandar
        if (l != null) 
            l.Inclui(this);
        
        // Arruma os locais
        if (l instanceof Lugar) {
            Reposiciona((Lugar) l);
        }
        else if (l instanceof Objeto) {
            lugar = l;
            Reposiciona(((Objeto) l).local);
        }
        else Reposiciona(null);
    }
    
    void Reposiciona(Lugar l) {
        local = l;
        
        for (Elemento e : Itens) {
            if(e instanceof Objeto) {
                ((Objeto)e).Reposiciona(l);
            }
        }
    }
        
    void Conteudo() { Conteudo("");}
    
    void Conteudo(String tab) {
        Motor.Mostra("(Objeto) " + getIndef() + " " + getNome());
        Motor.Mostra(Listagem(tab));
    }
    
    String Listagem(String tab) {
        HashSet<Objeto> objetos = ListaObjs();
        if(objetos.isEmpty())
            return "";
        
        String s = tab + "Dentro " + getDefI() + " " + getNome() + " existe:\n";
        for(Objeto o : objetos) {
            s += tab + "  " + o.getCurta() + ".\n";
            s += o.Listagem(tab + "   ");
        }
        
        return s;
    }
}
