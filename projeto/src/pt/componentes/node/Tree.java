package pt.componentes.node;

/**
 *Árvore
 *
 *@author SerodioJ
*/


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.Serializable;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;


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

	public List<Node> toHeap() {
		List<Node> heap = new ArrayList<>();
		Deque<Node> fila = new ArrayDeque<>();
		fila.add(this.root);
		while (!fila.isEmpty()) {
			Node atual = fila.removeFirst();
			heap.add(atual);
			if (atual.getEsquerdo() != null) fila.add(atual.getEsquerdo());
			if (atual.getDireito() != null) fila.add(atual.getDireito());

		}
		return heap;
	}

	public void serializa(String fileName){
		try{
			File dir = new File("projeto\\Saves");
			FileWriter arquivo = new FileWriter(new File(dir, fileName));
			PrintWriter escritor = new PrintWriter(arquivo);
			escritor.println("@Tree");
			escritor.println("Sintomas unicos: " + this.keySymptoms);
			escritor.println("Doencas: "+ this.diseases);
			escritor.println("Prioridade: " + this.priority);
			escritor.println("Nos da Arvore");
			List<Node> heap = this.toHeap();
			int no = 0;
			for(Node node : heap) {
				node.serializa(escritor, no);
				no++;
			}
			arquivo.close();
			System.out.println("Gravacao realizada com sucesso");
		} catch(IOException erro){
			System.out.println("Erro de gravacao");
		}
	}
}

