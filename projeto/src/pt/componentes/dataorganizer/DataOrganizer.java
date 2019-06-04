package pt.componentes.dataorganizer;

import pt.componentes.node.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

public class DataOrganizer implements ITreeMaker, IDataFilter {
	
	//Retorna um vetor de sintomas caracter�sticos de uma doen�a
	private Vector<Integer> unique(int[][] symptomFrequency) {
		Vector<Integer> unique = new Vector<>();
		for (int i = 0; i < symptomFrequency.length; i++) {
			int count = 0;
			for (int j = 0; j < symptomFrequency[i].length; j++) {
				if (symptomFrequency[i][j] != 0)
					count++;
			}
			if (count == 1)
				unique.add(i);
		}
		if (unique.size() == 0)
			return null;
		return unique;
	}
	
	//M�todo recursivo para construir a �rvore de diagn�stico.
	private Node treeSkeleton(int symptoms, int current, NodeCreator nC, Vector<Integer> keySymptoms) {
		if (current == symptoms)
			return nC.createNode(true);
		if (keySymptoms.indexOf(current) != -1)
			return treeSkeleton(symptoms, current+1, nC, keySymptoms);
		Node node = nC.createNode(current);
		node.setDireito(treeSkeleton(symptoms, current+1, nC, keySymptoms));
		node.setEsquerdo(treeSkeleton(symptoms, current+1, nC, keySymptoms));
		return node;
	}
	
	//Retorna um vetor de ordem de prioridade para os sintomas na hora da busca na tabela.
	private int[] priority() {}
	
	//M�todo para comparar o caminho da �rvore com a tabela de refer�ncia. Usando o vetor priority para fazer o menor n�mero de compara��es.
	private Vector<Integer> diagnostic(Tree tree, int[] path, int[][] instances){
		
	}
	
	//Percorre a �rvore colocando os diagn�sticos nos n�s-folha
	private Node treeRunner (Node current, Tree tree, int[] path, int[][] instances) {
		if (current.getDiagnostico()) {
			current.setDiseases(diagnostic(tree, path, instances));
			return current;
		}
		current.setDireito(treeRunner(current.getDireito(), tree, path, instances));
		path[current.getSymptom()] = 1;
		current.setEsquerdo(treeRunner(current.getEsquerdo(), tree, path, instances));
		return current;
	}
	
	//
	public Tree treeMaker(List<String> diseases, int[][] symptomFrequency) {
		NodeCreator nC = new NodeCreator();
		Vector<Integer> keySymptoms = unique(symptomFrequency);
		Tree diagnosticTree = new Tree(treeSkeleton(symptomFrequency.length, 0, nC, keySymptoms), keySymptoms, diseases, priority());
		int[] path = new int[symptomFrequency.length];
		for (int i = 0; i < path.length; i++)
			path[i] = 0;
		diagnosticTree.setRoot(treeRunner(diagnosticTree.getRoot(), diagnosticTree, path, instances));
		
		
		
		
		
		
		
		
		
		return diagnosticTree;
	}
}
