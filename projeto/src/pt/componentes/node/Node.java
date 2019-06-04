package pt.componentes.node;

/**
 *Nó da árvore
 *
 *@author SerodioJ
*/

import java.util.Vector;

public class Node{
	private Node esquerdo, direito;
	private int symptom;
	private boolean diagnostico;
	private Vector<Integer> diseases;
	
	public Node (int symptom){
		this.symptom = symptom;
		this.diagnostico = false;
	}
	
	public Node (boolean diagnostico){
		this.diagnostico = diagnostico;
	}
	
	//Gets e sets
	public Node getEsquerdo(){
		return this.esquerdo;
	}

	public Node getDireito(){
		return this.direito;
	}

	public int getSymptom(){
		return this.symptom;
	}

	public boolean getDiagnostico(){
		return this.diagnostico;
	}
	
	public Vector<Integer> getDiseases(){
		return this.diseases;
	}

	public void setEsquerdo(Node esquerdo){
		this.esquerdo = esquerdo;
	}
 
	public void setDireito(Node direito){
		this.direito = direito;
	}

	public void setSymptom(int symptom){
		this.symptom = symptom;
	}

	public void setDiagnostico(boolean diagnostico){
		this.diagnostico = diagnostico;
	}
	
	public void setDiseases(Vector<Integer> diseases) {
		this.diseases = diseases;
	}
}