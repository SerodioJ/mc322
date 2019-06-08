package app;
import pt.clubedohardware.userinterface.AnimationC;
import pt.clubedohardware.userinterface.IAnimationC;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAnimationC teste = new AnimationC();
        teste.setWindowName("Clube do Hardware");
        teste.setDocName("Drausio Variola");
        teste.setPacientName("Lucas Farias");
        String[] falas = {"Hi,doc.","Hi, Mr. Zombie, are you fine?","Nope, I have *yellow tongue* and *headache*","Just take an *antibiotic!*"};
        String[] personagem = {"pacient","doctor","pacient","doctor"};
        teste.story(falas,personagem);
        String[] falas2 = {"Hello ,doc.","Hi, Mr. Zombie, are you OK?","Nope, I have *fever* and *pink eyes*","Take a  week of rest and you will be fine!"};
        String[] personagem2 = {"pacient","doctor","pacient","doctor"};
        teste.story(falas2, personagem2);

	}

}
