package pt.componentes.node;

/**
 *Fábrica de nós
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