package pt.componentes.node;

/**
 *Fábrica de nós
 *
 *@author SerodioJ
*/


public class NodeCreator{
	

	public Node createNode(int symptom){
		return new Node(symptom);
	}
	
	public Node createNode(boolean diagnostico){
		return new Node(diagnostico);
	}
}