package pt.componentes.node;

/**
 *F�brica de n�s
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