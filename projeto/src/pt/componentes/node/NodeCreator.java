package pt.componentes.node;

/**
 *F�brica de n�s
 *
 *@author SerodioJ
*/

public class NodeCreator{
	Node createNode(){
		return new Node();
	}

	Node createNode(String info, boolean diagnostico){
		return new Node(info, diagnostico);
	}
}