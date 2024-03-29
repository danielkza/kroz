package org.ducking_robot.kroz;

public class Motor  {
    static Jogo G;

    public Motor() {
		G = new Jogo();
		G.Av.DescreveLocal();
    }
	
    static public void main(String[] args)
    {
    	fase2(args);
    }
    
    static public void fase2(String[] args)
    {
    	Motor m = new Motor();
    	
    	Motor.Mostra("[pega papel]");
    	G.Av.Pega(G.papel);
    	
    	Motor.Mostra("[leia]");
    	G.papel.getVerbo("leia").acao(G.papel);
    	
    	Motor.Mostra("[pega clips]");
    	G.Av.Pega(G.clips);
    	
    	Motor.Mostra("[fura]");
    	G.clips.getVerbo("fura").acao(G.Av);
    	
    	Motor.Mostra("[enfermaria]");
    	G.Av.Move(G.enfermaria);
    	G.Av.local.Descreve();
    	
    	Motor.Mostra("[pega estilete]");
    	G.Av.Pega(G.estilete);
    	
    	Motor.Mostra("[mata]");
    	G.estilete.getVerbo("mata").acao(G.enfermeiro);
    	
    	Motor.Mostra("[liberdade]");
    	G.Av.Move(G.ladoDeFora);
    	G.Av.local.Descreve();
    }
    
    static public void fase1(String[] args) throws Exception
    {
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
    }
	
    static void Titulo(String s, String t)
    {
    	System.out.println(s + " " + t);
	}
	
    static void Status() {
		String s = G.Status.getLonga();
		System.out.println(s);
    }
	
    static void Inventario()
    {
    	G.Av.Conteudo();
    }
	
    static void Alerta(String s)
    {
    	System.out.println(s);
    }
	
    static void Mostra(String s)
    {
    	System.out.println(s);
    }
}