package pt.componentes.node;

/**
 *Árvore
 *
 *@author SerodioJ
*/

import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

public class Tree{
	private Node root;
	private Vector<Integer> keySymptoms;
	private List<String> diseases;
	private int[] priority;

	public Tree(Node root, Vector<Integer> keySymptoms, List<String> diseases, int[] priority){
		this.root = root;
		this.keySymptoms = keySymptoms;
		this.diseases = diseases;
		this.priority = priority;
	}
	
	//Gets e sets
	public Node getRoot() {
		return this.root;
	}
	
	public Vector<Integer> getKey(){
		return this.keySymptoms;
	}
	
	public List<String> getDiseases() {
		return this.diseases;
	}
	
	public int[] getPriority() {
		return this.priority;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
}