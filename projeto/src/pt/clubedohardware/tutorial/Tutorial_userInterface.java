package pt.clubedohardware.tutorial;

import pt.clubedohardware.userinterface.*;

// Para fazer todas as animações basta criar um único objeto da classe AnimationC, que implementa 
// a interface IAnimationC (linha 21)

// Os metodos setWindowName(), setDocName(), setPacientName() definem os nomes da janela, do doctor e do
// pacient, respectivamente. Caso não sejam definidos, a janela não terá nome e as personagens terão 
// nomes doctor e pacient. Exemplo nas linhas 25,26,27.

// A partir do momento que há um objeto de AnimationC, para cada nova animação basta chamar o método story() e
// os nomes das personagens e da janela serão as mesmas da última chamada. Mudanças de nomes podem ser feitas
// antes da próxima chamada de story().

public class Tutorial_userInterface {

	public static void main(String[] args) {
		
		// Criando objeto para a animação
		IAnimationC teste = new AnimationC();
		
		// Definindo nome da janela, do doctor e do pacient
		// Procedimento feito sempre antes da chamada de story()
        teste.setWindowName("Clube do Hardware");
        teste.setDocName("Drausio Variola");
        teste.setPacientName("Lucas Farias");
        
        // Vetores de falas e das personagens que estão falando
        // Aqui as personagens só podem ser identificadas como doctor ou pacient
        String[] falas = {"Hi,doc.","Hi, Mr. Zombie, are you fine?","Nope, I have *yellow tongue* and *headache*","Just take an *antibiotic!*"};
        String[] personagem = {"pacient","doctor","pacient","doctor"};
        
        // Primeira animação 
        teste.story(falas,personagem);
        
        // ************************************ NOVA ANIMAÇÃO********************************************** 
        // Para cada nova animação basta chamar novamente o método story() da interface IAnimationC,
        // reutilizando o objeto anterior
        String[] falas2 = {"Hello ,doc.","Hi, Mr. Zombie, are you OK?","Nope, I have *fever* and *pink eyes*","Take a  week of rest and you will be fine!"};
        String[] personagem2 = {"pacient","doctor","pacient","doctor"};
        teste.story(falas2, personagem2);
        
        // ************************************ NOVA ANIMAÇÃO********************************************** 
        // Com mudança de nomes
        teste.setWindowName("Clube do Hardware 2");
        teste.setDocName("Dr. Variola");
        teste.setPacientName("SerOdio");
        String[] falas3 = {"Hello ,doc.","Hi, Mr. Zombie, are you OK?","Nope, I have *fever* and *pink eyes*","Take a  week of rest and you will be fine!"};
        String[] personagem3 = {"pacient","doctor","pacient","doctor"};
        teste.story(falas3, personagem3);
	}

}
