/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.componentes.userinterface;

/**
 *
 * @author yukiharu
 */
public class testador {
    public static void main(String[] args){
        IAnimation teste = new Animation();
        teste.setWindowName("Clube do Hardware");
        teste.setDocName("Drausio Variola");
        teste.setPacientName("Lucas Farias");
        String[] falas = {"Hi,doc.","Hi, Mr. Zombie, are you fine?","Nope, I have *yellow tongue* and *headache*","Just take an *antibiotic!*"};
        String[] personagem = {"pacient","doctor","pacient","doctor"};
        teste.story(falas,personagem);
        System.out.println("fim");
        teste = new Animation();
        teste.setWindowName("Clube do Hardware");
        teste.setDocName("Drausio Variola");
        teste.setPacientName("Lucas Farias");
        teste.story(falas,personagem);
    }
}
