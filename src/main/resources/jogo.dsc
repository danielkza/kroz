Objeto arma : arma
curta="Uma arma perigosa"
longa="Revólver soviético calibre .38. Lustroso."
:::
Objeto cama : cama colchao beliche
curta="Sua cama"
longa="Aqui é onde você vai dormir, para passar o tempo às vezes"
:::
Objeto papel : papel rascunho dica
curta="Um pedaço de papel"
longa="Um pedaço de papel com coisas escritas em português"
acao=ler
:::
Objeto clips : clips clip clipe
curta="Um clips de papel"
longa="Um clips de papel. Pode ser usado para machucar alguém"
acao=furar
:::
Sala cela
curta="Essa é a sua cela"
longa="Sua cela é onde você passará a maior parte do tempo. Tente explorá-la e usar alguns itens, pois podem ser úteis para sua fuga"
saida=GradeCela
contem=(clips, cama, papel)
:::
Saida GradeCela : grade cela porta portao
curta="A grade da cela"
longa="A grade da cela. É a única forma de sair da sua cela"
destino=corredor
:::
Sala corredor
curta="Um corredor próximo à cela"
longa="Um corredor que leva à cela, ao pátio ou ao refeitório"
saida=Spatio
saida=Ecela
contem=(guarda)
:::
Saida Spatio : patio S sul
curta="Uma passagem."
longa="Uma passagem para o pátio. Não há portas"
destino=patio
# :::
# Saida Nrefeitorio : N norte refeitorio
# curta="Saida para o refeitório"
# longa="Saida para o refeitório"
# destino=refeitorio
:::
Saida Ecela : cela
curta="Passagem para a cela"
longa="Passagem para a sua cela"
destino=cela
:::
Sala patio
curta="O pátio da prisão"
longa="O pátio da prisão é onde ficam os outros presos, além de outros objetos importantes"
saida=Ncorredor
saida=Wenfermaria
contem=(zePequeno, scofield)
:::
Saida Ncorredor : corredor N
curta="Saída para o corredor"
longa="Uma sáida para o corredor da prisão"
destino=corredor
:::
Saida Wenfermaria : enfermaria W
curta="Saída para a enfermaria"
longa="Somente pessoas com saúde em mal estado podem entrar na enfermaria"
destino=enfermaria
fechada
:::
Sala enfermaria
curta="Aqui é a Enfermaria"
longa="É na enfermaria que sua fé é renovada!"
contem=(enfermeiro, estilete)
saida=portaDaLiberdade
:::
Saida portaDaLiberdade : liberdade saida
curta="Uma saída da prisão"
longa="O sol bate em seu rosto quando aberta essa saída"
fechada=1
destino=ladoDeFora
:::
Sala ladoDeFora
curta="Você está fora da prisão"
longa="Você está livre. Parabéns... ou não!"
:::
Objeto guarda
curta="É o guarda"
longa="É o guarda que fica no corredor, garantindo a ordem e o fluxo"
contem=(arma)
acao=baterGuarda
:::
Objeto zePequeno
curta="Dadinho"
longa="Dadinho, não; o nome dele é Zé Pequeno. Porra!"
acao=conversarDadinho
:::
acao ler : leia lê
{
"Perdeu a memória? Não tem problema... Você está na prisão de Fox Rivers, por um crime que não cometeu. Seu objetivo é sair daqui e descobrir os responsáveis por essa façanha.";
}
:::
acao furar : fura
{
"Você se furou e agora está precisando de cuidados de enfermagem. Com esse machucado, sua entrada na enfermaria está liberada!";
@Wenfermaria:fechada=0  
}
:::
Objeto scofield
curta="Michael Scofield"
longa="Michael Scofield está em busca de escapar da prisão junto com seu irmão Lincoln"
acao=conversarScofield
:::
acao convesarScofield : conversa fala
{
"Você precisa se furar com alguma coisa, ir à enfermaria e escapar por lá.";
}
:::
acao conversarDadinho : conversa fala
{
"Bata no guarda, pegue as chaves e fuja!";
}
:::
acao bater : bate luta
{
"O que você está fazendo, detento?! Castigo: Solitária! O Jogo acabou por aqui...";
}
:::
Objeto estilete
curta="Algo cortante"
longa="É um estilete"
acao=matar
:::
acao matar : mata ataca
{
"Você matou o enfermeiro! Fuja!";
@enfermeiro:vivo=0
@portaDaLiberdade:fechada=0
}
:::
Objeto enfermeiro
curta="Seu enfermeiro"
longa="Um enfermeiro bem destraído. Facilmente pode ser atacado com algo."
vivo=1
