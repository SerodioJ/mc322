package pt.componentes.node;

/**
 *F�brica de n�s
 *
 *@author SerodioJ
 */


public class NodeCreator{
	

	public Node createNode(int symptom, String[] path, boolean esq, int previous){
		return new Node(symptom, path, esq, previous);
	}
	
	public Node createNode(boolean diagnostico, String[] path, boolean esq, int previous){
		return new Node(diagnostico, path, esq, previous);
	}
}