//package Example;
import java.util.*;
import java.io.*;

public class Motor  {
    static Jogo G;

    public Motor() {
		G = new Jogo();
		G.Av.DescreveLocal();
    }
	
    static public void main(String[] args) throws Exception {
		Motor m = new Motor();
		System.out.println("OBJETOS");
		for(Elemento elem : Elemento.Mundo) 
		{
            if (elem instanceof Objeto) {
                System.out.println("====================================================\n" +
                                   elem.Nome);
                if (!((Objeto)elem).Adjs.isEmpty()) {
                    System.out.print("----------------------------------------------------\n" +
                                       "Apelidos: ");
                    String text = "";
                    for (String string : ((Objeto)elem).Adjs) {
                        text += string + ", ";
                    } 
                    text = text.substring(0, text.length() - 2);
                }
                if(elem.curta.length() != 0)
                {
                    System.out.println("----------------------------------------------------\n" +
                                       "Descrição curta:\n" + 
                                       elem.curta + "\n");
                }
                if(elem.longa.length() != 0)
                {
                    System.out.println("----------------------------------------------------\n" +
                                       "Descrição longa:\n" + 
                                       elem.longa);
                }
                if (!elem.Props.isEmpty()) 
                {
                    System.out.println(
                                   "----------------------------------------------------\n" +
                                   "Propriedades:\n" +
                                   "Chave: Valor");
                    
                    for (String chave : elem.Props.keySet()) {
                        Object valor = elem.Props.get(chave);
                        System.out.println(chave + ": " + valor);
                    }
                }
            }
        }
		System.out.println("LUGARES");
		for(Elemento elem : Elemento.Mundo) {
            if (elem instanceof Lugar) {
                System.out.println("====================================================\n" +
                                   elem.Nome);
                if(elem.curta.length() != 0)
                {
                    System.out.println("----------------------------------------------------\n" +
                                       "Descrição curta:\n" + 
                                       elem.curta + "\n");
                }
                if(elem.longa.length() != 0)
                {
                    System.out.println("----------------------------------------------------\n" +
                                       "Descrição longa:\n" + 
                                       elem.longa);
                }
                if (!elem.Props.isEmpty()) 
                {
                    System.out.println(
                                   "----------------------------------------------------\n" +
                                   "Propriedades:\n" +
                                   "Chave: Valor");
                    
                    for (String chave : elem.Props.keySet()) {
                        Object valor = elem.Props.get(chave);
                        if(valor instanceof Elemento) {
                            System.out.println(chave + ": " + valor.getClass().getSimpleName()
                                               + "(" + ((Elemento)valor).Nome + ")");                            
                        } else {
                            System.out.println(chave + ": " + valor);
                        }
                    }
                }
                if (!((Lugar)elem).Saidas.isEmpty()) 
                {
                    System.out.println(
                                   "----------------------------------------------------\n" +
                                   "Saidas:\n" +
                                   "Chave: Valor");
                    
                    for (String chave : elem.Props.keySet()) {
                        Saida valor = (Saida) elem.Props.get(chave);
                        System.out.println(chave + ": " + valor.Nome);
                    }
                }
            }
        }
		System.out.println("Objetos com animacao:");
        for(Elemento elem : Elemento.Mundo) {
            if (elem instanceof Animado) {
                System.out.println(elem.Nome);
            }
        }
		
		
		
//		for(Elemento elem : Elemento.Mundo) {
//            if (elem instanceof Objeto) {
//                System.out.println("Nome: " + elem.Nome);
//            }
//        }
    }
	
    static void Titulo(String s, String t) {
	}
	
    static void Status() {
		String s = G.Status.getLonga();
    }
	
    static void Inventario() {
    }
	
    static void Alerta(String s) {
    }
	
    static void Mostra(String s) {
    }
}
