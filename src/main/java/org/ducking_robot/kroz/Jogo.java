package org.ducking_robot.kroz;

public class Jogo {
    static Animado anima[];	// lista dos elementos que devem ser animados
    static Aventureiro Av = new Aventureiro();
    static Status Status;

    //vaca
    ObjetoAnimado vaca = new ObjetoAnimado("vaca", new AnimaVaca());
    //curral
    Lugar curral = new Lugar("curral");
    //norte
    Saida Ncurral = new Saida("norte");
    //sul
    Saida Scurral = new Saida("sul");
    //corda
    Objeto corda = new Objeto("corda");
    //banco
    Objeto banquinho = new Objeto("banco");
    //balde
    Objeto balde = new Objeto("balde");
    //pasto
    Lugar pasto = new Lugar("pasto");
    //estrada
    Lugar estrada = new Lugar("estrada");


    Jogo() {

        // Verbos
	virar _virar = new virar();
	AnimaVaca _animavaca = new AnimaVaca();


        // Objetos e Lugares
	vaca.setCurta("Uma vaca malhada");
	vaca.setLonga("É uma vaca malhada, com olhos tristes e com uma placa no pescoço escrito `Mimosa'");
	vaca.addProp("viva",new Integer(1));
	vaca.addProp("com_leite",new Integer(0));
	curral.setCurta("Este é o curral da fazenda");
	curral.setLonga("O curral tem algumas cocheiras e está surpreendentemente limpo comparado com o resto da fazenda.  Com certeza, quem quer que cuide daqui, gosta muito de leite.");
	vaca.Move(curral);
	banquinho.Move(curral);
	corda.Move(curral);
	balde.Move(curral);
	curral.addProp("saida",Ncurral);
	curral.addProp("saida",Scurral);
	Ncurral.destino=estrada;
	Ncurral.setCurta("tem uma estrada ao norte");
	Ncurral.setLonga("é uma estrada longa e tortuosa");
	Scurral.destino=pasto;
	Scurral.setCurta("uma porta ao sul");
	Scurral.setLonga("uma porta de madeira velha, caindo aos pedaços, a porta está entreaberta");
	corda.visivel=false;
	corda.setCurta("Uma corda enrolada");
	corda.setLonga("É apenas uma corda....");
	banquinho.setCurta("um banquinho de madeira");
	banquinho.setLonga("Um banquinho de madeira, com três pés, daqueles usados para ordenhar");
	balde.setCurta("um balde");
	balde.setLonga("um balde de alumínio, meio amassado pelo longo uso");
	balde.addProp("vazio",new Boolean(true));
	pasto.setCurta("Pasto do rebanho");
	pasto.setLonga("É um pasto amplo e verde, cheio de vestígios ruminosos espalhados aqui e ali");
	pasto.addProp("saida",Ncurral);
	pasto.addProp("saida",Scurral);
	estrada.setCurta("Estrada do curral");
	estrada.setLonga("Uma estrada longa e bastante sinuosa, que parece levar a terras de além.");
	estrada.addProp("saida",Ncurral);
	estrada.addProp("saida",Scurral);


        // Adjetivos


        // Saidas


        // Verbos específicos
	balde.addVerbo("vire", _virar);
	balde.addVerbo("tombe", _virar);


        Status = new Status();

       // Aventureiro
       Av.Move(curral);

       Animado an[] = {
              vaca,
              Status
	};

	anima = an;

    }


    Elemento Pos() {
        return Av.Pos();
    }

    void Move(Lugar l) {
        Av.Move(l);
    }

}


// virar
class virar extends Verbo
{
     public String getNome() {return "vire";}
     public void acao(Elemento e1) {
      Objeto o = (Objeto) e1;

       Motor.Mostra("Uma corda caiu no chão!  Ela estava dentro do balde, mas não dava para ver");
       Motor.G.corda.visivel=true;;
    }
}


// AnimaVaca
class AnimaVaca extends Verbo
{
     public String getNome() {return "AnimaVaca";}
     public void acao(Elemento e1) {
      Objeto o = (Objeto) e1;

       Motor.Mostra("Muuuu");
    }
}


class Atualiza extends Verbo
{
     public String getNome() {return "Atualiza";}
     public void acao(Elemento o) {
           int rodadas = ++Motor.G.Status.rodadas;
           o.setLonga(rodadas  + " passo" + (rodadas != 1 ? "s." : "."));
     }
}
