package pt.componentes.node;

/**
 *Árvore
 *
 *@author SerodioJ
*/


import java.util.List;
import java.io.Serializable;


public class Tree implements Serializable{
	private Node root;
	private List<Integer> keySymptoms;
	private List<String> diseases;
	private List<Integer> priority;

	public Tree(Node root, List<Integer> keySymptoms, List<String> diseases, List<Integer> priority){
		this.root = root;
		this.keySymptoms = keySymptoms;
		this.diseases = diseases;
		this.priority = priority;
	}
	
	//Gets e sets
	public Node getRoot() {
		return this.root;
	}
	
	public List<Integer> getKey(){
		return this.keySymptoms;
	}
	
	public List<String> getDiseases() {
		return this.diseases;
	}
	
	public List<Integer> getPriority() {
		return this.priority;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
}
