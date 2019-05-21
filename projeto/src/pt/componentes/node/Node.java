package pt.componentes.node;

/**
 *Nó da árvore
 *
 *@author SerodioJ
*/

public class Node{
	private Node esquerdo, direito;
	private String info;
	private boolean diagnostico;
	
	public Node () {}
	public Node (String info, boolean diagnostico){
		this.info = info;
		this.diagnostico = diagnostico;
	}
	
	//Gets e sets
	public Node getEsquerdo(){
		return this.esquerdo;
	}

	public Node getDireito(){
		return this.direito;
	}

	public String getInfo(){
		return this.info;
	}

	public boolean getDiagnostico(){
		return this.diagnostico;
	}

	public void setEsquerdo(Node esquerdo){
		this.esquerdo = esquerdo;
	}
 
	public void setDireito(Node direito){
		this.direito = direito;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public void setDiagnostico(boolean diagnostico){
		this.diagnostico = diagnostico;
	}
}